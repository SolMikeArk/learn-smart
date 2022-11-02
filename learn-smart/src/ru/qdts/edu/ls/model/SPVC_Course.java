package ru.qdts.edu.ls.model;

public class SPVC_Course extends Course {
	private String lms;

	public SPVC_Course(int id, String title, int duration, String branch, String lms) {
		super(id, title, duration, branch);
		this.lms = lms;
	}
	
	@Override
	public String getDescription(Format format) {
		String desc = super.getDescription(format);
		return desc + "Система дистанционного обучения: " + lms;
	}
}
