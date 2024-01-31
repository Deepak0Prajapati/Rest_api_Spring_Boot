package com.Backend.Exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
			Map<String, Object> body=new LinkedHashMap<>();
			body.put("TimeStamp", System.currentTimeMillis());
			body.put("Status", status.value());
			
			List<String> errors=ex.getBindingResult()
								.getAllErrors()
								.stream()
								.map(x->x.getDefaultMessage())
								.collect(Collectors.toList());
			body.put("errors", errors);
			
			return new ResponseEntity<Object>(body,status);
		
	}

}
