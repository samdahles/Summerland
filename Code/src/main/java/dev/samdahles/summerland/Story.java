package dev.samdahles.summerland;

import java.io.Serializable;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.level.Level;
import dev.samdahles.summerland.level.LevelOne;

public class Story implements Serializable {
	/*
	Map<Character, String> initDialog = new HashMap<Character, String>();
	
	initDialog.put(core.characterList.get(Core.NATE), "Hello.");
	initDialog.put(core.characterList.get(Core.RHETT), "Hello.");
	initDialog.put(core.characterList.get(Core.NATE), "Let's play.");
	
	
	this.core.dialogScene.setup(initDialog, Affiliation.GOOD, "Images/MainMenuBackground.jpg");
	this.core.setActiveScene(Core.SCENE_DIALOG);
	*/
	
	//this.core.setActiveScene(Core.SCENE_GAME);
	
	/**
	 * Affiliations for characters in the game. 
	 * Can be either {@link #GOOD} or {@link #BAD}
	 */
	public static enum Affiliation {
		GOOD,
		BAD
	}
	
	private Core core;	
	public Level currentLevel;
	private int currentAreaX;
	private int currentAreaY;
	private Coordinate2D currentPlayerPos;
	
	
	/**
	 * Story is the object that effectively resembles a savegame.
	 * It is responsible for keeping track of the {@code currentLevel} and the entities in it.
	 * @param core the core object
	 */
	public Story(Core core) {
		this.core = core;
		this.currentLevel = new LevelOne();
		this.currentAreaY = 1;
		this.currentAreaX = 1;
	}
	
	public void setCurrentArea(int areaX, int areaY) {
		this.currentAreaY = areaY;	
		this.currentAreaX = areaX;
	}
	
	public int getCurrentAreaX() {
		return currentAreaX;
	}
	
	public int getCurrentAreaY() {
		return currentAreaY;
	}
	
	public void setCurrentPlayerPos(Coordinate2D currentPos) {
		this.currentPlayerPos = currentPos;
	}
	
	public Coordinate2D getCurrentPlayerPos() {
		return currentPlayerPos;
	}
	
	public Boolean switchMapArea(Direction direction) {
		core.setActiveScene(4);
		return false;
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
