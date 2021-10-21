package dev.samdahles.summerland.entities.ui.buttons.menus.main;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.MouseButton;
import javafx.util.Duration;

public class ContinueButton extends Button {
	private Core core;

    public ContinueButton(Core core, Coordinate2D initialPosition, int size, double moveUpWhenClicked) {
        super(core, initialPosition, size, "Continue", "Roboto", true);
        this.core = core;
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		
		this.confirmSound.play();
		core.OST.stop();
		
		
		// TODO: OPTIONAL: move up when clicked
		System.out.println("Continue");
			
		this.core.setActiveScene(Core.SCENE_GAME);
	}
}
