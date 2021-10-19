package dev.samdahles.summerland.scenes.dialog;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.characters.Character.Affiliation;
import dev.samdahles.summerland.entities.characters.Character;
import dev.samdahles.summerland.entities.dialogbox.DialogBox;
import javafx.scene.input.KeyCode;
public class DialogScene extends DynamicScene implements KeyListener {

	private Map<Character, String> book;
	private Affiliation typeDialog;
	private String backgroundPath;
	private Core core;
	private DialogBox dialogBox;
	
	public DialogScene(Core core) {
		this.core = core;
	}
	
	public void setup(Map<Character, String> book, Affiliation typeDialog, String backgroundPath) {
		this.book = book;
		this.typeDialog = typeDialog;
		this.backgroundPath = backgroundPath;
		this.book = book;
	}
	
	public void setup(Map<Character, String> book, Affiliation typeDialog) {
		this.book = book;
		this.typeDialog = typeDialog;
		this.backgroundPath = null;
		this.book = book;
	}
	
	@Override
	public void setupScene() {
		if(this.typeDialog == Affiliation.BAD) {
			setBackgroundAudio("Music/NonFriendlyTalk.mp3");
		} else if(this.typeDialog == Affiliation.GOOD) {
			setBackgroundAudio("Music/FriendlyTalk.mp3");
		}
		
		if(this.backgroundPath == null) {
			setBackgroundImage("Images/Black.png");
		} else {
			setBackgroundImage(this.backgroundPath);
		}
		
	}

	@Override
	public void setupEntities() {
		this.dialogBox = new DialogBox(this.book, this);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if(pressedKeys.contains(KeyCode.SPACE) || pressedKeys.contains(KeyCode.E)) {
			this.dialogBox.next();
		}
	}
	
	
	
}
