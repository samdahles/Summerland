package dev.samdahles.summerland;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;

import dev.samdahles.summerland.scenes.game.MapScene;
import dev.samdahles.summerland.scenes.menus.CreditsScene;
import dev.samdahles.summerland.scenes.menus.MainMenuScene;

public class Core extends YaegerGame {
	public static final int SCENE_MAINMENU = 0;
	public static final int SCENE_GAME = 1;
	public static final int SCENE_SETTINGS = 2;
	public static final int SCENE_CREDITS = 3;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Summerland");
        setSize(new Size(960, 900));
    }

    @Override
    public void setupScenes() {
        addScene(SCENE_MAINMENU, new MainMenuScene(this));
        addScene(SCENE_GAME, new MapScene(this));
        addScene(SCENE_SETTINGS, new SettingsScene(this));
        addScene(SCENE_CREDITS, new CreditsScene(this));
    }
    
    
    
	@SuppressWarnings("exports")
	public static CustomFont getFont(String font, int size) {
		return new CustomFont("Fonts/" + font + ".ttf", size);
	}
}
