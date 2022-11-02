package ru.qdts.edu.ls.model;

public interface Describable {
	enum Format {SHORT, FULL}
	
	String getDescription(Format format);
}
