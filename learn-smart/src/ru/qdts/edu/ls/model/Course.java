package ru.qdts.edu.ls.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class Course implements Describable {

	protected int id;
	protected String title;	
	protected int duration;
	protected String branch;
	protected String[] tags = new String[10];
	public Course(int id, String title, int duration, String branch) {
		super();
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.branch = branch;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getDuration() {
		return duration;
	}
	public String getBranch() {
		return branch;
	}
	
	@Override
	public String getDescription(Format format) {
		String desc = "Описание недостпно", template;
		switch (format) {
			case SHORT -> {
				template = """
						Курс %d
						Название %s
						Продолжительность %d
						""";
				desc = String.format(template, id, title, duration);						
			}
			case FULL -> {
				template = """
						Курс %d
						Название %s
						Продолжительность %d
						Направление %s
						""";
				desc = String.format(template, id, title, duration, branch);
				StringBuilder sb = new StringBuilder(desc);
				sb.append("Теги:");
				for(String tag : tags) {
					if(tag != null && tag.length() != 0) 
						sb.append(" ").append(tag);
				}
				desc = sb.toString();
			}
		}
		return desc;
	}
}
