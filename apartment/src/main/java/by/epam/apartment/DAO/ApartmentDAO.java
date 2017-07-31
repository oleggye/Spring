package by.epam.apartment.DAO;

import java.util.List;

import by.epam.apartment.bean.Apartment;

public interface ApartmentDAO {

	public void add(Apartment object);

	public void update(Apartment object);

	public void delete(Apartment object);

	public Apartment getById(Number id);

	public List<Apartment> getAll();
}