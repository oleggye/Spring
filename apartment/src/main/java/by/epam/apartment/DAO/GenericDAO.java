package by.epam.apartment.DAO;

import java.util.List;

public interface GenericDAO<E> {

	public void add(E object);

	public void update(E object);

	public void delete(E object);

	public E getById(Number id);

	public List<E> getAll();
}