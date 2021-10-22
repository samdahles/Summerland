package dev.samdahles.summerland.level;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.characters.CommonCharacters;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.entities.characters.TalkingCharacter;
import dev.samdahles.summerland.interactables.Interactable;

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
		TalkingCharacter rhett = CommonCharacters.getRhett();
		
		nate.setAnchorLocationY(15);
		rhett.setAnchorLocationY(100);
		
		Interactable rhettDialog1 = new Interactable(story, rhett) {
			public void run() {
				story.setDialogCharacter(rhett);
				story.setDialog(new String[] {
						"Hi Nate!",
						"How have you been?"
				});
				story.setDialogScene();
			}
		};
		
		
		rhett.setInteract(rhettDialog1);
		
		
		this.addCharacter(nate);
		this.addCharacter(rhett);
		
	}
}
