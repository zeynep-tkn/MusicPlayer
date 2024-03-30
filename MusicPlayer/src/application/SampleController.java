package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;

//oynatilan şarkı sayfasının kontrolü
public class SampleController implements Initializable {
	@FXML
    private ImageView exitImage;
	@FXML 
    private AnchorPane anchorPane; 
    @FXML 
    private BorderPane borderPane; 
    
    @FXML
    private ImageView backwardImage;
    @FXML
    private ImageView forwardImage;
    @FXML
    private ImageView pauseImage;
    
    @FXML
    private ProgressBar progressBar;
   
    
    @FXML
    private Slider soundSlider;
    @FXML
    private ComboBox<?> speedCombo;

    
    //sonradene
    //private int speeds[]= {25,50,75,100,125,150,175,200};
    
    
    
   
    
    
    
    
    
    
    
    private MediaPlayer mediaPlayer;
    //deniyoruz progressbar ı
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Page1Controller'daki MediaPlayer'a erişim
        if (Page1Controller.mediaPlayer != null) {
            mediaPlayer = Page1Controller.mediaPlayer;

            // MediaPlayer'ın durumu değiştiğinde ProgressBar'ı güncelle
            mediaPlayer.statusProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue == MediaPlayer.Status.PLAYING) {
                    updateProgressBar();
                }
            });

            // Slider değeri değiştiğinde ProgressBar'ı güncelle
            mediaPlayer.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
                if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    updateProgressBar();
                }
            });
        } 
        else {
            System.out.println("Page1Controller'dan mediaPlayer null geldi.");
        }
    }

 // deniyozhala   ProgressBar'ı güncelleyen metod
    private void updateProgressBar() {
        Platform.runLater(() -> {
            double totalDuration = mediaPlayer.getTotalDuration().toSeconds();
            double currentDuration = mediaPlayer.getCurrentTime().toSeconds();
            double progress = currentDuration / totalDuration;

            // Progress bar'ı güncelle
            progressBar.setProgress(progress);
        });
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
	private void oynatilanSarki(MouseEvent event) {
		borderPane.setCenter(anchorPane);
	}
    
	@FXML
	private void müzikListesi(MouseEvent event) {
		loadPage("Page1");
	}
	
	@FXML
	private void ayarlar(MouseEvent event) {
		loadPage("Page2");
	}
	
	
	private void loadPage(String page) {
		Parent root =null;
		try {
			root=FXMLLoader.load(getClass().getResource(page+".fxml"));
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		borderPane.setCenter(root);
		
	}
	
    
	@FXML
    void logOutSample(MouseEvent event) {
        javafx.application.Platform.exit();
    }
	
	
	//1şarkıyı geri sar
	@FXML
    void Backward(MouseEvent event) {
     
    }
    //1şarkıyı ileri sar
    @FXML
    void Forward(MouseEvent event) {

    }
    
   
    
    
    
    
    
    //şarkıyı durdur tekrar basınca oynat
    private boolean isPaused = false; // Şarkının duraklatılmış olup olmadığını tutan değişken
    @FXML
    void Pause(MouseEvent event) {
    	
    	if (Page1Controller.mediaPlayer != null) {
            if (isPaused) {
                // Eğer şarkı duraklatılmışsa, devam ettir
                Page1Controller.mediaPlayer.play();
                isPaused = false;
               
            }
            else {
                // Eğer şarkı çalınıyorsa, duraklat
                Page1Controller.mediaPlayer.pause();
                isPaused = true;
            }
        }
    }


    
    
    
    
    
    
   

    //1hızını arttır
    @FXML
    public void ChangeSpeed(@SuppressWarnings("exports") ActionEvent event) {
    	
    }
    
   
    //sesi arttır(tam artış azalış olmuyor)
    	@SuppressWarnings("exports")
		@FXML
    	public void ChangeSound(MouseEvent event) {
    	    double soundValue = soundSlider.getValue(); // Slider'ın değerini al
    	    System.out.println("Sound Value: " + soundValue); // Değeri kontrol amaçlı yazdırabilirsiniz

    	    // MediaPlayer nesnesi Page1Controller sınıfında tanımlanmış olmalı
    	    if (Page1Controller.mediaPlayer != null) {
    	        Page1Controller.mediaPlayer.setVolume(soundValue); // Ses seviyesini güncelle
    	    }
    	}
   
}
