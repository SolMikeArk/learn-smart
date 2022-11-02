package ru.qdts.edu.ls.model;

public interface CourseCatalog extends AutoCloseable {
	public int add(Course course) throws CatalogNotOpenedException;
	public void delete(int id) throws CatalogNotOpenedException;
	public Course findById(int id) throws CatalogNotOpenedException;
	public Course[] findByName(String name) throws CatalogNotOpenedException;
	public int open();
	
	@Override
	public void close();
}
