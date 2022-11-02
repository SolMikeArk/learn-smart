package ru.qdts.edu.ls.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class CourseCalalogImpl1 implements CourseCatalog {
	
	private static final String WORK_DIR = "courses";
	private static final String[] FILE_NAMES = {"javaProg.prop" , "jsProg.prop", "pythonProg.prop",
		"cppProg.prop", "kotlinProg.prop"};
	
	private Course[] catalog = null;
	
	public CourseCalalogImpl1() {}
	
	@Override
	public int open() {
		catalog = new Course[100];
		
		Path file;
		int i =0;
		for(String s : FILE_NAMES) {
			file = Path.of(WORK_DIR, s);
			catalog[i++] = load(file);
		}
		
		return i-1;
	}
	
		
	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	private Course load(Path file) {
		Properties courseProp = new Properties();
		try {
			var fileIn = new FileInputStream(file.toFile().getCanonicalPath());
			courseProp.load(fileIn);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Course(
				Integer.parseInt(courseProp.getProperty("id")),
				courseProp.getProperty("title"),
				Integer.parseInt(courseProp.getProperty("duration")),
				courseProp.getProperty("duration"));
	}

	@Override
	public int add(Course course) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Course findById(int id) throws CatalogNotOpenedException {
		if(catalog == null)
			throw new CatalogNotOpenedException();
		
		for(Course c : catalog) {
			if(c != null && c.getId() == id)
				return c;
		}
		return null;
	}

	@Override
	public Course[] findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}

