package dev.samdahles.summerland;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

import dev.samdahles.summerland.scenes.MainMenuScene;

public class Core extends YaegerGame {
	public static void main(String[] args) {
        launch(args);
	}
	
    @Override
    public void setupGame() {
        setGameTitle("Summerland");
        setSize(new Size(1920, 1440));
        setBackgroundAudio("Music/MainTheme.mp3");
    }
    
    @Override
    public void setupScenes() {
    	var MainMenu = new MainMenuScene(this);
    	addScene(1, MainMenu);
    }

}
