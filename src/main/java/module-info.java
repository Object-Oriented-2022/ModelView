module com.example.cs4773hw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example to javafx.fxml;
    exports com.example;
    exports com.example.ViewModel;
    opens com.example.View;
    exports com.example.View to javafx.fxml;
    opens com.example.ViewModel to javafx.fxml;
    exports com.example.Model;
    opens com.example.Model to javafx.fxml;
}