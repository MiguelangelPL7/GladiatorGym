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
            String f = checkNullInt(actividad.getCapacidadMaxima());

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

    public Activity mostrarInfoAtributos(int cod){
        Activity actividad = new Activity();
        try{
            String sql = "Select * from actividades where CodigoActividad="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.next();

            actividad.setCodigoActividad(rsc.getInt("CodigoActividad"));
            actividad.setActividadPID(rsc.getInt("ActividadPid"));
            actividad.setActividadHorario(rsc.getString("ActividadHorario"));
            actividad.setMonitorDNI(rsc.getString("MonitorDNI"));
            actividad.setActividadDisponibilidad(rsc.getBoolean("ActividadDisponibilidad"));
            actividad.setCapacidadMaxima(rsc.getInt("CapacidadMaxima"));

            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al obtener info de actividad.\n" + e.getMessage());
        }

        return(actividad);
    }

    public boolean actualizar(Activity actividad){
        try{
            int a = actividad.getCodigoActividad();
            int b = actividad.getActividadPID();
            String c = actividad.getActividadHorario();
            String d = actividad.getMonitorDNI();
            int e = actividad.getActividadDisponibilidad() ? 1 : 0;
            String f = checkNullInt(actividad.getCapacidadMaxima());
            String sql = "UPDATE actividades SET ActividadPID="+b+", ActividadHorario='"+c+"', MonitorDNI="+d+", " +
                    "ActividadDisponibilidad="+e+", CapacidadMaxima="+f+" WHERE CodigoActividad="+a+";";


            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al actualizar Actividad.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    public int validarHorario(int pid, String horario){
        try{
            String sql = "Select * from actividades WHERE ActividadPID="+pid+" AND ActividadHorario='"+horario+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                int codigo = rsc.getInt("CodigoActividad");
                int disp = rsc.getInt("ActividadDisponibilidad");
                rsc.close();
                if(disp==0) {return 0;} else { return codigo;}
            }else{
                rsc.close();
                return 0;
            }
        }catch (SQLException e) {
            System.out.println("Error al comprobar codigo de actividad.\n" + e.getMessage());
            return 0;
        }
    }

    public boolean apuntarMiembroActividad(int cod, int id){
        try{
            String sql = "INSERT INTO miembrosactividad (CodigoActividad, MiembroID) VALUES ("+cod+","+id+");";
            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al apuntar miembro Actividad.\n" + e.getMessage());
            return false;
        }

        return actualizarActividad(cod);

    }

    public boolean validarMiembroActividad(int cod, int id){
        try{
            String sql = "Select * from miembrosactividad where CodigoActividad="+cod+" AND MiembroID="+id+";";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar miembro/actividad.\n" + e.getMessage());
            return false;
        }
    }

    public boolean actualizarActividad(int cod){
        try{
            String sql = "Select * from actividades where CodigoActividad="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);

            rsc.next();
            int capacidad=rsc.getInt("CapacidadMaxima");
            rsc.close();

            capacidad -= 1;
            int disp=1;
            if(capacidad==0) disp=0;

            String sql2 = "UPDATE actividades SET ActividadDisponibilidad="+disp+", CapacidadMaxima="+capacidad+" WHERE CodigoActividad="+cod+";";
            this.ejecutarActualizacion(sql2);

        }catch (SQLException e) {
            System.out.println("Error al actualizar actividad.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    private String checkNullInt(int n){
        if(n==0) return null;
        return String.valueOf(n);
    }


}
