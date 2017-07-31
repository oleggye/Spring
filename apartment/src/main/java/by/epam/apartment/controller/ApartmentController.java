package by.epam.apartment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.epam.apartment.service.ApartmentService;

@RestController
@RequestMapping("/{apartmentId}")
public class ApartmentController {

	@Autowired
	private ApartmentService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(@PathVariable String apartmentId, ModelMap map) {
		map.addAttribute("apartmentId",apartmentId);
		return "index";
	}
	
}
