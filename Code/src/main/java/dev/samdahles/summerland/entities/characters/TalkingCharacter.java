package dev.samdahles.summerland.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import dev.samdahles.summerland.Story.Affiliation;


public class TalkingCharacter extends MoveableCharacter {
	/**
	 * 
	 * A TalkingCharacter is a MoveableCharacter that has a Head.png in it's resource folder.
	 * @param name the name of the character
	 * @param charFolder the resource folder where Walk.png is located
	 * @param anchorLocation the initial location of the character
	 * @param size the size of the character
	 * @param row the number of sprites divided over the x-axis
	 * @param column the number of sprites divided over the y-axis
	 * @param affiliation the {@link Affiliation} that the character has
	 */
	public TalkingCharacter(String name, String charFolder, Coordinate2D anchorLocation, Size size, int row, int column, Affiliation affiliation) {
		super(name, charFolder, anchorLocation, size, row, column, affiliation);
	}
	
	/** 
	 * Get the Head.png location of a TalkingCharacter.
	 * @return A string representing the path of the Head.png image.
	 */
	public String getHead() {
		return this.charFolder + "Head.png";
	}
	
	
}
