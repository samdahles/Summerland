package dev.samdahles.summerland.scenes.game;

import com.github.hanyaeger.api.scenes.DynamicScene;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.Person;
import dev.samdahles.summerland.entities.tiles.TileEntity;
import dev.samdahles.summerland.tilemaps.CustomTileMap;

public class MapScene extends DynamicScene {
    protected Core core;
    private Person person;
    
    public MapScene(Core core) {
    }
    
    @Override
    public void setupScene() {
        setBackgroundAudio("Music/MainTheme.mp3");
    }

    @Override
    public void setupEntities() {
    	CustomTileMap Map = new CustomTileMap("1-1");
    	for (TileEntity tile : Map.getTiles()) {
    		this.addEntity(tile);
    	}
    }
}
