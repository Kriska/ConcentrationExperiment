package application;

import java.util.ArrayList;

import javafx.scene.input.KeyCode;

@SuppressWarnings("serial")
public class RowExample extends ArrayList<Row>{
	ArrayList<Row> initialRows, primaryRows;
	ArrayList<Row> wordRows;
	private void createNumber() {
		initialRows = new ArrayList<Row>();
		primaryRows = new ArrayList<Row>();
	
		initialRows.add(new Row("", KeyCode.ENTER));
		initialRows.add(new Row("\n2 2 2 1", KeyCode.DIGIT3));
		initialRows.add(new Row("\nедно едно едно едно", KeyCode.DIGIT4));
		initialRows.add(new Row("\n3 1 2 3", KeyCode.DIGIT2));
		initialRows.add(new Row("\nтри три две едно", KeyCode.DIGIT2));
		initialRows.add(new Row("\n2 1 1 3", KeyCode.DIGIT2));
		initialRows.add(new Row("\nедно две три едно", KeyCode.DIGIT2));
		initialRows.add(new Row("\nчетири четири четири едно", KeyCode.DIGIT3));
		initialRows.add(new Row("\n2 2 2 2", KeyCode.DIGIT4));
		initialRows.add(new Row("\nедно едно три едно", KeyCode.DIGIT3));
		initialRows.add(new Row("\n4 4 2 4", KeyCode.DIGIT3));
		
		primaryRows.add( new Row("\n3 4 4 2",KeyCode.DIGIT2));
		primaryRows.add(new Row("\nдве две две две", KeyCode.DIGIT4));
		primaryRows.add(new Row("\n2 2 1 3", KeyCode.DIGIT2));
		primaryRows.add(new Row("\n3 4 2 3", KeyCode.DIGIT2));
		primaryRows.add( new Row("\nтри три четири три", KeyCode.DIGIT3));
		primaryRows.add(new Row("\n3 2 4 4", KeyCode.DIGIT2));
		primaryRows.add( new Row("\n4 4 4 4", KeyCode.DIGIT4));
		primaryRows.add( new Row("\nедно едно две четири", KeyCode.DIGIT2));
		primaryRows.add( new Row("\n4 3 3 3", KeyCode.DIGIT3));
		primaryRows.add(new Row("\n2 1 2 2", KeyCode.DIGIT3));
	}
	private void createWord() {
		wordRows= new ArrayList<Row>();
		///TODO:...
	}
	RowExample(boolean isZero) {
		super();
		createNumber();
		createWord();
		if (isZero) {
			this.addAll(initialRows);
		}
		if (!isZero) {
			int i = 0;
			int j = 0;
			int k = 0;
			while(i < 20) {
				if(i % 2 == 0 && j< initialRows.size()) {
					this.add(initialRows.get(j));
					j++;
				}
				else {
					this.add(primaryRows.get(k));
					k++;
				}
				i++;
			}
		} 
	}
}
