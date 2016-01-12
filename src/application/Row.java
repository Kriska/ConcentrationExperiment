package application;

import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Row extends VBox {
	private Label text;
	private KeyCode rightKey;
	

	public Label getText() {
		return text;
	}


	public void setText(Label text) {
		this.text = text;
	}


	public KeyCode getRightKey() {
		return rightKey;
	}


	public void setRightKey(KeyCode rightKey) {
		this.rightKey = rightKey;
	}


	Row(String str, KeyCode key) {
		 text = new Label(str);
		text.setFont(new Font("Ariel Black", 46));
		 rightKey = key;
		
		getChildren().add(text);
	}
	Row(String str) {
		 text = new Label(str);
			text.setFont(new Font("Verdana", 46));
			getChildren().add(text);
	}

}
