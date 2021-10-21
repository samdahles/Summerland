package dev.samdahles.summerland.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story.Affiliation;

public class CommonCharacters {
	public static final PlayableCharacter getNate() {
		return new PlayableCharacter(new Coordinate2D(1,1), "Nate", "CharSprites/Nate/");
	}
	
	public static final MoveableCharacter getRhett() {
		return new MoveableCharacter(
				"Rhett", 
				"CharSprites/Rhett/", 
				new Coordinate2D(1,1),
				Core.GENERIC_SIZE,
				4, 3,
				Affiliation.GOOD
				);
	}
	
	
}
