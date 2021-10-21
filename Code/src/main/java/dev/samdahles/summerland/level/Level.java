package dev.samdahles.summerland.level;

import java.util.ArrayList;

import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;

public abstract class Level {
	public ArrayList<MoveableCharacter> entityList = new ArrayList<MoveableCharacter>();
	public PlayableCharacter playableCharacter;
	
	
	protected Level() {
		this.setupLevel();
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
	
	public abstract void setupLevel();
}
