package ru.qdts.edu.ls.model;

import java.util.List;

public interface CourseCatalog extends AutoCloseable {
	public int add(Course course) throws CatalogNotOpenedException;
	public void delete(int id) throws CatalogNotOpenedException;
	public Course findById(int id) throws CatalogNotOpenedException;
	public Course[] findByName(String name) throws CatalogNotOpenedException;
	public List<Course> getAll() throws CatalogNotOpenedException;
	public int open();
	
	@Override
	public void close();
}
