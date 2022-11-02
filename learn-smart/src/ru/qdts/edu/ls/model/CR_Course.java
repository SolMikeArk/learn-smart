package ru.qdts.edu.ls.model;

public class CR_Course extends Course {
	private String location;

	public CR_Course(int id, String title, int duration, String branch, String location) {
		super(id, title, duration, branch);
		this.location = location;
	}
	
	@Override
	public String getDescription(Format format) {
		String desc = super.getDescription(format);
		return desc + "Место проведения: " + location;
	}
}
