package dev.samdahles.summerland.level;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.characters.CommonCharacters;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;

public class LevelOne extends Level {
	/**
	 * Level One is the first level of the game. Nate appears here alongside Rhett.
	 */
	public LevelOne(Core core) {
		super(core);
	}

	@Override
	public void setupLevel() {
		
		PlayableCharacter nate = CommonCharacters.getNate();
		MoveableCharacter rhett = CommonCharacters.getRhett();
		
		nate.setAnchorLocationY(15);
		rhett.setAnchorLocationY(100);
				
		rhett.setInteract(new Runnable() {
		    Core core;
		    MoveableCharacter character;
		    
		    @Override                            
		    public void run() {
		    	this.core.dialogScene.setCharacter(character.getName());
		    	String[] dialog = {
		    			"Hi Nate! How have you been?"
		    	};
		    	
		    	this.core.dialogScene.setDialog(dialog);
		    	this.core.setActiveScene(Core.SCENE_DIALOG);
		    }
		    
		    public Runnable init(Core core, MoveableCharacter character) {
		    	this.character = character;
		    	this.core = core;
		    	return (this);
		    }

		}.init(core, rhett));
		
		
		this.addCharacter(nate);
		this.addCharacter(rhett);
		
	}
}
