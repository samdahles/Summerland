package dev.samdahles.summerland.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class BackButton extends Button {
	private int targetScene;
	
    public BackButton(Coordinate2D initialPosition, int size, int targetScene, Core core) {
        super(core, initialPosition, size, "<-", Color.BLACK);
        this.targetScene = targetScene;
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		core.setActiveScene(targetScene);
	}
}
