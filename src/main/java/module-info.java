module com.vex.vexillum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vex.vexillum to javafx.fxml;
    exports com.vex.vexillum;
    exports com.vex.vexillum.model;
    opens com.vex.vexillum.model to javafx.fxml;
    exports com.vex.vexillum.control;
    opens com.vex.vexillum.control to javafx.fxml;
}