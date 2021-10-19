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
	private boolean hasAnimation;
	
	public Character(String characterPath, String name, Affiliation affiliation, boolean hasAnimation) {
		this.characterPath = characterPath;
		this.name = name;
		this.affiliation = affiliation;
		this.hasAnimation = hasAnimation;
	}
	
	public Character(String characterPath, String name, Affiliation affiliation) {
		this.characterPath = characterPath;
		this.name = name;
		this.affiliation = affiliation;
		this.hasAnimation = false;
	}
	
	public Map<Direction, String[]> getAnimationPaths() {
		Map<Direction, String[]> animationPaths = new HashMap<Direction, String[]>();
		Map<Direction, String> compassDirections = new HashMap<Direction, String>();
		
		compassDirections.put(Direction.UP, "N");
		compassDirections.put(Direction.RIGHT, "E");
		compassDirections.put(Direction.DOWN, "S");
		compassDirections.put(Direction.LEFT, "W");
		
		if(this.hasAnimation) {
			for(Map.Entry<Direction, String> direction : compassDirections.entrySet()) {
				String path = this.characterPath + direction.getValue();
				animationPaths.put(direction.getKey(), 
						new String[] {path + "_1", path + "_2", path + "_3"});
			}
		} else {
			for(Map.Entry<Direction, String> direction : compassDirections.entrySet()) {
				String path = this.characterPath + direction.getValue();
				animationPaths.put(direction.getKey(), 
						new String[] {path, path, path});
			}
		}
		return animationPaths;
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
