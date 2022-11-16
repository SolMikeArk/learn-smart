package ru.qdts.edu.ls.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CourseList<T extends Course> extends ArrayList<T> {
	
	public CourseList(List<T> list) {
		super(list);
	}
	public double maxRating() {
		double candidate = 0;
		Iterator<T> i = iterator();
		while(i.hasNext()) {
			Course c = i.next();
			if(candidate < c.getRating())
				candidate = c.getRating();
		}
		return candidate;
	}
	public void sortByDuration() {
		sort((Comparator<T>) (c1,c2) -> c1.getDuration() - c2.getDuration());
	}
}
