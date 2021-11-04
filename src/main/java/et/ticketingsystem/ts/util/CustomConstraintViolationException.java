package et.ticketingsystem.ts.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomConstraintViolationException extends ConstraintViolationException{

	public String message="Constriant Violations";
	public CustomConstraintViolationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
