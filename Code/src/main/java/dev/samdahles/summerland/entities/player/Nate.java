package dev.samdahles.summerland.entities.player;

import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

public class Nate extends DynamicSpriteEntity implements KeyListener {
	public Nate(Coordinate2D initialLocation) {
		super("Sprites/spritesheet.png", initialLocation, new Size(40, 45), 1, 12);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.LEFT)) {
			setMotion(1.5, 270d);
			this.setCurrentFrameIndex(11);
		} else if (pressedKeys.contains(KeyCode.RIGHT)) {
			setMotion(1.5, 90d);
			this.setCurrentFrameIndex(2);
		} else if (pressedKeys.contains(KeyCode.UP)) {
			setMotion(1.5, 180d);
			this.setCurrentFrameIndex(5);
		} else if (pressedKeys.contains(KeyCode.DOWN)) {
			setMotion(1.5, 0d);
			this.setCurrentFrameIndex(7);
		} else if (pressedKeys.isEmpty()) {
			setSpeed(0);
		}

	}
}
