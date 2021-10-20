package dev.samdahles.summerland.entities.dialogbox;
import java.util.Map;
import java.util.Map.Entry;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.scenes.StaticScene;

import dev.samdahles.summerland.entities.characters.TalkingCharacter;
import dev.samdahles.summerland.entities.ui.Text;

public class DialogBox {
	
	private Map<TalkingCharacter, String> book;
	private Text text;
	private Entry<TalkingCharacter, String> entry;
	private DynamicDialogSprite dynamicDialogSprite;
	
	
	public DialogBox (Map<TalkingCharacter, String> book, StaticScene parentScene) {
		this.book = book;
		this.entry = book.entrySet().iterator().next();
		
		
		// Set up graphical
		this.dynamicDialogSprite = new DynamicDialogSprite(
				new Coordinate2D(parentScene.getWidth() / 2, 10),
				new Size(150, 50));
		
		this.text = new Text(new Coordinate2D(parentScene.getWidth() / 2, 40), 
				10, 
				"Test",
				AnchorPoint.BOTTOM_LEFT, 
				"PressStart2P");
		
	}
	
	public void show() {
		dynamicDialogSprite.setOpacity(1);
	}
	
	public void hide() {
		dynamicDialogSprite.setOpacity(0);
	}
	
	
	public void next() {
		this.entry = book.entrySet().iterator().next();
		this.text.setText(entry.getValue());
	}
}
