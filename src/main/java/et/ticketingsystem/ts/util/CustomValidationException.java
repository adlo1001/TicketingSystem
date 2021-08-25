package et.ticketingsystem.ts.util;

import javax.validation.ValidationException;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomValidationException extends ValidationException {

	public CustomValidationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
