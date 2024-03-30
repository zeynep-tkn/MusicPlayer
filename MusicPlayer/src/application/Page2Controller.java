package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Page2Controller implements Initializable{
//ayarların kontrolü sayfasi
	@FXML
    private ImageView exitImage;
	
	@FXML
    private void logOutSample(MouseEvent event) {
        javafx.application.Platform.exit();
    }


    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
//deneme
}
