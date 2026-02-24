package com.tejait.batch15.controller;

import java.io.IOException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.tejait.batch15.service.FileService;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("file")
public class FileController {
	
	
	FileService service;
	
	@PostMapping("/upload")
	
	public ResponseEntity<String> uploadfile(@RequestParam("file")MultipartFile file) throws IOException{
		
	       String   message =service.uploadfile(file);
	       
		   return ResponseEntity.status(HttpStatus.CREATED).body(message);
		
	}
	
	
	

    }

	

	

