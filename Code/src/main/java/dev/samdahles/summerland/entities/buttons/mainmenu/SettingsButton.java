package dev.samdahles.summerland.entities.buttons.mainmenu;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.buttons.Button;
import javafx.scene.input.MouseButton;

public class SettingsButton extends Button {
    public SettingsButton(Core core, Coordinate2D initialPosition, int size) {
        super(core, initialPosition, size, "Settings");
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		this.core.setActiveScene(Core.SCENE_SETTINGS);
	}
}
