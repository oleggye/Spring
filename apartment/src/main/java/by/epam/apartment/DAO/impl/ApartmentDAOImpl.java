package by.epam.apartment.DAO.impl;

import java.util.List;

import by.epam.apartment.DAO.ApartmentDAO;
import by.epam.apartment.bean.Apartment;

public class ApartmentDAOImpl extends AbstractHibernateDAO<Apartment> implements ApartmentDAO {

	public ApartmentDAOImpl() {
		super(Apartment.class);
	}

	@Override
	public void add(Apartment object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Apartment object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Apartment object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Apartment getById(Number id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Apartment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
