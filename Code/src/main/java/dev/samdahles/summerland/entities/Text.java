package dev.samdahles.summerland.entities;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;

import dev.samdahles.summerland.Core;
import javafx.scene.paint.Color;

public class Text extends TextEntity {
	private int size;
	
	private Color color = Color.BLACK;
	private AnchorPoint anchorPoint = AnchorPoint.TOP_LEFT;
	
	public Text(Coordinate2D initialPosition, int size, String text) {
        super(initialPosition, text);
        this.size = size;
        create();
	}
	
	public Text(Coordinate2D initialPosition, int size, String text, Color color) {
        super(initialPosition, text);
        this.size = size;
        this.color = color;
        create();
	}
	
	public Text(Coordinate2D initialPosition, int size, String text, AnchorPoint anchorPoint) {
        super(initialPosition, text);
        this.size = size;
        this.anchorPoint = anchorPoint;
        create();
	}
	
	public Text(Coordinate2D initialPosition, int size, String text, Color color, AnchorPoint anchorPoint) {
        super(initialPosition, text);
        this.size = size;
        this.color = color;
        this.anchorPoint = anchorPoint;
        create();
	}
	
	private void create() {
        this.setAnchorPoint(this.anchorPoint);
        this.setFill(this.color);
        this.setFont(Core.getFont(size));
	}
}
