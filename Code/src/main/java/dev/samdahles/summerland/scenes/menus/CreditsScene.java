package dev.samdahles.summerland.scenes.menus;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import dev.samdahles.summerland.entities.Text;

import dev.samdahles.summerland.Core;

public class CreditsScene extends MenuScene {
    public CreditsScene(Core core) {
        super(core, "CREDITS", false);
    }

    public void setupMenuEntities() {
    	int textYOffset = 150;
    	int textSize = 30;
    	
    	double width = this.getWidth() / 2;
    	
    	Text programming = new Text(new Coordinate2D(width, textYOffset), 30, "Programming", AnchorPoint.TOP_CENTER);
    	Text sam    = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 1), 25, "Sam", AnchorPoint.TOP_CENTER);
    	Text dylan  = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 2), 25, "Dylan", AnchorPoint.TOP_CENTER);
    	Text thomas = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 3), 25, "Thomas", AnchorPoint.TOP_CENTER);
    	
    	this.addEntity(programming);
    	this.addEntity(sam);
    	this.addEntity(dylan);
    	this.addEntity(thomas);
    }
}
