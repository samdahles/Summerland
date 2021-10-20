package dev.samdahles.summerland.scenes.menus;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.Text;
import javafx.scene.paint.Color;

public class CreditsScene extends MenuScene {
    public CreditsScene(Core core) {
        super(core, "CREDITS", new Coordinate2D(0, 0), AnchorPoint.BOTTOM_CENTER, false);
    }

    public void setupMenuEntities() {
    	int textYOffset = 150;
    	int textSize = 30;
    	
    	double width = this.getWidth() / 2;
    	
    	Text development = new Text(new Coordinate2D(width, textYOffset), 30, "Development", Color.RED, AnchorPoint.TOP_CENTER, "RobotoBlack");
    	Text sam    = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 1), 20, "Sam", Color.BLUE, AnchorPoint.TOP_CENTER, "PressStart2P");
    	Text dylan  = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 2), 20, "Dylan", Color.BLUE, AnchorPoint.TOP_CENTER, "PressStart2P");
    	Text thomas = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 3), 20, "Thomas", Color.BLUE, AnchorPoint.TOP_CENTER, "PressStart2P");
    	
    	this.addEntity(development);
    	this.addEntity(sam);
    	this.addEntity(dylan);
    	this.addEntity(thomas);
    }
}
