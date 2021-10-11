package dev.samdahles.summerland;

public class Person {
	private String name;
	private String DialogHeadImagePath;
	
	protected Person(String name, String DialogHeadImagePath) {
		this.name = name;
		this.DialogHeadImagePath = DialogHeadImagePath;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getHeadImagePath() {
		return this.DialogHeadImagePath;
	}
}
