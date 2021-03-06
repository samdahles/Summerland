package dev.samdahles.summerland.entities.characters;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.Story.Affiliation;
/**
 * CommonCharacters is a class with static methods that return a {@link MoveableCharacter} 
 */	
public class CommonCharacters {
	public static final PlayableCharacter getNate(Story story) {
		return new PlayableCharacter(new Coordinate2D(1,1), "Nate", "CharSprites/Nate/", story);
	}
	
	public static final TalkingCharacter getRhett() {
		return new TalkingCharacter(
				"Rhett", 
				"CharSprites/Rhett/", 
				new Coordinate2D(1,1),
				Core.GENERIC_SIZE,
				Affiliation.GOOD
				);
	}
	
	public static final TalkingCharacter getHeggard() {
		return new TalkingCharacter(
				"Heggard",
				"CharSprites/Heggard",
				new Coordinate2D(1,1),
				Core.GENERIC_SIZE,
				Affiliation.BAD
				);
	}
	
	
}
