package dev.samdahles.summerland;

import java.io.Serializable;

import com.github.hanyaeger.api.Coordinate2D;

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
	
	public static enum Affiliation {
		GOOD,
		BAD
	}
	
	private Core core;	
	public Level currentLevel;
	
	public Story(Core core) {
		this.core = core;
		this.currentLevel = new LevelOne();
		
	}
	
	public void save() {
		// TODO: Serialize Story
	}
	
	public void saveAndMainMenu() {
		this.save();
		this.core.setActiveScene(Core.SCENE_MAINMENU);
	}
	
	
	
}
