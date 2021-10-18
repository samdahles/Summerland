package dev.samdahles.summerland.scenes.menus;

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

    public MenuScene(Core core, String title, boolean main) {
        this.core = core;
        this.title = title;
        this.main = main;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("Music/MainTheme.mp3");
        setBackgroundImage("Images/MainMenuBackground.jpg");
    }

    @Override
    public void setupEntities() {
    	int titleY = 40;
    	int titleYMain = 140;
    	int titleSize = 60;
    	
        Text titleText = new Text(new Coordinate2D(getWidth() / 2, this.main ? titleYMain : titleY), titleSize, this.title, AnchorPoint.TOP_CENTER, "PressStart2P");
        this.addEntity(titleText);
        
        if (!main) {
        	BackButton backButton = new BackButton(new Coordinate2D(titleY, 40), titleSize, Core.SCENE_MAINMENU, this.core);
        	this.addEntity(backButton);
        }
        
        setupMenuEntities();
    }
    
    public abstract void setupMenuEntities();
}
