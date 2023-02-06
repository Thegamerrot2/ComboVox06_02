module com.example.combovox {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.combovox to javafx.fxml;
    exports com.example.combovox;
}