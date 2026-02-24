package com.tejait.batch15.Exceptions;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalException {
	

	@ExceptionHandler(IdnotFoundException.class)
	public ResponseEntity<ErrorDetails> IdnotFoundException(HttpServletRequest request){
		
		Date date=new Date();
		ErrorDetails error=new ErrorDetails(date,407, "IdnotFound", "Given id not Available", request.getRequestURI());
		System.out.println(error);
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
		
	}
	@ExceptionHandler(MobileAlreadyExists.class)
	public ResponseEntity<ErrorDetails> MobileAlreadyExsist(HttpServletRequest request){	
		Date date= new Date();
		ErrorDetails error=new ErrorDetails(date, 409,"Mobile already exsists","given mobile already excists",request.getRequestURI());
		System.out.println(error);
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(MailAlreadyExcistException.class)
	public ResponseEntity<ErrorDetails> MailAlreadyExcists(HttpServletRequest request){
	
		
		ErrorDetails error=new ErrorDetails(new Date(), 410, "Mail Already Excists", "Given Mail Already Excists", request.getRequestURI());
		return new ResponseEntity<> (error,HttpStatus.BAD_GATEWAY);
		
	}
	
	public ResponseEntity<ErrorDetails> globalExceptionMethod(HttpServletRequest request){
		
		ErrorDetails error=new ErrorDetails(new Date(), 501, "Something went wrong","unknown errors" , request.getRequestURI());
		return new ResponseEntity<> (error,HttpStatus.BAD_REQUEST);
		
	
		
		
	}
	
}
