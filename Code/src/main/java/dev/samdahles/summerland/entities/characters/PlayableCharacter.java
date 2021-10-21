package dev.samdahles.summerland.entities.characters;

import java.util.Date;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.userinput.KeyListener;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story.Affiliation;
import javafx.scene.input.KeyCode;

public class PlayableCharacter extends TalkingCharacter implements KeyListener, Collided {

	private long previousCollisionTimestamp = new Date().getTime() / 1000;
	private SoundClip collisionSound = new SoundClip("Music/Collision.mp3");
	private Collider previousCollider = null;
	public PlayableCharacter(Coordinate2D initialLocation, String name, String charFolder) {
		super(name, charFolder, initialLocation, Core.GENERIC_SIZE, 4, 3, Affiliation.GOOD);
	}
	
	@Override
	public void onCollision(Collider collidingObject){
		long collisionTimestamp = new Date().getTime() / 1000;
		
		if(collisionTimestamp - this.previousCollisionTimestamp >= 2 
				|| !collidingObject.equals(previousCollider)) {
			this.collisionSound.play();
		}
		
		this.previousCollider = collidingObject;
		this.previousCollisionTimestamp = collisionTimestamp;
		
		if(this.getLastDirection() == Direction.UP) {
		  this.setAnchorLocationY(this.getAnchorLocation().getY() + 2);
		} else if(this.getLastDirection() == Direction.LEFT) {
		this.setAnchorLocationX(this.getAnchorLocation().getX() + 2);
		} else if(this.getLastDirection() == Direction.RIGHT) {
			this.setAnchorLocationX(this.getAnchorLocation().getX() - 2);
		} else if(this.getLastDirection() == Direction.DOWN) {	
			this.setAnchorLocationY(this.getAnchorLocation().getY() - 2);
		}

		
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.A) || pressedKeys.contains(KeyCode.LEFT)) {
			this.moveLeft();
		} else if (pressedKeys.contains(KeyCode.D) || pressedKeys.contains(KeyCode.RIGHT)) {
			this.moveRight();
		} else if (pressedKeys.contains(KeyCode.W) || pressedKeys.contains(KeyCode.UP)) {
			this.moveUp();
		} else if (pressedKeys.contains(KeyCode.S) || pressedKeys.contains(KeyCode.DOWN)) {
			this.moveDown();
		} else if (pressedKeys.isEmpty()) {
			this.stopMove();
		}
		System.out.println(this.getAnchorLocation().toString());
	}
}
