module MuzikCalar {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.media;
	requires javafx.graphics;
	requires javafx.base;

    opens application to javafx.graphics, javafx.fxml;

    exports application;

}

/*module MuzikCalar {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
*/