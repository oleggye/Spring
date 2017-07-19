package by.epam.spring.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalcController {

	@RequestMapping("/calculate")
	public ModelAndView calculate(HttpServletRequest request) {
		System.out.println("calculate");
		return null;
	}
}
