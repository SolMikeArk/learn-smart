package ru.qdts.edu.ls.model;

public class CatalogNotOpenedException extends Exception {
	public CatalogNotOpenedException() {
		super("Catalog must be initialized before use");
	}
	
	public CatalogNotOpenedException(String message) {
		super(message);
	}

}
