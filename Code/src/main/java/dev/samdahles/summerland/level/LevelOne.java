package dev.samdahles.summerland.level;

import com.github.hanyaeger.api.entities.Direction;

import dev.samdahles.summerland.Core;
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
		
		rhett.setInteract(new Runnable() {
			public void run() {
				System.out.println("Sample Runnable");
			}
		});
		
		nate.setAnchorLocationY(15);
		rhett.setAnchorLocationY(100);
		
		this.addCharacter(nate);
		this.addCharacter(rhett);
		
	}
}
