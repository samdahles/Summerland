package dev.samdahles.summerland.scenes.menus;

import com.github.hanyaeger.api.Coordinate2D;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.buttons.Button;
import dev.samdahles.summerland.entities.ui.buttons.menus.settings.FullscreenButton;

public class SettingsScene extends MenuScene {
    public SettingsScene(Core core) {
        super(core, "SETTINGS", false);
    }

    public void setupMenuEntities() {
    	Button fullscreenButton = new FullscreenButton(core, new Coordinate2D((this.getWidth() / 2) - 20, 150), 30);
    	
    	this.addEntity(fullscreenButton);
    }
}
