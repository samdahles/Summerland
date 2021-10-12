package dev.samdahles.summerland.scenes.menus;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.buttons.mainmenu.ContinueButton;
import dev.samdahles.summerland.entities.buttons.mainmenu.CreditsButton;
import dev.samdahles.summerland.entities.buttons.mainmenu.NewGameButton;
import dev.samdahles.summerland.entities.buttons.mainmenu.QuitButton;
import dev.samdahles.summerland.entities.buttons.mainmenu.SettingsButton;

public class MainMenuScene extends MenuScene {
    public MainMenuScene(Core core) {
        super(core, "SUMMERLAND", true);
    }

    public void setupMenuEntities() {
        int buttonSize = 30;
        int buttonX = 10;
        int buttonYMargin = 20;
        double buttonYOffset = (getHeight() / 2) - 20;
        
        ContinueButton continueButton = new ContinueButton(this.core, new Coordinate2D(buttonX, buttonYOffset), buttonSize);
        NewGameButton newGameButton   = new NewGameButton (this.core, new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 1 + buttonSize * 1), buttonSize);
        SettingsButton settingsButton = new SettingsButton(this.core, new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 2 + buttonSize * 2), buttonSize);
        CreditsButton creditsButton   = new CreditsButton (this.core, new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 3 + buttonSize * 3), buttonSize);
        QuitButton quitButton         = new QuitButton    (this.core, new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 4 + buttonSize * 4), buttonSize);
        
        this.addEntity(continueButton);
        this.addEntity(newGameButton);
        this.addEntity(settingsButton);
        this.addEntity(creditsButton);
        this.addEntity(quitButton);
    }
}
