package by.epam.apartment.bean;

public class Apartment {

	private long id;
	private String name;

	public Apartment() {
	}

	public Apartment(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", name=" + name + "]";
	}
}