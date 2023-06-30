module com.example.reboot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.reboot to javafx.fxml;
    exports com.example.reboot;
}