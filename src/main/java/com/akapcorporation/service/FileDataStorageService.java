package com.akapcorporation.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.akapcorporation.entity.FileData;
import com.akapcorporation.repository.FileDataRepository;

@Service
public class FileDataStorageService implements IFileDataStorageService {

	@Autowired
	private FileDataRepository fileDataRepository;

	private final String FOLDER_PATH = "C:/Users/Avinash/Desktop/ImageStorage/";

	@Override
	public String uploadImageToFileSystem(MultipartFile file) {

		String filePath = FOLDER_PATH + file.getOriginalFilename();

		FileData fileData = fileDataRepository.save(FileData.builder().name(file.getOriginalFilename())
				.type(file.getContentType()).filePath(filePath).build());

		try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (fileData != null) {
			return "file uploaded successfully : " + filePath;
		}
		return null;

	}

	public byte[] downloadImageFromFileSystem(String fileName) {
		Optional<FileData> fileData = fileDataRepository.findByName(fileName);

		String filePath = fileData.get().getFilePath();
		byte[] images;
		try {
			images = Files.readAllBytes(new File(filePath).toPath());
			return images;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
