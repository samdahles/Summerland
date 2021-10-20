package dev.samdahles.summerland.entities.ui.buttons.menus.main;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import javafx.scene.input.MouseButton;

public class ContinueButton extends Button {
	

    public ContinueButton(Core core, Coordinate2D initialPosition, int size, double moveUpWhenClicked) {
        super(core, initialPosition, size, "Continue", "Roboto", true);

    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {

		// TODO: OPTIONAL: move up when clicked
		System.out.println("Continue");
		
		
		// TODO: Check if Serialized object is in resources
		Story story = new Story(core);
		core.gameScene.setStory(story);
			
		this.core.dialogScene.setup(initDialog, Affiliation.GOOD, "Images/MainMenuBackground.jpg");
		this.core.setActiveScene(Core.SCENE_GAME);
	}
}
