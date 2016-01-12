package application;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class ResultActionHandle {
	private String answer;
	
	

	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}

	ResultActionHandle(Button result,MediaPlayer mediaPlayer, KeyHandle kh, BorderPane border, boolean last) {
		answer = new String();
		//result.setDisable(!last);
		result.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				mediaPlayer.pause();
				double time = (kh.getEndTime()  - kh.getStartTime());
			 //  String fileReadAnswer = new String ((new LastLineOfFile(new File("results.txt"),1).getStr()));
			//	String result = fileReadAnswer.split("\t\t")[0];
				String result = "";
				setAnswer(result+ '\n' + "Точки: " + kh.getPoints() + "\t \t Време/в милисекунди/: " + time);
				border.setCenter(new Text( answer));
				
			}
        	
        });
		 
	}
}
