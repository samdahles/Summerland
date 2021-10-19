package dev.samdahles.summerland.entities.dialogbox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class DynamicDialogSprite extends SpriteEntity {

	protected DynamicDialogSprite(Coordinate2D location, Size size) {
		super("Images/Dialog.png", location, size);
	}
	

}
