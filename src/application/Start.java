package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane border = new BorderPane();
			Scene scene = new Scene(border,640,300);
			String text= new String("\t Тест за концентрация!" );
			Label instructions= new Label(text);
			instructions.setFont(new Font("Ariel", 20));
			border.setPadding(new Insets(10));
			Text instruction = new Text("\n Условия!");
			border.setStyle("-fx-background-color: #FFFFFF;");
			border.setCenter(instruction);
			BorderPane.setAlignment(instructions, Pos.CENTER);
			border.setTop(instructions);
	       
	        Button start=  new Button("Започни");
	       border.setBottom(start);
	       border.setAlignment(start, Pos.CENTER);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			start.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					ZeroStart zeroExample = new ZeroStart(primaryStage);
				}
				
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
