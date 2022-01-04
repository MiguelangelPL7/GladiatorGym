package mvc.model.dao;

import conexion.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends ConexionBD{

    public void consultarAlumnos() {

        try {

            ResultSet rsc;
            String sql ="";

            sql = "SELECT * FROM Alumno;";
            rsc = this.ejecutarSQL(sql);

            if (rsc != null)
            {
                System.out.println("Datos Alumnos\n");
                System.out.println("Código  Nombre Edad Telefono");
                System.out.println("--------------------------------");
                while (rsc.next()) {
                    System.out.println(rsc.getString("Nombre") + " "
                            +rsc.getString("Apellido") + " "
                            +rsc.getInt("Edad"));
                }
            } else {
                System.out.println("No existen Datos Alumnos.");
            }

            rsc.close();
        } catch (SQLException e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }
    }
}
