package dev.samdahles.summerland.entities.ui.buttons;

import com.github.hanyaeger.api.Timer;

public class ButtonFlasher extends Timer {
	
	private Button button;
	private double step;
	private boolean down = true;
	
	
	/**
	 * {@link Timer} that causes a button to flash at specified interval
	 * @param button the button that will be flashed
	 * @param intervalInMs the interval in which the button will be flashing 
	 * @param stepPerInterval the number of steps it takes per interval to go from translucent to visible
	 */
	ButtonFlasher(Button button, int intervalInMs, double stepPerInterval) {
		super(intervalInMs);
		this.button = button;
		this.step = stepPerInterval;
	}
	
	
	/** Sets the {@link Button} to visible */
	public void reset() {
		pause();
		button.setOpacity(1);
	}
	
	@Override
	public void onAnimationUpdate(long timestamp) {
		double opacity = button.getOpacity();
		if (down == true) {
			if (opacity - step < 0) {
				opacity = 0;
				down = false;
			} else {
				button.setOpacity(opacity - step);
			}
		} else {
			if (opacity + step > 1) {
				opacity = 1;
				down = true;
			} else {
				button.setOpacity(opacity + step);
			}
		}
	}
}
