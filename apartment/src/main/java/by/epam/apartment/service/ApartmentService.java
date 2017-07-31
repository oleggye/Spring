package by.epam.apartment.service;

import java.util.List;

import by.epam.apartment.bean.Apartment;

public interface ApartmentService {
	
	public Apartment getById(long id);

	public List<Apartment> getAll();
}