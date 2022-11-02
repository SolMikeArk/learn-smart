package ru.qdts.edu.ls.model;

public class ILO_Course extends Course {
	private String platform;

	public ILO_Course(int id, String title, int duration, String branch, String platformName) {
		super(id, title, duration, branch);
		this.platform = platformName;
	}
	
	@Override
	public String getDescription(Format format) {
		String desc = super.getDescription(format);
		return desc + "Система видеоконференций: " + platform;
	}
}
