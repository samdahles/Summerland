package dev.samdahles.summerland.entities.ui.buttons.menus.main;

import java.util.concurrent.TimeUnit;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import javafx.scene.input.MouseButton;

public class ContinueButton extends Button {
	
	private Coordinate2D initialPosition;
	private double moveUpWhenClicked;
    public ContinueButton(Core core, Coordinate2D initialPosition, int size, double moveUpWhenClicked) {
        super(core, initialPosition, size, "Continue", "Roboto", true);
        this.initialPosition = initialPosition;
        this.moveUpWhenClicked = moveUpWhenClicked;
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		this.core.setActiveScene(core.SCENE_GAME);
		System.out.println("Continue");	
	}
}
