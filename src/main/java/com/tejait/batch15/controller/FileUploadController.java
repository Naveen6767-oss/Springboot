package com.tejait.batch15.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tejait.batch15.service.FileService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("fileUpload")
public class FileUploadController {


	FileService service;
	
	@PostMapping("uploadfile")
	public ResponseEntity<String> uploadFile(@RequestParam ("file")MultipartFile file){
		                   String Message = service.uploadfile();
		
		return  ResponseEntity.status  (HttpStatus.CREATED).body(Message);
		
		
	}
	
	  
    }
	
	
	
	
	
	
	
	
	
	
	
	
	

