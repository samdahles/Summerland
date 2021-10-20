package dev.samdahles.summerland.scenes.menus;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.buttons.menus.main.ContinueButton;
import dev.samdahles.summerland.entities.ui.buttons.menus.main.CreditsButton;
import dev.samdahles.summerland.entities.ui.buttons.menus.main.QuitButton;

public class MainMenuScene extends MenuScene {

	private final static int MARGIN_LEFT = 40;
	private final static int BUTTON_SIZE = 30;
	private final static int MARGIN_TOP = 20;

    
    public MainMenuScene(Core core) {
        super(core, "SUMMERLAND", new Coordinate2D(MARGIN_LEFT, MARGIN_TOP + 60), AnchorPoint.TOP_LEFT, true);
        core.OST.play();
    }

    public void setupMenuEntities() {

        double buttonYOffset = (getHeight() / 2) + 70;
        
        ContinueButton continueButton = new ContinueButton(this.core, new Coordinate2D(MARGIN_LEFT, buttonYOffset), BUTTON_SIZE, 30);
        CreditsButton creditsButton   = new CreditsButton (this.core, new Coordinate2D(MARGIN_LEFT, buttonYOffset + MARGIN_TOP * 1 + BUTTON_SIZE * 1), BUTTON_SIZE);
        QuitButton quitButton         = new QuitButton    (this.core, new Coordinate2D(MARGIN_LEFT, buttonYOffset + MARGIN_TOP * 2 + BUTTON_SIZE * 2), BUTTON_SIZE);
        
        this.addEntity(continueButton);
        this.addEntity(creditsButton);
        this.addEntity(quitButton);
    }
}
