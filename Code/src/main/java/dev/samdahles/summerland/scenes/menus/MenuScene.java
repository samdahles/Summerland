package dev.samdahles.summerland.scenes.menus;

import java.util.Random;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.Text;
import dev.samdahles.summerland.entities.ui.buttons.menus.BackButton;

public abstract class MenuScene extends DynamicScene {
    protected Core core;
    private String title;
    private boolean main;
    private Coordinate2D titleLocation;
    private AnchorPoint fromAnchorPoint;

    private static int previousBackground;
    
    public MenuScene(Core core, String title, Coordinate2D titleLocation, AnchorPoint fromAnchorPoint, boolean main) {
        this.core = core;
        this.title = title;
        this.main = main;
        this.titleLocation = titleLocation;
        this.fromAnchorPoint = fromAnchorPoint;
        
    }

    @Override
    public void setupScene() {
    	/*
    	int countBackgrounds = 8;
        setBackgroundAudio("Music/OST.mp3");
        int random = new Random().nextInt(countBackgrounds);
        while(true) {
        	if(random != MenuScene.previousBackground) {
        		break;
        	} else {
        		random = new Random().nextInt(countBackgrounds);
        	}
        }
    	
        System.out.println("Set background MenuBackground" + random);
        MenuScene.previousBackground = random;
        */
        setBackgroundImage("Images/MenuBackground1.gif");
    }

    @Override
    public void setupEntities() {
    	int titleY = 40;
    	int titleYMain = 140;
    	int titleSize = 40;
    	
        Text titleText = new Text(this.titleLocation, titleSize, this.title, this.fromAnchorPoint, "PressStart2P");
        this.addEntity(titleText);
        
        if (!main) {
        	BackButton backButton = new BackButton(new Coordinate2D(titleY, 40), 20, Core.SCENE_MAINMENU, this.core);
        	this.addEntity(backButton);
        }
        
        setupMenuEntities();
    }
    
    public abstract void setupMenuEntities();
}
