package dev.samdahles.summerland.entities.ui;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import dev.samdahles.summerland.Core;
import javafx.scene.paint.Color;

public class Text extends TextEntity {
	private int size;
	
	private Color color = Color.BLACK;
	private AnchorPoint anchorPoint = AnchorPoint.TOP_LEFT;
	private String font;
	
	public Text(Coordinate2D initialPosition, int size, String text, String font) {
        super(initialPosition, text);
        this.font = font;
        this.size = size;
        create();
	}
	
	public Text(Coordinate2D initialPosition, int size, String text, Color color, String font) {
        super(initialPosition, text);
        this.size = size;
        this.color = color;
        this.font = font;
        create();
	}
	
	public Text(Coordinate2D initialPosition, int size, String text, AnchorPoint anchorPoint, String font) {
        super(initialPosition, text);
        this.size = size;
        this.anchorPoint = anchorPoint;
        this.font = font;
        create();
	}
	
	public Text(Coordinate2D initialPosition, int size, String text, Color color, AnchorPoint anchorPoint, String font) {
        super(initialPosition, text);
        this.size = size;
        this.color = color;
        this.anchorPoint = anchorPoint;
        this.font = font;
        create();
	}
	
	private void create() {
        this.setAnchorPoint(this.anchorPoint);
        this.setFill(this.color);
        this.setFont(Core.getFont(this.font, size));
	}
}
