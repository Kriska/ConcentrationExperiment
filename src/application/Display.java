package application;
	
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
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
			File file = new File("a.mp3");
				Media media = new Media(file.toURI().toURL().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(media);
				MediaView mediaViewer = new MediaView(mediaPlayer);
				if (withMusic) {
					mediaPlayer.setOnEndOfMedia(new Runnable() {
					       public void run() {
					         mediaPlayer.seek(Duration.ZERO);
					       }
					   });
					  mediaPlayer.play();
					mediaPlayer.setAutoPlay(withMusic);
				}
				border.setLeft(mediaViewer);
			String text= new String("\t Колко еднкви цифри виждате написани? \n Натиснете:\t'2' за две, \n\t\t\t'3' за три, \n\t\t\t'4' за четири." );
			Label instructions= new Label(text);
			instructions.setFont(new Font("Ariel", 20));
			border.setPadding(new Insets(10));
			String pressEnterInstruction = new String("\n Натиснете 'ЕNTER' два последователни пъти, за да започнете!");
			Text t = new Text(pressEnterInstruction);
			border.setStyle("-fx-background-color: #FFFFFF;");
			border.setCenter(t);
			RowExample example = new RowExample(false);
			BorderPane.setAlignment(instructions, Pos.CENTER);
			border.setTop(instructions);
	       
	        Button result=  new Button("Виж резултата си");
	        Button partTwo = new Button("Част две");
	        //да изписва края 
	        if (last) {
	        	partTwo.setText("КРАЙ");
	        	 partTwo.setOnAction(new EventHandler<ActionEvent>() {
	 				@Override
	 				public void handle(ActionEvent arg0) {
	 					mediaPlayer.pause();
	 					new Final(parsedStage);
	 					
	 				}
	 				
	 			});
	        }
	        KeyHandle kh = new KeyHandle();
	        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	        	public void handle(KeyEvent ke) {
		            		if(ke.getCode() == KeyCode.ENTER) {
		           			 kh.set(scene, border,example,result,partTwo,last);
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
						new String(rah.getAnswer());
						mediaPlayer.pause();
						writeToFile(kh, rah);
						new Display(parsedStage,true,true);
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
		BufferedWriter writer = null;
		try {
			 writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.txt", true),
					Charset.forName("UTF-16")));            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            double time = (kh.getEndTime()  - kh.getStartTime());
			   rah.setAnswer("Точки: " + kh.getPoints() + "\t \t Време/в милисекунди/: " + time);		   
            writer.append(System.getProperty("line.separator"));
            writer.append(rah.getAnswer() + "\t\t" + dateFormat.format(date));
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
