package dev.samdahles.summerland;

import java.io.Serializable;
import java.util.Date;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.level.Level;
import dev.samdahles.summerland.level.LevelOne;

public class Story implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8189187705636449254L;
	private Core core;
	public Level currentLevel;
	private int currentAreaX;
	private int currentAreaY;
	private Coordinate2D currentPlayerPos;
	private long previousSwitchTimestamp = new Date().getTime() / 1000;

	/**
	 * Affiliations for characters in the game. Can be either {@link #GOOD} or
	 * {@link #BAD}
	 */
	public static enum Affiliation {
		GOOD, BAD
	}

	/**
	 * Story is the object that effectively resembles a savegame. It is responsible
	 * for keeping track of the {@code currentLevel} and the entities in it.
	 * 
	 * @param core
	 * @param core the core object
	 */
	public Story(Core core) {
		this.core = core;
		this.currentAreaY = 1;
		this.currentAreaX = 1;
		this.currentPlayerPos = new Coordinate2D(1,1);
		this.currentLevel = new LevelOne(this);
	}

	public void inheritSetDialogScene() {
		this.core.setActiveScene(Core.SCENE_DIALOG);
	}

	public void inheritSetDialog(String[] dialog) {
		this.core.dialogScene.setDialog(dialog);
	}

	public void inheritSetDialogCharacter(String characterName) {
		this.core.dialogScene.setCharacter(characterName);
	}

	public void inheritSetGameScene() {
		this.core.setActiveScene(Core.SCENE_GAME);
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

	public void setCurrentPlayerPos(Coordinate2D currentPos, PlayableCharacter character) {
		this.currentPlayerPos = currentPos;
		character.setAnchorLocation(currentPlayerPos);
	}

	public Coordinate2D getCurrentPlayerPos() {
		return currentPlayerPos;
	}

	public Boolean switchMapArea(Direction direction, PlayableCharacter character) {
		int lastAreaX = getCurrentAreaX();
		int lastAreaY = getCurrentAreaY();
		
		long switchTimestamp = new Date().getTime() / 1000;
		
		if (switchTimestamp - this.previousSwitchTimestamp >= 2) {
			this.previousSwitchTimestamp = switchTimestamp;
			this.currentPlayerPos = character.getAnchorLocation();
			System.out.print(currentPlayerPos.toString());
			
			if (direction == Direction.UP && getCurrentAreaX() > 1) {
				setCurrentPlayerPos(new Coordinate2D(currentPlayerPos.getX(), 860), character);
				setCurrentArea(currentAreaX - 1, currentAreaY);
			} else if (direction == Direction.DOWN && getCurrentAreaX() < 3) {
				setCurrentPlayerPos(new Coordinate2D(currentPlayerPos.getX(), 5), character);
				setCurrentArea(currentAreaX + 1, currentAreaY);
			} else if (direction == Direction.LEFT && getCurrentAreaY() > 1) {
				setCurrentPlayerPos(new Coordinate2D(930, currentPlayerPos.getY() + 20), character);
				setCurrentArea(currentAreaX, currentAreaY - 1);
			} else if (direction == Direction.RIGHT && getCurrentAreaY() < 3) {
				setCurrentPlayerPos(new Coordinate2D(3, currentPlayerPos.getY() - 20), character);
				setCurrentArea(currentAreaX, currentAreaY + 1);
			}

			if (lastAreaX == getCurrentAreaX() && lastAreaY == getCurrentAreaY()) {
				return false;
			} else {
				core.setActiveScene(Core.SCENE_SWITCH);
				return true;
			}
		}
		return false;
	}

	/**
	 * Serializes story and saves (and possibly overwrites)
	 * {@link src/main/resources/Savegame.ser}
	 */
	public void save() {
		// TODO: Serialize Story
	}

	/**
	 * Shortcut for {@link #save()} and setting the active scene to
	 * {@link dev.samdahles.summerland.scenes.menus.MainMenuScene}
	 **/
	public void saveAndMainMenu() {
		this.save();
		this.core.setActiveScene(Core.SCENE_MAINMENU);
	}

}
