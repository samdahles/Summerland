package dev.samdahles.summerland.entities.characters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import dev.samdahles.summerland.Story.Affiliation;

public class MoveableCharacter extends DynamicSpriteEntity implements Collider, TimerContainer {

	private Direction lastMove;
	protected String name;
	protected String charFolder;
	private Affiliation affiliation;
	private Runnable onInteract;
	private String allowedTileset;
	private MoveAnimationTimer timer = new MoveAnimationTimer(this, 250);
	
	public static ArrayList<MoveableCharacter> characterList = new ArrayList<MoveableCharacter>();
	
	private Direction oldDirection;
	protected int[] downIndexes = {1, 2, 3};
	protected int[] leftIndexes = {4, 5, 6};
	protected int[] rightIndexes = {7, 8, 9};
	protected int[] upIndexes = {10, 11, 12};
	
	
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
	public MoveableCharacter(String name, String charFolder, Coordinate2D anchorLocation, Size size, Affiliation affiliation) {
		super(charFolder + "Walk.png", anchorLocation, size, 4, 3);
		this.name = name;
		this.charFolder = charFolder;
		this.setCurrentFrameIndex(1);
		this.onInteract = new Runnable() { public void run() {
            System.out.println("Attempted to interact but no Runnable was set");
        }};
		MoveableCharacter.characterList.add(this);
	}
	
	
	
	public void setAllowedTileset(String tileset) {
		this.allowedTileset = tileset; 
	}
	
	public String getAllowedTileset() {
		return this.allowedTileset;
	}
	
	/**
	 * Sets the onInteract {@link Runnable} that will be executed on interact
	 * @param runnable the {@link Runnable} that will be executed on interact
	 */
	public void setInteract(Runnable runnable) {
		this.onInteract = runnable;
	}
	
	public void interact() {
		this.onInteract.run();
	}
	
	
	public String toString() {
		return "MoveableCharacter " + this.name;
	}
	
	
	/** Get the {@link Direction} a MoveableCharacter is facing */
	@SuppressWarnings("unlikely-arg-type")
	public Direction getFacing() {
		int frameIndex = this.getCurrentFrameIndex();
		
		if(Arrays.asList(downIndexes).contains(frameIndex)) {
			return Direction.DOWN;
		} else if(Arrays.asList(leftIndexes).contains(frameIndex)) {
			return Direction.LEFT;
		} else if(Arrays.asList(rightIndexes).contains(frameIndex)) {
			return Direction.RIGHT;
		} else if(Arrays.asList(upIndexes).contains(frameIndex)) {
			return Direction.UP;
		}
		
		return null;
		
	}

	/**
	 * Moves the character.
	 * @param direction the {@link Direction} the character should move (indefinitely).
	 */
	public void move(Direction direction) {
		timer.start(direction);
		if (direction == Direction.UP) {
			setMotion(1.5, 180d);
			if (oldDirection != direction) {
				this.setCurrentFrameIndex(9);
			}
			oldDirection = direction;
		} else if (direction == Direction.LEFT) {
			setMotion(1.5, 270d);
			if (oldDirection != direction) {
				this.setCurrentFrameIndex(3);
			}
			oldDirection = direction;
		} else if (direction == Direction.RIGHT) {
			setMotion(1.5, 90d);
			if (oldDirection != direction) {
				this.setCurrentFrameIndex(6);
			}
			oldDirection = direction;
		} else if (direction == Direction.DOWN) {
			setMotion(1.5, 0d);
			if (oldDirection != direction) {
				this.setCurrentFrameIndex(0);
			}
			oldDirection = direction;
		}
		lastMove = direction;
	}

	/**
	 * Stops movement of the character.
	 */
	public void stopMove() {
		timer.stop();
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



	@Override
	public void setupTimers() {
		// TODO Auto-generated method stub
		addTimer(timer);
	}

}
