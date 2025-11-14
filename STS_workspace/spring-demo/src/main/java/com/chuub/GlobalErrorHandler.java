package com.chuub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
	@ExceptionHandler(exception = Exception.class)
	private Map<String,String> handleException(MethodArgumentNotValidException exception) {
		Map<String, String> errorMap = new HashMap();
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		errorList.forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			errorMap.put(fieldName, message);
		});
		return errorMap;
//		Object[] errors = exception.getDetailMessageArguments();
//		for(int i =0; i<errors.length;i++) {
//			errorMap.put(null, null)
//		}
	}
}
