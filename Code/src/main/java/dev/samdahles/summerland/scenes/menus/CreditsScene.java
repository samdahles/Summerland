package dev.samdahles.summerland.scenes.menus;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.Text;
import javafx.scene.paint.Color;

public class CreditsScene extends MenuScene {
	
	private int textSize = 25;
	private int marginTop = 35;
	private int yCurrent = 0;
	private int headerSpacing = 0;
	private Color textColor = Color.BLACK;
	private Color headingColor = Color.BLACK;
	private double width;

	
    public CreditsScene(Core core) {
        super(core, "CREDITS", new Coordinate2D(0, 0), AnchorPoint.BOTTOM_CENTER, false);
    }

    public void setupMenuEntities() {
        this.width = this.getWidth() / 2;
    
        for(int i=0; i<2; i++) {
        	this.headerText("-- Development --");
        	this.normalText("Sam Dahles");
        	this.normalText("Dylan Buil");
        	this.normalText("Thomas Ubbink");
        	
        	this.whiteSpace();
        	this.headerText("-- Sound Design --");
        	this.normalText("OST: Together We Are Robots");
        	this.normalText("Music: David Renda");
        	
        	this.whiteSpace();
        	this.headerText("-- Image Design --");
        	this.normalText("Characters: Ocean's Dream");
        	this.normalText("Images: Sam Dahles and Public Domain");
        	
        	this.whiteSpace();
        	this.normalText("https://oceansdream.itch.io/");
        	
        	this.whiteSpace();
        	this.normalText("www.samdahles.dev");
        	this.normalText("devSurface#2906");
        	this.normalText("www.github.com/TheThomanski");
        	this.yCurrent = 0;
        	this.headerSpacing = 0;
        	this.width = this.width + 2;
        	this.headingColor = Color.WHITE;
        	this.textColor = Color.WHITE;
        	
        }
        
        this.width = this.getWidth() / 2;
        this.textColor = Color.BLACK;
        this.headingColor = Color.BLACK;
        
    }
    
    
    private void whiteSpace() {
    	this.yCurrent++;
    }
    
    private void headerText(String text) {
    	Coordinate2D location = new Coordinate2D(this.width, this.headerSpacing + this.marginTop + this.textSize + 10 + this.marginTop * this.yCurrent);
    	this.headerSpacing += 10;
    	Text ret = new Text(location, this.textSize, text, this.headingColor, AnchorPoint.TOP_CENTER, "OctoberCrow");
    	this.addEntity(ret);
    	this.yCurrent++;
    }
    
    private void normalText(String text) {
    	Coordinate2D location = new Coordinate2D(this.width, this.headerSpacing + this.marginTop + this.textSize + this.marginTop * this.yCurrent);
    	Text ret = new Text(location, this.textSize, text, this.textColor, AnchorPoint.TOP_CENTER, "Roboto");
    	this.addEntity(ret);
    	this.yCurrent++;
    }
    
}
