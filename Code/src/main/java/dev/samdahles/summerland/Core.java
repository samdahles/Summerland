package dev.samdahles.summerland;

import java.util.ArrayList;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;

import dev.samdahles.summerland.Story.Affiliation;
import dev.samdahles.summerland.scenes.dialog.DialogScene;
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
	
	public static final Size GENERIC_SIZE = new Size(48, 64);
	
	
	public MainMenuScene mainMenuScene;
	public CreditsScene creditsScene;
	public DialogScene dialogScene;
	public GameScene gameScene;
	
	
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
        this.mainMenuScene = new MainMenuScene(this);
        this.creditsScene = new CreditsScene(this);
        this.dialogScene = new DialogScene(this);
        this.gameScene = new GameScene(this);

        addScene(SCENE_MAINMENU, this.mainMenuScene);
        addScene(SCENE_GAME, this.gameScene);
        addScene(SCENE_CREDITS, this.creditsScene);
        addScene(SCENE_DIALOG, this.dialogScene);


    }
    
    
    
	public static CustomFont getFont(String font, int size) {
		return new CustomFont("Fonts/" + font + ".ttf", size);
	}
}
