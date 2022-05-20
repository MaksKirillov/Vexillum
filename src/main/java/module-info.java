module com.vex.vexillum {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vex.vexillum to javafx.fxml;
    exports com.vex.vexillum;
    exports com.vex.vexillum.begin;
    opens com.vex.vexillum.begin to javafx.fxml;
    exports com.vex.vexillum.chose;
    opens com.vex.vexillum.chose to javafx.fxml;
    exports com.vex.vexillum.complete;
    opens com.vex.vexillum.complete to javafx.fxml;
    exports com.vex.vexillum.level;
    opens com.vex.vexillum.level to javafx.fxml;
    exports com.vex.vexillum.login;
    opens com.vex.vexillum.login to javafx.fxml;
    exports com.vex.vexillum.menu;
    opens com.vex.vexillum.menu to javafx.fxml;
    exports com.vex.vexillum.stats;
    opens com.vex.vexillum.stats to javafx.fxml;
    exports com.vex.vexillum.winlose;
    opens com.vex.vexillum.winlose to javafx.fxml;
    exports com.vex.vexillum.model;
    opens com.vex.vexillum.model to javafx.fxml;
}