package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ZeroStart {
 
	ZeroStart(Stage parsedStage){
			BorderPane border = new BorderPane();
			Scene scene = new Scene(border,640,300);
			
			String text= new String("\t Колко еднкви цифри виждате написани? \n Натиснете:\t'2' за две, \n\t\t\t'3' за три, \n\t\t\t'4' за четири." );
			Label instructions= new Label(text);
			instructions.setFont(new Font("Ariel", 20));
			border.setPadding(new Insets(10));
			Text t = new Text("\n Натиснете 'ЕNTER'. Ще започне пробен вариант с цел запознаване със задачата.");
			border.setStyle("-fx-background-color: #FFFFFF;");
			border.setCenter(t);
			RowExample example = new RowExample(true);
			BorderPane.setAlignment(instructions, Pos.CENTER);
			border.setTop(instructions);
	       
	        Button startTest = new Button("Започни теста");
	      
	        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        	int i = 0;
	        	public void handle(KeyEvent ke) {
			            		if( i < example.size() ) {
			            			i++;
			            			if (i == example.size()) {
			            				border.getTop().setVisible(false);
			            				border.setCenter(startTest);
			            				border.setAlignment(startTest, Pos.CENTER);
			            			}
			            			else {
					                border.setCenter(example.get(i));
			            			}	
			            		}
		            }	
		        });
	        startTest.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					Display test = new Display(parsedStage, false, false);
				}
				
			});
	        parsedStage.setScene(scene);
	}
}
