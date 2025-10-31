module com.example.courseworktwop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.courseworktwop to javafx.fxml;
    exports com.example.courseworktwop;
}