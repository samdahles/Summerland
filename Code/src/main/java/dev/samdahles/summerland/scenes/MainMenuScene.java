package dev.samdahles.summerland.scenes;

import java.util.ArrayList;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.buttons.Button;
import dev.samdahles.summerland.entities.buttons.mainmenu.Continue;
import dev.samdahles.summerland.entities.buttons.mainmenu.Credits;
import dev.samdahles.summerland.entities.buttons.mainmenu.NewGame;
import dev.samdahles.summerland.entities.buttons.mainmenu.Quit;
import dev.samdahles.summerland.entities.buttons.mainmenu.Settings;

import javafx.scene.paint.Color;

public class MainMenuScene extends DynamicScene {

    private Core core;

    public MainMenuScene(Core core) {
        this.core = core;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/MainTheme.mp3");
        setBackgroundImage("backgrounds/MainMenuBackground.jpg");
    }

    @Override
    public void setupEntities() {
        TextEntity summerlandText = new TextEntity(new Coordinate2D(getWidth() / 2, 200), "SUMMERLAND");
        summerlandText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        summerlandText.setFill(Color.BLACK);
        int titleSize = 60;
        summerlandText.setFont(Core.getFont(titleSize));
        addEntity(summerlandText);

        int buttonSize = 30;
        int buttonX = 10;
        int buttonYMargin = 20;
        double buttonYOffset = (getHeight() / 2) - 20;
        Continue continueButton = new Continue(new Coordinate2D(buttonX, buttonYOffset), buttonSize, core);
        NewGame newGameButton   = new NewGame (new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 1 + buttonSize * 1), buttonSize, core);
        Settings settingsButton = new Settings(new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 2 + buttonSize * 2), buttonSize, core);
        Credits creditsButton   = new Credits (new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 3 + buttonSize * 3), buttonSize, core);
        Quit quitButton         = new Quit    (new Coordinate2D(buttonX, buttonYOffset + buttonYMargin * 4 + buttonSize * 4), buttonSize, core);
        ArrayList<Button> buttons = new ArrayList<Button>();
        buttons.add(continueButton);
        buttons.add(newGameButton);
        buttons.add(settingsButton);
        buttons.add(creditsButton);
        buttons.add(quitButton);
        for (Button button : buttons) {
        	button.setAnchorPoint(AnchorPoint.TOP_LEFT);
        	addEntity(button);
        }
    }
}
