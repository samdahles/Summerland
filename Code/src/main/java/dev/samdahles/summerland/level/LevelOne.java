package dev.samdahles.summerland.level;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.characters.CommonCharacters;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.entities.characters.TalkingCharacter;
import dev.samdahles.summerland.interactables.Interactable;
import javafx.util.Pair;

public class LevelOne extends Level {
	/**
	 * Level One is the first level of the game. Nate appears here alongside Rhett.
	 * 
	 * @param core
	 */
	public LevelOne(Story story) {
		super(story);
	}

	@Override
	public void setupLevel(Story story) {
		if (story.getCurrentAreaX() == 1 && story.getCurrentAreaY() == 1) {
			TalkingCharacter rhett = CommonCharacters.getRhett();
			rhett.setAnchorLocationY(350);
			rhett.setAnchorLocationX(200);

			Interactable rhettDialog1 = new Interactable(story, rhett) {
				public void run() {
					story.setDialogCharacter(rhett);
					story.setDialog(new String[] { "Hi Nate!", "How have you been?" });
					story.setDialogScene();
				}
			};

			rhett.setInteract(rhettDialog1);

			
			this.addCharacter(rhett);
		}
		
		PlayableCharacter nate = CommonCharacters.getNate(story);
		this.addCharacter(nate);
		nate.setAnchorLocationY(15);
	}
}
