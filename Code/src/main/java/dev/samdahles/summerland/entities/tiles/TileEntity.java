package dev.samdahles.summerland.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public abstract class TileEntity extends SpriteEntity {
	int yHeight;
	int tileId;

	public TileEntity(final Coordinate2D location, final Size size, final int tileId, final int yHeight) {
		super("Tiles/tile" + tileId + ".png", location, 1, 1);
		this.tileId = tileId;
		this.yHeight = yHeight;
	}
}

//
//protected SpriteEntity(final String resource, final Coordinate2D location, final int rows, final int columns) {
//    this(resource, location, null, rows, columns);
//}