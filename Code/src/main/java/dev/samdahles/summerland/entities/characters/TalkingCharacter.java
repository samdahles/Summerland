package dev.samdahles.summerland.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import dev.samdahles.summerland.Story.Affiliation;

public class TalkingCharacter extends MoveableCharacter {
		
	public TalkingCharacter(String name, String charFolder, Coordinate2D anchorLocation, Size size, int row, int column, Affiliation affiliation) {
		super(name, charFolder, anchorLocation, size, row, column, affiliation);
	}
	
	
	public String getHead() {
		return this.charFolder + "Head.png";
	}
	
	
}
