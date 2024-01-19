package com.akapcorporation.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.akapcorporation.entity.ImageData;
import com.akapcorporation.repository.ImageDataRespository;
import com.akapcorporation.utils.ImageUtils;

@Service
public class ImageDataStorageServiceImp implements IImageDataStorageService{
	
	//private final String Folder="C:/Users/Avinash/Desktop/ImageStorage";
	
	@Autowired
	private ImageDataRespository repo;
	
	
	@Override
	public byte[] findimage(Long id) {
	
		Optional<ImageData>fd= repo.findById(id);
		byte[] image= fd.get().getImagedata();
		return image;
	}
	
	
	public String uploadimage(MultipartFile file) {
		try {
			repo.save(ImageData.builder()
					.filename(file.getOriginalFilename())
					.type(file.getContentType())
					.imagedata(ImageUtils.compressImage(file.getBytes())).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Image of Product is succesfully uploaded";
	}
	

	
	
}
