package com.akapcorporation.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.akapcorporation.service.IImageDataStorageService;

@RestController
@RequestMapping("/image")
public class ImageDataController {

	@Autowired
	IImageDataStorageService filestorage;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadimage(@RequestParam("image") MultipartFile file) {

		String msg = filestorage.uploadimage(file);

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> fetchimage(@PathVariable Long id){
		
		byte[] imagedata=filestorage.findimage(id);
		
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/jpg")).body(imagedata);
	}
	
	
}
