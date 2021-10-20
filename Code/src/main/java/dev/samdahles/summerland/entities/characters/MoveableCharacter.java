package dev.samdahles.summerland.entities.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import dev.samdahles.summerland.Story.Affiliation;

public class MoveableCharacter extends DynamicSpriteEntity implements Collider {

	private Direction lastMove;
	protected int characterId;
	protected String name;
	protected String charFolder;
	public static Map<Integer, MoveableCharacter> moveableCharacterList = new HashMap<Integer, MoveableCharacter>();;
	private Affiliation affiliation;

	public MoveableCharacter(String name, String charFolder, Coordinate2D anchorLocation, Size size, int row,
			int column, Affiliation affiliation) {
		super(charFolder + "Walk.png", anchorLocation, size, row, column);
		this.name = name;
		this.characterId = MoveableCharacter.moveableCharacterList.size() + 1;
		this.charFolder = charFolder;
		MoveableCharacter.moveableCharacterList.put(this.characterId, this);
		this.setCurrentFrameIndex(1);
	}

	public static void removeCharacter(int id) {
		MoveableCharacter.moveableCharacterList.remove(id);
	}

	public void removeCharacter() {
		MoveableCharacter.moveableCharacterList.remove(this.characterId);
	}

	public void setLocation(Coordinate2D location) {
		this.setAnchorLocation(location);
	}

	public Coordinate2D getLocation() {
		return this.getAnchorLocation();
	}

	public void move(Direction direction) {
		if (direction == Direction.UP) {
			setMotion(1, 180d);
			this.setCurrentFrameIndex(10);
		} else if (direction == Direction.LEFT) {
			setMotion(1, 270d);
			this.setCurrentFrameIndex(4);
		} else if (direction == Direction.RIGHT) {
			setMotion(1, 90d);
			this.setCurrentFrameIndex(7);
		} else if (direction == Direction.DOWN) {
			setMotion(1, 0d);
			this.setCurrentFrameIndex(2);
		}

		lastMove = direction;

	}

	public void moveUp() {
		this.move(Direction.UP);
	}

	public void moveLeft() {
		this.move(Direction.LEFT);
	}

	public void moveDown() {
		this.move(Direction.DOWN);
	}

	public void moveRight() {
		this.move(Direction.RIGHT);
	}

	public void stopMove() {
		this.setSpeed(0);
	}

	public Direction getLastDirection() {
		return this.lastMove;
	}

	public Affiliation getAffiliation() {
		return this.affiliation;
	}

	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}

}
