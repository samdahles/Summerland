package dev.samdahles.summerland.entities.buttons.mainmenu;

import com.github.hanyaeger.api.Coordinate2D;
import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.buttons.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class Settings extends Button {
    public Settings(Coordinate2D initialPosition, int size, Core core) {
        super(initialPosition, size, "Settings", Color.BLACK, core);
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		//core.setActiveScene(core.SCENE_GAME);
		System.out.println("Settings");
	}
}