package dev.samdahles.summerland.entities.ui.buttons.menus.main;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import javafx.scene.input.MouseButton;

public class QuitButton extends Button {
	
	
	/**
	 * Creates a button with fixed text of 'Quit'. This button flashes on hover.
	 * The program exits on click of this button.
	 * @param core the core object
	 * @param initialPosition position of the button
	 * @param size font size of the button
	 */
    public QuitButton(Core core, Coordinate2D initialPosition, int size) {
        super(core, initialPosition, size, "Quit", "Roboto", true);
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		this.core.quit();
	}
}