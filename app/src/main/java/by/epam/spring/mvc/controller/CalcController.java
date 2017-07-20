package by.epam.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculate")
public class CalcController {

	@GetMapping
	public ModelAndView calculate(@RequestParam(value = "first", required = true) int first,
			@RequestParam("second") int second) {
		System.out.println("CALCULATE EXECUTED!");

		ModelAndView modelAndView = new ModelAndView("displaySum");
		modelAndView.addObject("sum", Integer.toString(first + second));

		return modelAndView;
	}

	/*
	 * @ExceptionHandler(Exception.class)
	 * 
	 * @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) private ModelAndView
	 * onException(Exception exception) {
	 * 
	 * 
	 * }
	 */

	/*
	 * @RequestMapping("/calculate") public ModelAndView
	 * calculate(HttpServletRequest request) { System.out.println("calculate");
	 * 
	 * String first = request.getParameter("first"); String second =
	 * request.getParameter("second");
	 * 
	 * int sum = 0;
	 * 
	 * ModelAndView modelAndView = new ModelAndView("displaySum");
	 * 
	 * if (first != null && second != null) { int firstInt =
	 * Integer.parseInt(first); int secondInt = Integer.parseInt(second); sum =
	 * firstInt + secondInt; }
	 * 
	 * modelAndView.addObject("sum", Integer.toString(sum));
	 * 
	 * return modelAndView; }
	 */
}
