package dev.samdahles.summerland.scenes.game;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.entities.tiles.TileEntity;
import dev.samdahles.summerland.tilemaps.CustomTileMap;
import javafx.scene.input.KeyCode;

public class GameScene extends DynamicScene implements KeyListener {
    protected Core core;
    private SoundClip backgroundSound = null;
    public PlayableCharacter player;
    private CustomTileMap customTileMap;
    private Story story;    
    
    public GameScene(Core core, Story story) {
    	this.core = core;
    	this.story = story;
    }
    
    public void setTilemap(CustomTileMap map) {
    	this.customTileMap = map;
    	this.setupEntities();
    }
    
    @Override
    public void setupScene() {
        // setBackgroundAudio("Music/MainTheme.mp3");
    }
    
    
    @Override
    public void setupEntities() {
    	CustomTileMap map = this.customTileMap;
    	//if(this.customTileMap == null) {
    		
    		map = new CustomTileMap(story.getCurrentAreaX() + "-" + story.getCurrentAreaY());
    		this.customTileMap = map;
    	//}
    	for (TileEntity tile : map.getTiles()) {
    		this.addEntity(tile);
    	}
    	for(MoveableCharacter character : this.story.currentLevel.entityList) {
    		this.addEntity(character);
    	}
    	this.addEntity(this.story.currentLevel.playableCharacter);	
    }

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.ESCAPE)) {
			core.OST.play();
			story.saveAndMainMenu();
		}
	}
	
	
	public void setSound(String path) {
		this.backgroundSound = new SoundClip(path);
	}
	
	public void playSound() {
		if(this.backgroundSound != null) {
			this.backgroundSound.play();
		}
	}
	
	public void stopSound() {
		if(this.backgroundSound != null) {
			this.backgroundSound.stop();
		}
	}
	
	public void setSoundVolume(double volume) {
		this.backgroundSound.setVolume(volume);
	}
	
}
