package application;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class Display {
	ResultActionHandle rah;
	
	Display(Stage parsedStage,boolean withMusic, boolean last){
		try {
			BorderPane border = new BorderPane();
			Scene scene = new Scene(border,640,300);
			File file = new File("D:\\krissy\\a.mp3");
				Media media = new Media(file.toURI().toURL().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(media);
				MediaView mediaViewer = new MediaView(mediaPlayer);
				mediaPlayer.setAutoPlay(withMusic);
				border.setLeft(mediaViewer);
			String text= new String("\t Колко еднкви цифри виждате написани? \n Натиснете:\t'D' за две, \n\t\t\t'K' за три, \n\t\t\t'O' за четири." );
			Label instructions= new Label(text);
			instructions.setFont(new Font("Ariel", 20));
			border.setPadding(new Insets(10));
			Text t = new Text("\n Натиснете 'ЕNTER' два последователни пъти, за да започнете!");
			border.setStyle("-fx-background-color: #FFFFFF;");
			border.setCenter(t);
			RowExample example = new RowExample();
			BorderPane.setAlignment(instructions, Pos.CENTER);
			border.setTop(instructions);
	       
	        Button result=  new Button("Виж резултата си");
	        Button partTwo = new Button("Част две");
	        if (last) {
	        	
	        	partTwo.setText("КРАЙ");
	        	 partTwo.setOnAction(new EventHandler<ActionEvent>() {
	 				@Override
	 				public void handle(ActionEvent arg0) {
	 					Final last = new Final(parsedStage);
	 					
	 				}
	 				
	 			});
	        }
	        KeyHandle kh = new KeyHandle();
	        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        	public void handle(KeyEvent ke) {
		            		if(ke.getCode() == KeyCode.ENTER) {
		            			
		           			 kh.set(scene, border,example,result,partTwo);
		           			kh.setStartTime(System.currentTimeMillis());
		            		}
		            }	
		        });

			ResultActionHandle rah = new ResultActionHandle(result, mediaPlayer,kh, border, last);
			//PART TWO
			if (!last) {
		        partTwo.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						String one = new String(rah.getAnswer());
						mediaPlayer.pause();
						writeToFile(kh, rah);
						Display partTwo = new Display(parsedStage,true,true);
					}
					
				});
			}
			
			parsedStage.setOnCloseRequest(new EventHandler<WindowEvent> (){
				@Override
				public void handle(WindowEvent event) {
					writeToFile(kh, rah);	
				}
			});
			
			parsedStage.setScene(scene);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void writeToFile(KeyHandle kh, ResultActionHandle rah) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.txt", true),
					 "Unicode"));
            BufferedWriter bw = new BufferedWriter( writer );
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            double time = (kh.getEndTime()  - kh.getStartTime());
			   rah.setAnswer("Точки: " + kh.getPoints() + "\t \t Време/в милисекунди/: " + time);		   
            writer.append(System.getProperty("line.separator"));
            writer.append(rah.getAnswer() + "\t\t" + dateFormat.format(date));
            bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
