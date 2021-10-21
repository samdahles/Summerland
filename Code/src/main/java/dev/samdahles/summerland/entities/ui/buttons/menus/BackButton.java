package dev.samdahles.summerland.entities.ui.buttons.menus;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class BackButton extends Button {
	private int targetScene;
	
	
	/**
	 * Creates a button with a fixed text of 'BACK' in white RobotoBlack.
	 * @param initialPosition position of the button
	 * @param size font size of the button
	 * @param targetScene scene which should be set if the button is clicked
	 * @param core the core object
	 */
    public BackButton(Coordinate2D initialPosition, int size, int targetScene, Core core) {
        super(core, initialPosition, size, "BACK", Color.WHITE, "RobotoBlack", false);
        this.targetScene = targetScene;
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		core.setActiveScene(targetScene);
	}
}
