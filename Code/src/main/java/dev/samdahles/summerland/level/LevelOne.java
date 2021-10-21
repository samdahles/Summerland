package dev.samdahles.summerland.level;

import com.github.hanyaeger.api.entities.Direction;

import dev.samdahles.summerland.entities.characters.CommonCharacters;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;

public class LevelOne extends Level {
	
	public LevelOne() {
		super();
	}

	@Override
	public void setupLevel() {
		
		PlayableCharacter nate = CommonCharacters.getNate();
		MoveableCharacter rhett = CommonCharacters.getRhett();
		
		nate.setAnchorLocationY(15);
		rhett.setAnchorLocationY(100);
		
		this.addCharacter(nate);
		this.addCharacter(rhett);
		
	}
}
