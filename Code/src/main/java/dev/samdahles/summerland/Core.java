package dev.samdahles.summerland;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

import dev.samdahles.summerland.scenes.MainMenuScene;
import nl.han.showcase.scenes.composing.Composing;
import nl.han.showcase.scenes.distance.TheDistanceScene;
import nl.han.showcase.scenes.gravity.Gravity;
import nl.han.showcase.scenes.greatballsoffire.GreatBallsOfFire;
import nl.han.showcase.scenes.mapsandlegends.MapsAndLegends;
import nl.han.showcase.scenes.ridethelightning.RideTheLightningScene;
import nl.han.showcase.scenes.roadsgoeveron.RoadsGoEverOnScene;
import nl.han.showcase.scenes.selection.SelectionScene;
import nl.han.showcase.scenes.shapeofyou.ShapeOfYouScene;
import nl.han.showcase.scenes.time.Time;

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
