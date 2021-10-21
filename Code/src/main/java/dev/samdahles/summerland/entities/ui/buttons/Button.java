package dev.samdahles.summerland.entities.ui.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;
import com.github.hanyaeger.api.media.SoundClip;
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
    private Color color = Color.WHITE;
    private AnchorPoint anchorPoint = AnchorPoint.TOP_LEFT;
    private String font;
    private boolean doFlash = true;
    protected ButtonFlasher flasher = new ButtonFlasher(this, 15, 0.025);
    protected SoundClip hoverSound = new SoundClip("Music/Select.mp3");
    protected SoundClip confirmSound = new SoundClip("Music/Confirm.mp3");
    
    
    /**
     * Creates a button.
     * @param core the core object
     * @param initialPosition the position where the button should be
     * @param size the font size of the button
     * @param text the text of the button
     * @param font the name of the font that is present in {@link src/Fonts/}
     * @param doFlash flashes button on hover if true
     */
	public Button(Core core, Coordinate2D initialPosition, int size, String text, String font, boolean doFlash) {
        super(initialPosition, text);
        this.core = core;
        this.size = size;
        this.font = font;
        this.doFlash = doFlash;
        this.create();
	}
	
	/**
	 * Creates a button.
	 * @param core the core object
	 * @param initialPosition the position where the button should be
	 * @param size the font size of the button
	 * @param text the text of the button
	 * @param color the {@link Color} of the font of the button
	 * @param font the name of the font that is present in {@link src/Fonts/}
	 * @param doFlash flashes the button on hover if true
	 */
	public Button(Core core, Coordinate2D initialPosition, int size, String text, Color color, String font, boolean doFlash) {
        super(initialPosition, text);
        this.core = core;
        this.size = size;
        this.color = color;
        this.font = font;
        this.doFlash = doFlash;
        this.create();
	}
    
	/** Sets the styles */
    private void create() {
    	this.setAnchorPoint(this.anchorPoint);
        this.setFill(this.color);
        this.setFont(Core.getFont(this.font, this.size));
    }

    
    @Override
    public abstract void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D);

    @Override
    public void onMouseEntered() {
    	setCursor(Cursor.HAND);
    	if(doFlash) flasher.resume();
    	this.hoverSound.play();
    	
    }

    @Override
    public void onMouseExited() {
    	setCursor(Cursor.DEFAULT);
    	if(doFlash) flasher.reset();
    }
    
	@Override
	public void setupTimers() {
		addTimer(flasher);
		flasher.reset();
	}
}
