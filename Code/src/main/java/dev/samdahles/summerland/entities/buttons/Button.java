package dev.samdahles.summerland.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
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
    
    private int size;
    private Color color = Color.BLACK;
    private AnchorPoint anchorPoint = AnchorPoint.TOP_LEFT;
    
    private ButtonFlasher flasher = new ButtonFlasher(this, 10, 0.025);

	public Button(Core core, Coordinate2D initialPosition, int size, String text) {
        super(initialPosition, text);
        this.core = core;
        this.size = size;
        create();
	}
	
	public Button(Core core, Coordinate2D initialPosition, int size, String text, Color color) {
        super(initialPosition, text);
        this.core = core;
        this.size = size;
        this.color = color;
        create();
	}
	
	public Button(Core core, Coordinate2D initialPosition, int size, String text, AnchorPoint anchorPoint) {
        super(initialPosition, text);
        this.core = core;
        this.size = size;
        this.anchorPoint = anchorPoint;
        create();
	}
	
	public Button(Core core, Coordinate2D initialPosition, int size, String text, Color color, AnchorPoint anchorPoint) {
        super(initialPosition, text);
        this.core = core;
        this.size = size;
        this.color = color;
        this.anchorPoint = anchorPoint;
        create();
	}
    
    private void create() {
    	this.setAnchorPoint(this.anchorPoint);
        this.setFill(this.color);
        this.setFont(Core.getFont(this.size));
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
