module com.vex.vexillum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vex.vexillum to javafx.fxml;
    exports com.vex.vexillum;
}