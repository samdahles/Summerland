package dev.samdahles.summerland;

import java.io.Serializable;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.level.Level;
import dev.samdahles.summerland.level.LevelOne;

public class Story implements Serializable {
	private Core core;	
	public Level currentLevel;
	
	/**
	 * Affiliations for characters in the game. 
	 * Can be either {@link #GOOD} or {@link #BAD}
	 */
	public static enum Affiliation {
		GOOD,
		BAD
	}
		
	/**
	 * Story is the object that effectively resembles a savegame.
	 * It is responsible for keeping track of the {@code currentLevel} and the entities in it.
	 * @param core the core object
	 */
	public Story(Core core) {
		this.core = core;
		this.currentLevel = new LevelOne(core);
		
	}
	
	
	/** Serializes story and saves (and possibly overwrites) {@link src/main/resources/Savegame.ser} */
	public void save() {
		// TODO: Serialize Story
	}
	
	
	/** Shortcut for {@link #save()} and setting the active scene to {@link dev.samdahles.summerland.scenes.menus.MainMenuScene} **/
	public void saveAndMainMenu() {
		this.save();
		this.core.setActiveScene(Core.SCENE_MAINMENU);
	}
	
	
	
}
