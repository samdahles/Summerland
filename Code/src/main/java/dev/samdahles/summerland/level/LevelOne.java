package dev.samdahles.summerland.level;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.characters.CommonCharacters;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;

public class LevelOne extends Level {
	/**
	 * Level One is the first level of the game. Nate appears here alongside Rhett.
	 * @param core 
	 */
	public LevelOne(Story story) {
		super(story);
	}

	@Override
	public void setupLevel(Story story) {
		
		PlayableCharacter nate = CommonCharacters.getNate(story);
		MoveableCharacter rhett = CommonCharacters.getRhett();
		
		nate.setAnchorLocationY(15);
		rhett.setAnchorLocationY(100);
				
		rhett.setInteract(new Runnable() {
		    Story story;
		    MoveableCharacter character;
		    
		    @Override                            
		    public void run() {
		    	this.story.inheritSetDialogCharacter(this.character.getName());
		    	String[] dialog = {
		    			"Hi Nate! How have you been?"
		    	};
		    	
		    	this.story.inheritSetDialog(dialog);
		    	this.story.inheritSetDialogScene();
		    	
		    }
		    
		    public Runnable init(Story story, MoveableCharacter character) {
		    	this.character = character;
		    	this.story = story;
		    	return (this);
		    }

		}.init(this.story, rhett));
		
		
		this.addCharacter(nate);
		this.addCharacter(rhett);
		
	}
}
