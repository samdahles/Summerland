package dev.samdahles.summerland;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.api.entities.impl.CustomFont;
import com.github.hanyaeger.api.media.SoundClip;

import dev.samdahles.summerland.scenes.dialog.DialogScene;
import dev.samdahles.summerland.scenes.game.GameScene;
import dev.samdahles.summerland.scenes.game.SwitchScene;
import dev.samdahles.summerland.scenes.menus.CreditsScene;
import dev.samdahles.summerland.scenes.menus.MainMenuScene;

public class Core extends YaegerGame {
	public final static int SCREEN_WIDTH = 960;
	public static final int SCREEN_HEIGHT = 900;

	public static final int SCENE_MAINMENU = 0;
	public static final int SCENE_GAME = 1;
	public static final int SCENE_CREDITS = 2;
	public static final int SCENE_DIALOG = 3;
	public static final int SCENE_SWITCH = 4;

	public static final Size GENERIC_SIZE = new Size(64, 32);

	public MainMenuScene mainMenuScene;
	public CreditsScene creditsScene;
	public GameScene gameScene;
	public SwitchScene switchScene;
	public DialogScene dialogScene;
	public SoundClip OST = new SoundClip("Music/OST.mp3");

	public Story story = new Story(this);

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void setupGame() {
		setGameTitle("Summerland");
		setSize(new Size(SCREEN_WIDTH, SCREEN_HEIGHT));
	}

	@Override
	public void setupScenes() {
		this.mainMenuScene = new MainMenuScene(this);
		this.creditsScene = new CreditsScene(this);
		this.gameScene = new GameScene(this, story);
		this.switchScene = new SwitchScene(this);
		this.dialogScene = new DialogScene(this);

		addScene(SCENE_MAINMENU, this.mainMenuScene);
		addScene(SCENE_GAME, this.gameScene);
		addScene(SCENE_CREDITS, this.creditsScene);
		addScene(SCENE_SWITCH, this.switchScene);
		addScene(SCENE_DIALOG, this.dialogScene);
	}

	public static CustomFont getFont(String font, int size) {
		return new CustomFont("Fonts/" + font + ".ttf", size);
	}
}
