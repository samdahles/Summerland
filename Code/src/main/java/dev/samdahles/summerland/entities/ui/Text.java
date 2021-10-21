package dev.samdahles.summerland.entities.ui;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import dev.samdahles.summerland.Core;
import javafx.scene.paint.Color;


/**
 * 
 * The Text class accounts for all text shown on the screen.
 * Text extends {@link TextEntity}
 */
public class Text extends TextEntity {
	private int size;
	
	private Color color = Color.WHITE;
	private AnchorPoint anchorPoint;
	private String font;
	
	
	/**
	 * Creates a Text object.
	 * @param initialPosition position of the text
	 * @param size font size
	 * @param text to be displayed text
	 * @param anchorPoint the anchorpoint where it should be anchored
	 * @param font the name of the font that is present in {@link src/Fonts/}
	 */
	public Text(Coordinate2D initialPosition, int size, String text, AnchorPoint anchorPoint, String font) {
        super(initialPosition, text);
        this.size = size;
        this.anchorPoint = anchorPoint;
        this.font = font;
        this.create();
	}
	
	/**
	 * Creates a Text object.
	 * @param initialPosition position of the text
	 * @param size font size
	 * @param text to be displayed text
	 * @param color color of the text
	 * @param anchorPoint the anchorpoint where it should be anchored
	 * @param font the name of the font that is present in {@link src/Fonts/}
	 */
	public Text(Coordinate2D initialPosition, int size, String text, Color color, AnchorPoint anchorPoint, String font) {
        super(initialPosition, text);
        this.size = size;
        this.color = color;
        this.anchorPoint = anchorPoint;
        this.font = font;
        this.create();
	}
	
	/** Sets the styles for the text */
	private void create() {
        this.setAnchorPoint(this.anchorPoint);
        this.setFill(this.color);
        this.setFont(Core.getFont(this.font, size));
	}
}
