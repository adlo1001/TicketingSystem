package et.ticketingsystem.ts.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import et.ticketingsystem.ts.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userrService;

	@RequestMapping(value = { "/Home", "/home", "/" })
	public ModelAndView get() throws IOException {
		ModelAndView mav = new ModelAndView("home");
		return mav;

	}

}
