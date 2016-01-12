package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class KeyHandle {
		private long endTime;
		private long startTime;
		private int points;
		
		public long getEndTime() {
			return endTime;
		}
		public long getStartTime() {
			return startTime;
		}
		public void setStartTime(long startTime) {
			this.startTime = startTime;
		}
		public int getPoints() {
			
			return points;
		}
		KeyHandle() {
			
		}
		public void set(Scene scene, BorderPane border, RowExample example, Button results, Button partTwo,boolean last) {
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				 int  i =0;
				 int point = -1;
		            public void handle(KeyEvent ke) {
		            		if( i < example.size() ) {
		            			if (ke.getCode() == example.get(i).getRightKey()) {
		            				point++;
		            			}
		            			i++;
		            			if (i == example.size()) {
		            				
		            				//tuk da se dobavq noviq prozorec? 
		            				if (last) {
		            					border.getTop().setVisible(false);
		            				}
		            				else {
		            					Text t = new Text(new String("\nМоля, сложете слушалките."
		            							+ "\n При стартиране на част II, ще чуете рекламен блок в ефира на \nбългарска радио станция."
		            							+ " \n Докато слушате, продължете числовия тест."));
		            					t.setFont(new Font("Ariel Black", 18));
		            					border.setTop(t);
		            				}
		            				border.setCenter(results);
		            				border.setBottom(partTwo);
		            				border.setAlignment(partTwo, Pos.CENTER);
		            				points = point;
		            				endTime = System.currentTimeMillis();
		            			}
		            			else {
				                border.setCenter(example.get(i));
		            			}	
		            		}
		            }
		        });
		}
}
