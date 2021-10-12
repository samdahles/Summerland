package dev.samdahles.summerland;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.tutorial.scenes.MainMenuScene;

public class Core extends YaegerGame {
	public final int SCENE_MAINMENU = 0;
	public final int SCENE_GAME     = 1;
	public final int SCENE_SETTINGS = 2;
	public final int SCENE_CREDITS  = 3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Summerland");
        setSize(new Size(1024, 768));
    }

    @Override
    public void setupScenes() {
        addScene(SCENE_MAINMENU, new MainMenuScene(this));
//      addScene(SCENE_GAME, new GameScene(this));
//      addScene(SCENE_SETTINGS, new SettingsScene(this));
//      addScene(SCENE_CREDITS, new CreditsScene(this));
    }
    
	@SuppressWarnings("exports")
	public static CustomFont getFont(int size) {
		return new CustomFont("fonts/PressStart2P.ttf", size);
	}
}
