package dev.samdahles.summerland.entities.characters;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.KeyListener;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.Story.Affiliation;
import javafx.scene.input.KeyCode;

public class PlayableCharacter extends TalkingCharacter implements KeyListener, Collided, SceneBorderTouchingWatcher {

	private long previousCollisionTimestamp = new Date().getTime() / 1000;
	private SoundClip collisionSound = new SoundClip("Music/Collision.mp3");
	private Collider previousCollider = null;
	private Story story;

	public PlayableCharacter(Coordinate2D initialLocation, String name, String charFolder, Story story) {
		super(name, charFolder, initialLocation, Core.GENERIC_SIZE, Affiliation.GOOD);
		this.story = story;
	}

	@Override
	public void notifyBoundaryTouching(SceneBorder border) {
		setSpeed(0);
		switch (border) {
		case TOP:
			this.story.switchMapArea(Direction.UP, this);
			break;
		case BOTTOM:
			this.story.switchMapArea(Direction.DOWN, this);
			break;
		case LEFT:
			this.story.switchMapArea(Direction.LEFT, this);
			break;
		case RIGHT:
			this.story.switchMapArea(Direction.RIGHT, this);
		default:
			break;
		}
	}

	@Override
	public void onCollision(Collider collidingObject) {
		long collisionTimestamp = new Date().getTime() / 1000;

		if (collisionTimestamp - this.previousCollisionTimestamp >= 2 || !collidingObject.equals(previousCollider)) {
			this.collisionSound.play();
		}

		this.previousCollider = collidingObject;
		this.previousCollisionTimestamp = collisionTimestamp;

		if (this.getLastDirection() == Direction.UP) {
			this.setAnchorLocationY(this.getAnchorLocation().getY() + 2);
		} else if (this.getLastDirection() == Direction.LEFT) {
			this.setAnchorLocationX(this.getAnchorLocation().getX() + 2.2);
		} else if (this.getLastDirection() == Direction.RIGHT) {
			this.setAnchorLocationX(this.getAnchorLocation().getX() - 2.2);
		} else if (this.getLastDirection() == Direction.DOWN) {
			this.setAnchorLocationY(this.getAnchorLocation().getY() - 2.2);
		}
	}

	/**
	 * Get an ArrayList of all nearby {@link MoveableCharacter}
	 * 
	 * @param range the range from the {@link PlayableCharacter} to the nearby
	 *              MoveableCharacters which should be returned
	 * @return an {@link ArrayList} of all nearby MoveableCharacters
	 */
	public ArrayList<MoveableCharacter> getNearbyCharacters(double range) {
		ArrayList<MoveableCharacter> moveableCharacters = new ArrayList<MoveableCharacter>();
		for (MoveableCharacter character : MoveableCharacter.characterList) {
			if (!character.equals(this)) {
				if (character.getAnchorLocation().distance(this.getAnchorLocation()) < range) {
					moveableCharacters.add(character);
				}
			}
		}
		return moveableCharacters;
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.A) || pressedKeys.contains(KeyCode.LEFT)) {
			this.move(Direction.LEFT);
		} else if (pressedKeys.contains(KeyCode.D) || pressedKeys.contains(KeyCode.RIGHT)) {
			this.move(Direction.RIGHT);
		} else if (pressedKeys.contains(KeyCode.W) || pressedKeys.contains(KeyCode.UP)) {
			this.move(Direction.UP);
		} else if (pressedKeys.contains(KeyCode.S) || pressedKeys.contains(KeyCode.DOWN)) {
			this.move(Direction.DOWN);
		} else if (pressedKeys.contains(KeyCode.E)) {

			ArrayList<MoveableCharacter> nearbyCharacters = this.getNearbyCharacters(40);
			if (!nearbyCharacters.isEmpty()) {
				for (MoveableCharacter character : nearbyCharacters) {
					character.interact();
					break;
				}
			}
		} else if (pressedKeys.isEmpty()) {
			this.stopMove();
		}

	}
}
