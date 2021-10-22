package dev.samdahles.summerland.scenes.dialog;

import java.util.Set;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.KeyListener;

import dev.samdahles.summerland.Core;
import dev.samdahles.summerland.entities.ui.dialog.DialogBox;
import dev.samdahles.summerland.entities.ui.dialog.DialogHandler;
import dev.samdahles.summerland.entities.ui.dialog.DialogHead;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

public class DialogScene extends DynamicScene implements TimerContainer, KeyListener {
	protected Core core;
	
	private final int msBeforeNextCharacter = 50;
	private final SoundClip charAddSound = new SoundClip("Music/Select.mp3");
	
	private String[] dialog;
	private int dialogProgress;
	
	private String character;
	private String headPath;
	private String text = "";
	private TextEntity textEntity;
	
	private DialogHandler handler = new DialogHandler(this, msBeforeNextCharacter);
	
	public DialogScene(Core core) {
		handler.pause();
		this.core = core;
	}

	@Override
	public void setupScene() {
		setBackgroundImage("Images/MenuBackground1.gif");
	}

	@Override
	public void setupEntities() {
		Size boxSize = new Size(Core.SCREEN_WIDTH, 400);
		Size headSize = new Size(175, 175);
		
		double boxY = Core.SCREEN_HEIGHT - boxSize.height() + 50;
		double headY = boxY - headSize.height();
		
		int headX = 75;
		
		DialogBox box = new DialogBox("Images/Dialog.png", new Coordinate2D(0, boxY), boxSize);
		DialogHead head = new DialogHead(headPath, new Coordinate2D(headX, headY), headSize);
		TextEntity name = new TextEntity(new Coordinate2D(headX + headX, boxY + 20), character);

		textEntity = new TextEntity(new Coordinate2D(20, boxY + 75), text);

		name.setFont(Core.getFont("PressStart2P", 30));
		name.setAnchorPoint(AnchorPoint.TOP_CENTER);
		name.setFill(Color.WHITE);
		textEntity.setFont(Core.getFont("PressStart2P", 20));
		textEntity.setFill(Color.WHITE);
		
		this.addEntity(box);
		this.addEntity(head);
		this.addEntity(name);
		this.addEntity(textEntity);
	}
	
	public void setDialog(String[] dialog) {
		this.dialog = dialog;
		this.dialogProgress = 0;
	}
	
	public void generateText(String text) {
		handler.setTextToGenerate(text);
		handler.resume();
	}
	
	public void setText(String text) {
		this.text = text;
		textEntity.setText(text);
	}
	
	public void addChar(char character) {
		this.text = this.text + character;
		textEntity.setText(this.text);
		charAddSound.play();
	}
	
	public void setCharacter(String character) {
		this.character = character;
		this.headPath = "CharSprites/" + character + "/Head.png";
	}

	@Override
	public void setupTimers() {
		addTimer(handler);
	}

	@Override
	public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		if (pressedKeys.contains(KeyCode.SPACE)) {
			if (dialogProgress < dialog.length) {
				setText("");
				generateText(dialog[dialogProgress]);
				dialogProgress++;
			}
		}
	}
}
