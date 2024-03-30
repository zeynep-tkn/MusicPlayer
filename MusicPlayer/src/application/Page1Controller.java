package application;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Page1Controller implements Initializable {

    @FXML
    private ImageView exitImage;


    @FXML
    private TableView<Sarkilar> table;

    @FXML
    private TableColumn<Sarkilar,String> sarkiAdi;

    @FXML
    private TableColumn<Sarkilar,Float> sure;

    @FXML
    private TableColumn<Sarkilar,String> turu;

    @FXML
    private TableColumn<Sarkilar,String> sanatciAdi;
    
    
    // Müzik listem
    ObservableList<Sarkilar> list = FXCollections.observableArrayList(
        new Sarkilar("Efsane.mp3","Ayşe Hatun Önal",(float)3.45,"Türkçe pop"),
        new Sarkilar("BasitNumaralar.mp3","Zerrin Özer",(float) 2.54,"Türkçe pop"),
        new Sarkilar("Veto.mp3","Bengü",(float) 2.34,"Türkçe pop"),
        new Sarkilar("Kafa.mp3", "Sıla", (float) 3.01, "Türkçe pop"),
        new Sarkilar("SariKurdeleler.mp3", "Model",(float) 4.49, "Türkçe pop")
    );
    
    //MediaPlayer nesnesi
    @SuppressWarnings("exports")
	public static MediaPlayer mediaPlayer;
    
    
    
    //
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Müzik klasörünü belirttiğiniz dizine göre değiştirin
        String musicFolderPath = "C:\\Users\\Ahmet Selim\\Desktop\\zeynep (1)\\MuzikListem";

        // Tablo değişkenleri
        sarkiAdi.setCellValueFactory(new PropertyValueFactory<Sarkilar,String>("sarkiAdi"));
        sure.setCellValueFactory(new PropertyValueFactory<Sarkilar,Float>("sure"));
        turu.setCellValueFactory(new PropertyValueFactory<Sarkilar,String>("turu"));
        sanatciAdi.setCellValueFactory(new PropertyValueFactory<Sarkilar,String>("sanatciAdi"));
        
        // Tabloya verileri ekle
        table.setItems(list);
        
        // Tablo tıklama olayı kontrol
        table.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) { // Tek tıklama olayını kontrol et
                Sarkilar selectedSarki = table.getSelectionModel().getSelectedItem();
                if (selectedSarki != null) {
                    String sarkiAdi = selectedSarki.getSarkiAdi();
                    String sarkiKlasor = musicFolderPath + "\\" + sarkiAdi.replaceAll(".mp3", "");
                    // Şarkının klasörünü seç ve çal
                    playMusic(sarkiKlasor, sarkiAdi);
                }
            }
        });
    }
    
    // Müziği çalma metodu
    public void playMusic(String musicFolder, String musicFileName) {
    	//Eğer bir önceki çalma varsa durdur
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    	
    	
      //Çalma işlemlerini gerçekleştir
        String musicFile = musicFolder + "\\" + musicFileName;
        Media media = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        
      
    }
   
    
    
    //Uygulamadan çıkış yap
    @FXML
    private void logOutSample(MouseEvent event) {
        
        javafx.application.Platform.exit();
    }

    // Belirli bir dizindeki müzik klasörlerini alır
    @SuppressWarnings("unused")
	private List<String> getMusicFolders(String musicFolderPath) {
        List<String> musicFolders = new ArrayList<>();
        File musicFolder = new File(musicFolderPath);

        // Belirtilen dizin var mı ve bir klasör mü diye kontrol et
        if (musicFolder.exists() && musicFolder.isDirectory()) {
            // Dizindeki tüm klasörleri al
            File[] folders = musicFolder.listFiles(File::isDirectory);

            // Klasörler varsa, isimlerini listeye ekle
            if (folders != null) {
                for (File folder : folders) {
                    musicFolders.add(folder.getName());
                }
            }
        }
        return musicFolders;
    }
}