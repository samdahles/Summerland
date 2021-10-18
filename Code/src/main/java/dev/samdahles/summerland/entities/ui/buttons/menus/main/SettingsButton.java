package dev.samdahles.summerland.entities.ui.buttons.menus.main;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import javafx.scene.input.MouseButton;

public class SettingsButton extends Button {
    public SettingsButton(Core core, Coordinate2D initialPosition, int size) {
        super(core, initialPosition, size, "Settings", "Roboto", true);
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		this.core.setActiveScene(Core.SCENE_SETTINGS);
	}
}
