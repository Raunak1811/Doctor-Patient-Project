package com.raunak.patientmicroservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AdditionalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(AdditionalException.class)
	public ResponseEntity<Object> detailsNotFoundException(Exception e,WebRequest wr)
	{
		FeedbackException fe = new FeedbackException(new Date(),e.getMessage(),wr.getDescription(false));
		return new ResponseEntity<Object>(fe,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}