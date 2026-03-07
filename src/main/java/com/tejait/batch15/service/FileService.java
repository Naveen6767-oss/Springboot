package com.tejait.batch15.service;

import java.io.IOException;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;





public interface FileService {

       

		String uploadfile(MultipartFile file) throws IOException;

		String uploadfile();

	

}
