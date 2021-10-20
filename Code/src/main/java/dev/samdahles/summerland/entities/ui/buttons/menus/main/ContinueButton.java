package dev.samdahles.summerland.entities.ui.buttons.menus.main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.characters.Character.Affiliation;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import dev.samdahles.summerland.entities.characters.Character;
import javafx.scene.input.MouseButton;

public class ContinueButton extends Button {
	

    public ContinueButton(Core core, Coordinate2D initialPosition, int size, double moveUpWhenClicked) {
        super(core, initialPosition, size, "Continue", "Roboto", true);

    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {

		// OPTIONAL: move up when clicked
		System.out.println("Continue");
		
		
		Map<Character, String> initDialog = new HashMap<Character, String>();
		
		initDialog.put(core.characterList.get(Core.NATE), "Hello.");
		initDialog.put(core.characterList.get(Core.RHETT), "Hello.");
		initDialog.put(core.characterList.get(Core.NATE), "Let's play.");
		
		
		this.core.dialogScene.setup(initDialog, Affiliation.GOOD, "Images/MainMenuBackground.jpg");
		this.core.setActiveScene(Core.SCENE_GAME);

	}
}
