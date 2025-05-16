module co.edu.uniquindio.empledos.empleadosapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.empledos.empleadosapp to javafx.fxml;
    exports co.edu.uniquindio.empledos.empleadosapp;
}