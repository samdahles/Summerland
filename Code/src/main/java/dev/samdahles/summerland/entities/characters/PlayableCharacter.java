package dev.samdahles.summerland.entities.characters;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story.Affiliation;
import javafx.scene.input.KeyCode;

public class PlayableCharacter extends TalkingCharacter implements KeyListener, Collided, SceneBorderTouchingWatcher {
	
	public PlayableCharacter(Coordinate2D initialLocation, String name, String charFolder) {
		super(name, charFolder, initialLocation, new Size(48, 64), 4, 3, Affiliation.GOOD);
	}
	
	@Override
	public void notifyBoundaryTouching(SceneBorder border){
	    setSpeed(0);
	    System.out.print("hey");
	    switch(border){
	        case TOP:
	            setAnchorLocationY(1);
	            break;
	        case BOTTOM:
	            setAnchorLocationY(getSceneHeight() - getHeight() - 1);
	            break;
	        case LEFT:
	            setAnchorLocationX(1);
	            break;
	        case RIGHT:
	            setAnchorLocationX(getSceneWidth() - getWidth() - 1);
	        default:
	            break;
	        }
	}
	
	@Override
	public void onCollision(Collider collidingObject){
		if(this.getLastDirection() == Direction.UP) {
		  this.setAnchorLocationY(this.getAnchorLocation().getY() + 2.2);
		} else if(this.getLastDirection() == Direction.LEFT) {
		this.setAnchorLocationX(this.getAnchorLocation().getX() + 2.2);
		} else if(this.getLastDirection() == Direction.RIGHT) {
			this.setAnchorLocationX(this.getAnchorLocation().getX() - 2.2);
		} else if(this.getLastDirection() == Direction.DOWN) {	
			this.setAnchorLocationY(this.getAnchorLocation().getY() - 2.2);
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

	}
}
