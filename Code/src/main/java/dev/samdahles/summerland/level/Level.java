package dev.samdahles.summerland.level;

import java.util.ArrayList;

import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;


/**
 * 
 * A Level is responsible for handling all characters at a time.
 * This class simplifies having different entities at a given time.
 * This class is abstract and should be extended by a custom level e.g. {@link LevelOne}.
 *
 */
public abstract class Level {
	public ArrayList<MoveableCharacter> entityList = new ArrayList<MoveableCharacter>();
	public PlayableCharacter playableCharacter;
	public Story story;

	protected Level(Story story) {
		this.setupLevel(story);
	}
	
	public void addCharacter(MoveableCharacter character) {
		this.entityList.add(character);
	}
	
	public void removeCharacter(MoveableCharacter character) {
		character.remove();
		this.entityList.remove(character);
	}
	
	public void setPlayableCharacter(PlayableCharacter character) {
		this.playableCharacter = character;
	}
	
	public void destroyCharacters() {
		for(MoveableCharacter character : this.entityList) {
			character.remove();
		}
		
		this.playableCharacter.remove();
	}
	
	/**
	 * This method should be used to create all entities.
	 * 
	 * @param story
	 */
	public abstract void setupLevel(Story story);
}
