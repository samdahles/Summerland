package dev.samdahles.summerland.entities.characters;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.entities.Direction;

public class MoveAnimationTimer extends Timer {
	private MoveableCharacter character;
	
	private Direction direction;
	
	
	private int frameInAnimation = 1;
	
	public MoveAnimationTimer(MoveableCharacter character, int intervalInMs) {
		super(intervalInMs);
		this.character = character;
		this.stop();
	}
	
	public void start(Direction direction) {
		this.direction = direction;
		this.resume();
	}
	
	public void stop() {
		this.pause();
		this.direction = null;
	}

	@Override
	public void onAnimationUpdate(long timestamp) {
		int index = character.getCurrentFrameIndex();
		
		if (direction == Direction.UP) {
			if (frameInAnimation < character.upIndexes.length) {
				index++;
				frameInAnimation++;
			} else {
				index = 9;
				frameInAnimation = 1;
			}
		} else if (direction == Direction.LEFT) {
			if (frameInAnimation < character.leftIndexes.length) {
				index++;
				frameInAnimation++;
			} else {
				index = 3;
				frameInAnimation = 1;
			}
		} else if (direction == Direction.RIGHT) {
			if (frameInAnimation < character.rightIndexes.length) {
				index++;
				frameInAnimation++;
			} else {
				index = 6;
				frameInAnimation = 1;
			}
		} else if (direction == Direction.DOWN) {
			if (frameInAnimation < character.downIndexes.length) {
				index++;
				frameInAnimation++;
			} else {
				index = 0;
				frameInAnimation = 1;
			}
		}
		//System.out.println("Index: " + index + ", Frame: " + frameInAnimation);
		character.setCurrentFrameIndex(index);
	}
}
