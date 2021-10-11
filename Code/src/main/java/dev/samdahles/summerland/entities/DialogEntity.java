package dev.samdahles.summerland.entities;

import java.util.Map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import dev.samdahles.summerland.Person;

public class DialogEntity {
	Map<Person, String> TalkedTextMap;
	TextEntity textentity;
	// Color box entity for background
	// Image box entity for head image
	private static final int OFFSET = 50;
	
	DialogEntity(Map<Person, String> TalkedTextMap) {
		textentity = new TextEntity(new Coordinate2D(0,0));
		this.TalkedTextMap = TalkedTextMap;
		textentity.setAnchorLocation(new Coordinate2D(100, getHeight() - 200));
		textentity.width
	}
	
	private void showNext() {
		
	}
}
