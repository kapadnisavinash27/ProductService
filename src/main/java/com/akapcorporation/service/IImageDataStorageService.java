package com.akapcorporation.service;


import org.springframework.web.multipart.MultipartFile;

public interface IImageDataStorageService {

	//public String uploadImage(MultipartFile file);
	public String uploadimage(MultipartFile file);
	public byte[] findimage(Long id);
}
