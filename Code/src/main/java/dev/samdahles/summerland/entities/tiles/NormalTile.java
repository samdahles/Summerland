package dev.samdahles.summerland.entities.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;

public class NormalTile extends TileEntity {

	public NormalTile(Coordinate2D location, Size size, int tileId, int yHeight) {
		super(location, size, tileId, yHeight);
	}
}
