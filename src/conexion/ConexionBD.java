package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionBD {

    private String driverMySQL="com.mysql.cj.jdbc.Driver";
    //private String driverMySQL="com.mysql.jdbc.Driver";
    private String host;
    private String port;
    private String database;
    private String user;
    private String password;

    //Constructores

    public ConexionBD() {
        host = "localhost";
        port = "3308";
        database = "Alumnos";
        user = "root";
        password = "Villabalter1";
    }
    public ConexionBD(String host, String port, String database,
                                String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public ConexionBD(String driverMySQL, String host, String port,
                                String database, String user, String password) {
        this.driverMySQL = driverMySQL;
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    //Métodos
    private Connection establecerConexion() {
        Connection conexion;
        try {
            Class.forName(this.driverMySQL);
            conexion = DriverManager.getConnection(
                    "jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database
                            +"?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    this.user,
                    this.password);
            return conexion;
        } catch (SQLException e) {
            System.out.println("Error conexión con el Servidor MySQL.\n"
                    + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error driver JDBC, clase no encontrada");
        }
        return null;
    }

    public ResultSet ejecutarSQL(String CadenaSQL) {
        Connection conexionConSQL = establecerConexion();
        Statement statconcons = null;
        ResultSet rsESQL = null;
        try {
            statconcons = conexionConSQL.createStatement();
            rsESQL = statconcons.executeQuery(CadenaSQL);
            return rsESQL;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void ejecutarActualizacion(String cadenaSQL) {
        Connection conexionActSQL = establecerConexion();
        Statement statconact = null;
        try {
            statconact = conexionActSQL.createStatement();
            statconact.executeUpdate(cadenaSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statconact.close();
            } catch (Exception e) {

            }
            try {
                conexionActSQL.close();
            } catch (Exception e) {

            }
        }
    }



}