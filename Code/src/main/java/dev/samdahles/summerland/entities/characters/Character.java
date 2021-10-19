package dev.samdahles.summerland.entities.characters;

import java.util.HashMap;
import java.util.Map;

import com.github.hanyaeger.api.entities.Direction;

public class Character {
	
	public static enum Affiliation {
		GOOD,
		BAD
	}
	
	private String characterPath;
	private String name;
	private Affiliation affiliation;
	
	public Character(String characterPath, String name, Affiliation affiliation) {
		this.characterPath = characterPath;
		this.name = name;
		this.affiliation = affiliation;
	}
	
	
	public String getAnimationPath() {
		return characterPath + "Walk.png";
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getHeadPath() {
		return this.characterPath + "Head.png";
	}
	
	public Affiliation getAffiliation() {
		return this.affiliation;
	}
}
