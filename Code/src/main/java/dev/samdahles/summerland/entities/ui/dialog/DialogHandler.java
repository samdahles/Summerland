package dev.samdahles.summerland.entities.ui.dialog;

import com.github.hanyaeger.api.Timer;

import dev.samdahles.summerland.scenes.dialog.DialogScene;

public class DialogHandler extends Timer {
	private DialogScene scene;
	
	private String textToGenerate;
	private int textLength;
	private int progress;
	
	public DialogHandler(DialogScene scene, int intervalInMs) {
		super(intervalInMs);
		this.scene = scene;
	}
	
	@Override
	public void onAnimationUpdate(long timestamp) {
		scene.addChar(textToGenerate.charAt(progress));
		progress++;
		if (textLength == progress) {
			this.pause();
		}
	}
	
	public void setTextToGenerate(String textToGenerate) {
		this.textToGenerate = textToGenerate;
		this.textLength = textToGenerate.length();
		this.progress = 0;
	}
}
