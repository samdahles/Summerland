package dev.samdahles.summerland.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import dev.samdahles.summerland.Core;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;

public abstract class Button extends DynamicTextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener, TimerContainer {
    protected final Core core;
    
    private ButtonFlasher flasher = new ButtonFlasher(this, 10, 0.025);

    public Button(Coordinate2D initialPosition, int size, String text, Color color, Core core) {
        super(initialPosition, text);
        this.core = core;
        setFill(color);
        setFont(Core.getFont(size));
    }

    @Override
    public abstract void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D);

    @Override
    public void onMouseEntered() {
    	setCursor(Cursor.HAND);
    	flasher.resume();
    }

    @Override
    public void onMouseExited() {
    	setCursor(Cursor.DEFAULT);
    	flasher.reset();
    }
    
	@Override
	public void setupTimers() {
		addTimer(flasher);
		flasher.reset();
	}
}
