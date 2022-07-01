package com.simactivation.aspects;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simactivation.Exceptions.CustomerAndSimCustomException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Map<String,String>> validationException(HttpMessageNotReadableException ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("error Message", "please pass valid data");
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> validationException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(CustomerAndSimCustomException.class)
	public ResponseEntity<Map<String,String>> invalidSimDetails(CustomerAndSimCustomException ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("ErrorMessage :", ex.getMessage());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String,String>> allExceptions(Exception ex){
		Map<String, String> errors = new HashMap<>();
		errors.put("ErrorMessage :", ex.getMessage());
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
