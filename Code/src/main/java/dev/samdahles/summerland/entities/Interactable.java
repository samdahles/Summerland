package dev.samdahles.summerland.entities;

import java.util.Set;

import com.github.hanyaeger.api.userinput.KeyListener;

import javafx.scene.input.KeyCode;

public interface Interactable extends KeyListener {
	@Override
	public default void onPressedKeysChange(Set<KeyCode> pressedKeys) {
		for (KeyCode key : pressedKeys) {
			if (key == KeyCode.E) {
				// todo: afstand detectie zodat de functie alleen uitvoert als je dichtbij bent
				interact();
			}
		}
	}
	
	public abstract void interact();
}
