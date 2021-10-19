package dev.samdahles.summerland.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class TileEntity extends SpriteEntity {
	public TileEntity(final Coordinate2D location, final Size size, final int tileId) {
        super("Tiles/tile"+ tileId + ".png", location, 1, 1);
    }
}


//
//protected SpriteEntity(final String resource, final Coordinate2D location, final int rows, final int columns) {
//    this(resource, location, null, rows, columns);
//}