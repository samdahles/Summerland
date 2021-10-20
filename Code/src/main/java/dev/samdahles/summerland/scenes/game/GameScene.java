package dev.samdahles.summerland.scenes.game;
import java.util.Set;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.player.Nate;
import dev.samdahles.summerland.Story;
import dev.samdahles.summerland.entities.characters.MoveableCharacter;
import dev.samdahles.summerland.entities.characters.PlayableCharacter;
import dev.samdahles.summerland.entities.tiles.TileEntity;
import dev.samdahles.summerland.tilemaps.CustomTileMap;
import javafx.scene.input.KeyCode;

public class GameScene extends DynamicScene implements KeyListener {
    protected Core core;
    public PlayableCharacter player;
    private CustomTileMap customTileMap;
    private Story story;
    
    public GameScene(Core core) {
    	this.core = core;
    }
    
    public void addCharacter(MoveableCharacter character) {
    	this.addEntity(character);
    }
    
    public void setStory(Story story) {
    	this.story = story;
    }
    
    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
    	if(this.player != null) {
        	this.player.remove();
    	}
    	this.player = playableCharacter;
    	this.addEntity(this.player);
    }
    
    public void setTilemap(CustomTileMap map) {
    	this.customTileMap = map;
    	this.setupEntities();
    }
    
    @Override
    public void setupScene() {
        setBackgroundAudio("Music/MainTheme.mp3");
    }

    @Override
    public void setupEntities() {
    	CustomTileMap map = this.customTileMap;
    	if(this.customTileMap == null) {
    		map = new CustomTileMap("3-2");
    		this.customTileMap = map;
    	}
    	for (TileEntity tile : map.getTiles()) {
    		this.addEntity(tile);
    	}	
    }

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.ESCAPE)) {
			story.saveAndMainMenu();
		}
	}
}
