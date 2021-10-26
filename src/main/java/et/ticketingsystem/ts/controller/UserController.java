package et.ticketingsystem.ts.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import et.ticketingsystem.ts.service.UserService;
import et.ticketingsystem.ts.util.CustomValidationException;
import et.ticketingsystem.ts.util.ErrorMessage;
import et.ticketingsystem.ts.util.UserNotFoundExcption;
import et.ticketingsystem.ts.model.User;

@RestController
//@RequestMapping(consumes="application/json;charset=UTF-8")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/users")
	public void create(@Valid @RequestBody User user) throws CustomValidationException {
		// if (userService.findByUserId(user.getUserId()) != null)

		if (user.getUserId() != null && user.getFirstName() != null && user.getMiddleName() != null
				&& user.getLastName() != null && userService.findByUserId(user.getUserId()) != null)
			userService.save(user);
		else if (userService.findByUserId(user.getUserId()) != null)
			throw new CustomValidationException("User cant be created. Enter Unique ID.");
		else
			throw new ErrorMessage("400","User not created! ");
	}

	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(ValidationException.class) public ErrorMessage
	 * exceptionHandler(ValidationException e) { return new ErrorMessage("400",
	 * e.getMessage()); }
	 */

	@GetMapping("/users")
	Iterable<User> retrieve() throws ErrorMessage {
		if (userService.count() != 0)
			return userService.findAll();
		else
			throw new UserNotFoundExcption("Users not found!");

	}

	@GetMapping("/users/{userId}")
	Optional<User> retrieveById(@PathVariable String userId) {
		Optional<User> user = userService.findByUserId(userId);
		if (!user.isPresent())
			throw new UserNotFoundExcption("User not found!");

		return user;

	}

	@PutMapping("/users")
	public void update(@RequestBody User user) {

		if (user.getUserId() != null && user.getFirstName() != null && user.getMiddleName() != null
				&& user.getLastName() != null)
			userService.save(user);
		else
			throw new ValidationException("User cant be created");
	}

	@DeleteMapping("users/{id}")
	public void delete(@PathVariable int id) {
		userService.deleteById(id);
	}

	@DeleteMapping("users")
	public void delete() {
		userService.deleteAll();
	}

}
