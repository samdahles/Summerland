package dev.samdahles.summerland.scenes.game;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.player.Nate;
import dev.samdahles.summerland.entities.tiles.TileEntity;
import dev.samdahles.summerland.tilemaps.CustomTileMap;

public class GameScene extends DynamicScene {
    protected Core core;
    
    public GameScene(Core core) {
    }
    
    @Override
    public void setupScene() {
        setBackgroundAudio("Music/MainTheme.mp3");
    }

    @Override
    public void setupEntities() {
    	CustomTileMap Map = new CustomTileMap("3-2");
    	for (TileEntity tile : Map.getTiles()) {
    		this.addEntity(tile);
    	}
    	
    	Nate player = new Nate(new Coordinate2D(0,0));
    	this.addEntity(player);
    }
}
