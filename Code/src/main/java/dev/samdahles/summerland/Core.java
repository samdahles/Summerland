package dev.samdahles.summerland;

import java.util.ArrayList;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.media.SoundClip;

import dev.samdahles.summerland.Story.Affiliation;
import dev.samdahles.summerland.scenes.game.GameScene;
import dev.samdahles.summerland.scenes.menus.CreditsScene;
import dev.samdahles.summerland.scenes.menus.MainMenuScene;
import dev.samdahles.summerland.entities.characters.TalkingCharacter;

@SuppressWarnings("exports")
public class Core extends YaegerGame {
	public static final int SCENE_MAINMENU = 0;
	public static final int SCENE_GAME = 1;
	public static final int SCENE_CREDITS = 2;
	public static final int SCENE_DIALOG = 3;
	
	public static final Size GENERIC_SIZE = new Size(64, 32);	
	
	public MainMenuScene mainMenuScene;
	public CreditsScene creditsScene;
	public GameScene gameScene;
	public SoundClip OST = new SoundClip("Music/OST.mp3");
	
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
    	// TODO: Check if Serialized object is in resources
		Story story = new Story(this);
    	
        this.mainMenuScene = new MainMenuScene(this);
        this.creditsScene = new CreditsScene(this);
        this.gameScene = new GameScene(this, story);

        addScene(SCENE_MAINMENU, this.mainMenuScene);
        addScene(SCENE_GAME, this.gameScene);
        addScene(SCENE_CREDITS, this.creditsScene);
    }
    
	public static CustomFont getFont(String font, int size) {
		return new CustomFont("Fonts/" + font + ".ttf", size);
	}
}
