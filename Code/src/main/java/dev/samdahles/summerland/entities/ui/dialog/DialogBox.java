package dev.samdahles.summerland.entities.ui.dialog;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class DialogBox extends SpriteEntity {
	public DialogBox(String resource, Coordinate2D initalLocation, Size size) {
		super(resource, initalLocation, size);
	}
}
