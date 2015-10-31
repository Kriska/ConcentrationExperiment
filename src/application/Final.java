package application;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Final {
	Final(Stage stage) {
		BorderPane border = new BorderPane();
		Scene scene = new Scene(border,640,300);
		String text= new String("\t Благодаря за отделеното време." );
		Label instructions= new Label(text);
		instructions.setFont(new Font("Ariel", 20));
		border.setPadding(new Insets(10));
		border.setStyle("-fx-background-color: #FFFFFF;");
		border.setCenter(instructions);
		
		BorderPane.setAlignment(instructions, Pos.CENTER);
       stage.setScene(scene);
	}
}
