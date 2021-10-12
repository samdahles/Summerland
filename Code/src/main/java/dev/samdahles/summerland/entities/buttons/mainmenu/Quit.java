package dev.samdahles.summerland.entities.buttons.mainmenu;

import com.github.hanyaeger.api.Coordinate2D;
import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.buttons.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public class Quit extends Button {
    public Quit(Coordinate2D initialPosition, int size, Core core) {
        super(initialPosition, size, "Quit", Color.BLACK, core);
    }

	@Override
	public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2d) {
		core.quit();
	}
}