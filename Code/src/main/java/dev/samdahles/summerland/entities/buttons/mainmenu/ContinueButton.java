package dev.samdahles.summerland.entities.buttons.mainmenu;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.buttons.Button;
import javafx.scene.input.MouseButton;

public class ContinueButton extends Button {
    public ContinueButton(Core core, Coordinate2D initialPosition, int size) {
        super(core, initialPosition, size, "Continue");
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		//this.core.setActiveScene(core.SCENE_GAME);
		System.out.println("Continue");
	}
}