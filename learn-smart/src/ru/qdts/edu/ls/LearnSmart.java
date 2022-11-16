package ru.qdts.edu.ls;

import java.nio.file.Path;

import ru.qdts.edu.ls.model.CR_Course;
import ru.qdts.edu.ls.model.CatalogNotOpenedException;
import ru.qdts.edu.ls.model.Course;
import ru.qdts.edu.ls.model.CourseCatalog;
import ru.qdts.edu.ls.model.CourseList;
import ru.qdts.edu.ls.model.CourseCalalogImpl1;
import ru.qdts.edu.ls.model.Describable.Format;

public class LearnSmart {

	public static void main(String[] args) {
		Thread memMon = new MemMon();
		memMon.start();
		
		Thread clp = new CLProcessor();
		clp.start();
		
		Course c = null;
		try(CourseCatalog catalog = new CourseCalalogImpl1()) {
				catalog.open();
				c = catalog.findById(2);
				var cl = new CourseList<Course>(catalog.getAll());
				
		} catch (CatalogNotOpenedException e) {
			e.printStackTrace();
		}
						
		System.out.println(c.getDescription(Format.FULL));
		
		
	}

}
