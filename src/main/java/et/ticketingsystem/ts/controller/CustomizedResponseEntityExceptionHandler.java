package et.ticketingsystem.ts.controller;

import java.util.Date;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import et.ticketingsystem.ts.util.CustomConstraintViolationException;
import et.ticketingsystem.ts.util.CustomValidationException;
import et.ticketingsystem.ts.util.ErrorMessage;
import et.ticketingsystem.ts.util.ExceptionResponse;
import et.ticketingsystem.ts.util.UserNotFoundExcption;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);// All errors throw with this
																						// status code.
	}

	@ExceptionHandler(UserNotFoundExcption.class)
	public final ResponseEntity<Object> handleUserNotException(UserNotFoundExcption ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);// All errors throw with this status code.
	}

	@ExceptionHandler(ErrorMessage.class)
	public final ResponseEntity<Object> handleBadRequestException(ErrorMessage ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);// All errors throw with this status code.
	}

	
	@ExceptionHandler(CustomValidationException.class)
	public final ResponseEntity<Object> handleValidationException(CustomValidationException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);// All errors throw with this status code.
	}


	@ExceptionHandler(CustomConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstriantViolationException(CustomConstraintViolationException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);// All errors throw with this status code.
	}

}
