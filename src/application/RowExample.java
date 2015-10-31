package application;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

public class RowExample extends ArrayList<Row>{
	RowExample() {
		super();
		this.add(new Row("", KeyCode.ENTER));
		this.add(new Row("\n2 2 1 3", KeyCode.D));
		this.add(new Row("\n4 едно eдно едно", KeyCode.K));
		this.add(new Row("\nтри три две едно", KeyCode.D));
		this.add(new Row("\nтри три три едно", KeyCode.K));
		this.add(new Row("\nчетири четири четири едно", KeyCode.K));
	}
}
