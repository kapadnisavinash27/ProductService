package com.akapcorporation.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileDataStorageService {
	 public String uploadImageToFileSystem(MultipartFile file) ;
	 public byte[] downloadImageFromFileSystem(String fileName) ;
}
