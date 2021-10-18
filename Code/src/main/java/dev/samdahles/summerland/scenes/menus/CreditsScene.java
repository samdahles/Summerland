package dev.samdahles.summerland.scenes.menus;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.Text;

public class CreditsScene extends MenuScene {
    public CreditsScene(Core core) {
        super(core, "CREDITS", false);
    }

    public void setupMenuEntities() {
    	int textYOffset = 150;
    	int textSize = 30;
    	
    	double width = this.getWidth() / 2;
    	
    	Text development = new Text(new Coordinate2D(width, textYOffset), 30, "Development", AnchorPoint.TOP_CENTER, "RobotoBlack");
    	Text sam    = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 1), 25, "Sam", AnchorPoint.TOP_CENTER, "Roboto");
    	Text dylan  = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 2), 25, "Dylan", AnchorPoint.TOP_CENTER, "Roboto");
    	Text thomas = new Text(new Coordinate2D(width, textYOffset + 10 + textSize * 3), 25, "Thomas", AnchorPoint.TOP_CENTER, "Roboto");
    	
    	this.addEntity(development);
    	this.addEntity(sam);
    	this.addEntity(dylan);
    	this.addEntity(thomas);
    }
}
