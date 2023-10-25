module com.example.graph_6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.graph_6 to javafx.fxml;
    exports com.example.graph_6;
}