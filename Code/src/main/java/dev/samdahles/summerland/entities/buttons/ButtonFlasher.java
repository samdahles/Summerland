package dev.samdahles.summerland.entities.buttons;

import com.github.hanyaeger.api.Timer;

public class ButtonFlasher extends Timer {
	
	private Button button;
	
	private double step;
	
	private boolean down = true;
	
	public ButtonFlasher(Button button, int intervalInMs, double stepPerInterval) {
		super(intervalInMs);
		this.button = button;
		this.step = stepPerInterval;
	}
	
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
