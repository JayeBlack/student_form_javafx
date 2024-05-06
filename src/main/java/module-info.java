module com.practice2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.practice2 to javafx.fxml;
    exports com.practice2;
}