package dev.samdahles.summerland.scenes.game;

import java.util.Timer;
import java.util.TimerTask;

import com.github.hanyaeger.api.scenes.DynamicScene;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.tilemaps.CustomTileMap;
import javafx.application.Platform;
import javafx.scene.paint.Color;

public class SwitchScene extends DynamicScene {
	private Core core;
	public PlayableCharacter player;

	public SwitchScene(Core core) {
		this.core = core;
	}

	public void setupEntities() {
	}
	
	public void setupScene() {
		this.setBackgroundColor(Color.BLACK);
		
		 Runnable task = () -> {
	            Platform.runLater(() -> {	               
	            	core.setActiveScene(Core.SCENE_GAME);
	            });
	        };
	        Thread thread = new Thread(task);
	        thread.setDaemon(true);
	        thread.start();
	}

}
