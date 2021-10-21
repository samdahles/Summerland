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
	protected String name;
	protected String charFolder;
	private Affiliation affiliation;

	/**
	 * MoveableCharacter is class that all characters on the map either are or extend.
	 * @param name the name of the character
	 * @param charFolder the resource folder where Walk.png is located
	 * @param anchorLocation the initial location of the character
	 * @param size the size of the character
	 * @param row the number of sprites divided over the x-axis
	 * @param column the number of sprites divided over the y-axis
	 * @param affiliation the {@link Affiliation} that the character has
	 */
	public MoveableCharacter(String name, String charFolder, Coordinate2D anchorLocation, Size size, int row, int column, Affiliation affiliation) {
		super(charFolder + "Walk.png", anchorLocation, size, row, column);
		this.name = name;
		this.charFolder = charFolder;
		this.setCurrentFrameIndex(1);
	}

	/**
	 * Moves the character.
	 * @param direction the {@link Direction} the character should move (indefinitely).
	 */
	public void move(Direction direction) {
		if (direction == Direction.UP) {
			setMotion(1.5, 180d);
			this.setCurrentFrameIndex(10);
		} else if (direction == Direction.LEFT) {
			setMotion(1.5, 270d);
			this.setCurrentFrameIndex(4);
		} else if (direction == Direction.RIGHT) {
			setMotion(1.5, 90d);
			this.setCurrentFrameIndex(7);
		} else if (direction == Direction.DOWN) {
			setMotion(1.5, 0d);
			this.setCurrentFrameIndex(2);
		}

		lastMove = direction;

	}

	/**
	 * Stops movement of the character.
	 */
	public void stopMove() {
		this.setSpeed(0);
	}

	/**
	 * Gets the last direction the character went.
	 */
	public Direction getLastDirection() {
		return this.lastMove;
	}
	
	/**
	 * Get the {@link Affiliation} of the character.
	 * @return
	 */
	public Affiliation getAffiliation() {
		return this.affiliation;
	}

	/**
	 * Set the {@link Affiliation} of the character.
	 * @param affiliation
	 */
	public void setAffiliation(Affiliation affiliation) {
		this.affiliation = affiliation;
	}

}
