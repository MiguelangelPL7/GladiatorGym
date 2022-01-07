package mvc.model.dao;
import conexion.ConexionBD;
import mvc.model.vo.Activity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivityDAO extends ConexionBD {

    public ArrayList<Activity> listar(){
        ArrayList<Activity> listaActividades = new <Activity>ArrayList();
        try{
            String sql = "Select * from actividades;";
            ResultSet rsc = this.ejecutarSQL(sql);

            while(rsc.next()){
                Activity actividad = new Activity();
                actividad.setCodigoActividad(rsc.getInt("CodigoActividad"));
                actividad.setActividadPID(rsc.getInt("ActividadPid"));
                actividad.setActividadHorario(rsc.getString("ActividadHorario"));
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

    public void eliminar(Activity actividad){
        try{
            int cod = actividad.getCodigoActividad();
            String sql = "DELETE FROM actividades WHERE CodigoActividad="+cod+";";
            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al eliminar Actividad.\n" + e.getMessage());
        }
    }

    public void registrar(Activity actividad){
        try{
            int a = actividad.getCodigoActividad();
            int b = actividad.getActividadPID();
            String c = actividad.getActividadHorario();
            String d = actividad.getMonitorDNI();
            int e = actividad.getActividadDisponibilidad() ? 1 : 0;
            int f = actividad.getCapacidadMaxima();

            String sql = "INSERT INTO actividades (CodigoActividad, ActividadPID, ActividadHorario, " +
                    "MonitorDNI, ActividadDisponibilidad, CapacidadMaxima) VALUES ("+a+","+b+",'"+
                    c+"',"+d+","+e+","+f+");";

            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al registar Actividad.\n" + e.getMessage());
        }
    }

    public boolean validarCodigoActividad(int cod){
        try{
            String sql = "Select CodigoActividad from actividades where CodigoActividad="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar codigo de actividad.\n" + e.getMessage());
            return false;
        }
    }

    public ArrayList<String> mostrarInfoAtributos(int cod){
        ArrayList<String> info = new <String>ArrayList();
        try{
            String sql = "Select * from actividades where CodigoActividad="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.next();

            info.add(rsc.getString("CodigoActividad"));
            info.add(rsc.getString("ActividadPid"));
            info.add(rsc.getString("ActividadHorario"));
            info.add(rsc.getString("MonitorDNI"));
            info.add(rsc.getString("ActividadDisponibilidad"));
            info.add(rsc.getString("CapacidadMaxima"));

            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al obtener info de actividad.\n" + e.getMessage());
        }

        return(info);
    }

    public boolean actualizar(Activity actividad){
        try{
            int a = actividad.getCodigoActividad();
            int b = actividad.getActividadPID();
            String c = actividad.getActividadHorario();
            String d = actividad.getMonitorDNI();
            int e = actividad.getActividadDisponibilidad() ? 1 : 0;
            int f = actividad.getCapacidadMaxima();
            String sql = "UPDATE actividades SET ActividadPID="+b+", ActividadHorario='"+c+"', MonitorDNI="+d+", " +
                    "ActividadDisponibilidad="+e+", CapacidadMaxima="+f+" WHERE CodigoActividad="+a+";";


            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al actualizar Actividad.\n" + e.getMessage());
            return false;
        }

        return true;
    }


}
