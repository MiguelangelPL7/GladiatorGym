package mvc.model.dao;
import conexion.ConexionBD;
import mvc.model.vo.Activity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivityDAO extends ConexionBD {

    public ArrayList<Activity> listar() throws Exception{
        ArrayList<Activity> listaActividades = new <Activity>ArrayList();
        try{
            String sql = "Select * from actividades;";
            ResultSet rsc = this.ejecutarSQL(sql);

            while(rsc.next()){
                Activity actividad = new Activity();
                actividad.setCodigoActividad(rsc.getInt("CodigoActividad"));
                actividad.setActividadPID(rsc.getInt("ActividadPid"));
                actividad.setActividadHorario(rsc.getTimestamp("ActividadHorario"));
                actividad.setMonitorDNI(rsc.getString("MonitorDNI"));
                actividad.setActividadDisponibilidad(rsc.getBoolean("ActividadDisponibilidad"));
                actividad.setCapacidadMaxima(rsc.getInt("CapacidadMaxima"));
                listaActividades.add(actividad);
            }

            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al listar Actividades.\n" + e.getMessage());
        }

        return(listaActividades);
    }

    public void eliminar(Activity actividad) throws Exception{
        try{
            int cod = actividad.getCodigoActividad();
            String sql = "DELETE FROM actividades WHERE CodigoActividad="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al eliminar Actividad.\n" + e.getMessage());
        }
    }

    public void registrar(Activity actividad) throws Exception{
        try{
            int a = actividad.getCodigoActividad();
            int b = actividad.getActividadPID();
            String c = actividad.getActividadHorario().toString();
            String d = actividad.getMonitorDNI();
            int e = actividad.getActividadDisponibilidad() ? 1 : 0;
            int f = actividad.getCapacidadMaxima();

            String sql = "INSERT INTO actividades (CodigoActividad, ActividadPID, ActividadHorario, " +
                    "MonitorDNI, ActividadDisponibilidad, CapacidadMaxima) VALUES ("+a+","+b+","+
                    c+","+d+","+e+","+f+");";

            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al registar Actividad.\n" + e.getMessage());
        }
    }
}
