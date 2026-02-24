package com.tejait.batch15.serviceimpl;


import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tejait.batch15.model.FileUpload;
import com.tejait.batch15.repository.FileRepositary;
import com.tejait.batch15.service.FileService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService {
	
	private FileRepositary repositary;

	@Override
	public String uploadfile(MultipartFile file) throws IOException {
		
		FileUpload fe=new FileUpload();
		
		fe.setFilename(file.getOriginalFilename());
	
         fe.setFiletype(file.getContentType());	
         fe.setData(file.getBytes());
         repositary.save(fe);
		
		return "file Upload Sucessfully into DB";
	}

	@Override
	public String uploadfile() {
		
		return null;
	}

	
		
		
	

	

	
	

}
