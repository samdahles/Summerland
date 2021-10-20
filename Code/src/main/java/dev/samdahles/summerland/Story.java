package dev.samdahles.summerland;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.KeyListener;


import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.tilemaps.CustomTileMap;
import javafx.scene.input.KeyCode;

public class Story {
	/*
	Map<Character, String> initDialog = new HashMap<Character, String>();
	
	initDialog.put(core.characterList.get(Core.NATE), "Hello.");
	initDialog.put(core.characterList.get(Core.RHETT), "Hello.");
	initDialog.put(core.characterList.get(Core.NATE), "Let's play.");
	
	
	this.core.dialogScene.setup(initDialog, Affiliation.GOOD, "Images/MainMenuBackground.jpg");
	this.core.setActiveScene(Core.SCENE_DIALOG);
	*/
	
	//this.core.setActiveScene(Core.SCENE_GAME);
	
	public static enum Affiliation {
		GOOD,
		BAD
	}
	
	private Core core;
	
	public Story(Core core) {
		this.core = core;
		this.startLevelOne();
		core.gameScene.setPlayableCharacter(
				new PlayableCharacter(new Coordinate2D(1,1), "Nate", "CharSprites/Nate/")
				);
	}

	
	public void addCharacter(MoveableCharacter character) {
		core.gameScene.addCharacter(character);
	}
	
	public void startLevelOne() {
		// core.gameScene.setTilemap(new CustomTileMap("2-3"));
		core.setActiveScene(Core.SCENE_GAME);
		// TODO: Set up entities
		this.addCharacter(new MoveableCharacter(
				"Rhett", 
				"CharSprites/Rhett/", 
				new Coordinate2D(1,2),
				Core.GENERIC_SIZE,
				4, 3,
				Affiliation.GOOD
				));
	}
	
	public void save() {
		// TODO: Serialize Story
	}
	
	public void saveAndMainMenu() {
		this.save();
		this.core.setActiveScene(Core.SCENE_MAINMENU);
	}
	
	
	
}
