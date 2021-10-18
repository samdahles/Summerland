package dev.samdahles.summerland.entities.ui.buttons.menus.settings;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import javafx.scene.input.MouseButton;

public class FullscreenButton extends Button {
	private boolean state = false;
    public FullscreenButton(Core core, Coordinate2D initialPosition, int size) {
        super(core, initialPosition, size, "Fullscreen OFF", AnchorPoint.TOP_RIGHT, "PressStart2P", false);
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		if(state) {
			this.setText("Fullscreen OFF");
			// Turn off fullscreen
		} else {
			this.setText("Fullscreen ON");
			// Turn on fullscreen
		}
		state = !state;
	}
}
