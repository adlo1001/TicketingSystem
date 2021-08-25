package et.ticketingsystem.ts.util;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UserNotFoundExcption extends RuntimeException {

	public UserNotFoundExcption(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
