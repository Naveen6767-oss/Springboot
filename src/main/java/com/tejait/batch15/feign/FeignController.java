package com.tejait.batch15.feign;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping
public class FeignController {
	
	TypiFeign typiFeign;
	
	@GetMapping("getComments")
	public ResponseEntity<List<CommentsDto>> getComments(){
		
	List<CommentsDto> comments=typiFeign.getComments();
	
	return new ResponseEntity<> (comments, HttpStatus.OK);
		
		
	}
	
	@GetMapping()
	
	public ResponseEntity<List<CommentsDto>> getPosts(){
		
		List<CommentsDto> Posts=typiFeign.getPosts();
		
		return new ResponseEntity<> (Posts, HttpStatus.OK);

}

}
