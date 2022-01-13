package mvc.model.dao;
import conexion.ConexionBD;
import mvc.model.vo.Activity;
import mvc.model.vo.Track;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackDAO extends ConexionBD{

    public ArrayList<Track> listar(){
        ArrayList<Track> listaPistas = new <Track>ArrayList();
        try{
            String sql = "Select * from pistas;";
            ResultSet rsc = this.ejecutarSQL(sql);

            while(rsc.next()){
                Track pista = new Track();
                pista.setCodigoPista(rsc.getInt("CodigoPista"));
                pista.setPistaPID(rsc.getInt("PistaPid"));
                pista.setPistaHorario(rsc.getString("PistaHorario"));
                pista.setMiembroID(rsc.getInt("MiembroID"));
                pista.setPistaDisponibilidad(rsc.getBoolean("PistaDisponibilidad"));
                pista.setPrecioPorHora(rsc.getDouble("PrecioPorHora"));
                listaPistas.add(pista);
            }

            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al listar Pistas.\n" + e.getMessage());
        }

        return(listaPistas);
    }

    public void eliminar(Track pista){
        try{
            int cod = pista.getCodigoPista();
            String sql = "DELETE FROM pistas WHERE CodigoPista="+cod+";";
            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al eliminar Pista.\n" + e.getMessage());
        }
    }

    public void registrar(Track pista){
        try{
            int a = pista.getCodigoPista();
            int b = pista.getPistaPID();
            String c = pista.getPistaHorario();
            String d = checkNullDouble(pista.getMiembroID());
            int e = pista.getPistaDisponibilidad() ? 1 : 0;
            String f = checkNullDouble(pista.getPrecioPorHora());

            String sql = "INSERT INTO pistas (CodigoPista, PistaPID, PistaHorario, " +
                    "MiembroID, PistaDisponibilidad, PrecioPorHora) VALUES ("+a+","+b+",'"+
                    c+"',"+d+","+e+","+f+");";

            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al registar Pista.\n" + e.getMessage());
        }
    }

    public boolean validarCodigoPista(int cod){
        try{
            String sql = "Select CodigoPista from pistas where CodigoPista="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar codigo de pista.\n" + e.getMessage());
            return false;
        }
    }

    public ArrayList<String> mostrarInfoAtributos(int cod){
        ArrayList<String> info = new <String>ArrayList();
        try{
            String sql = "Select * from pistas where CodigoPista="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.next();

            info.add(rsc.getString("CodigoPista"));
            info.add(rsc.getString("PistaPID"));
            info.add(rsc.getString("PistaHorario"));
            info.add(rsc.getString("MiembroID"));
            info.add(rsc.getString("PistaDisponibilidad"));
            info.add(rsc.getString("PrecioPorHora"));

            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al obtener info de pista.\n" + e.getMessage());
        }

        return(info);
    }

    public boolean actualizar(Track pista){
        try{
            int a = pista.getCodigoPista();
            int b = pista.getPistaPID();
            String c = pista.getPistaHorario();
            String d = checkNullInt(pista.getMiembroID());
            int e = pista.getPistaDisponibilidad() ? 1 : 0;
            String f = checkNullDouble(pista.getPrecioPorHora());
            String sql = "UPDATE pistas SET PistaPID="+b+", PistaHorario='"+c+"', MiembroID="+d+", " +
                    "PistaDisponibilidad="+e+", PrecioPorHora="+f+" WHERE CodigoPista="+a+";";


            this.ejecutarActualizacion(sql);
        }catch (Exception e) {
            System.out.println("Error al actualizar Actividad.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    public int validarHorario(int pid, String horario){
        try{
            String sql = "Select * from pistas WHERE PistaPID="+pid+" AND PistaHorario='"+horario+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                int codigo = rsc.getInt("CodigoPista");
                int disp = rsc.getInt("PistaDisponibilidad");
                rsc.close();
                if(disp==0) {return 0;} else { return codigo; }
            }else{
                rsc.close();
                return 0;
            }
        }catch (SQLException e) {
            System.out.println("Error al comprobar codigo de pista.\n" + e.getMessage());
            return 0;
        }
    }

    public double apuntarMiembroPista(int cod, int id, int duracion){
        try{
            String sql = "UPDATE pistas SET MiembroID="+id+" WHERE CodigoPista="+cod+";";
            this.ejecutarActualizacion(sql);

        }catch (Exception e) {
            System.out.println("Error al apuntar miembro Pista.\n" + e.getMessage());
            return -1;
        }

        return actualizarPista(cod,duracion);

    }

    public double actualizarPista(int cod, int duracion){
        double precio;

        try{
            String sql = "Select * from pistas where CodigoPista="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);

            rsc.next();
            precio=rsc.getDouble("PrecioPorHora")*duracion;
            rsc.close();

            String sql2 = "UPDATE pistas SET PistaDisponibilidad=0 WHERE CodigoPista="+cod+";";
            this.ejecutarActualizacion(sql2);

        }catch (SQLException e) {
            System.out.println("Error al actualizar pista.\n" + e.getMessage());
            return -1;
        }

        return precio;
    }

    private String checkNullInt(int n){
        if(n==0) return null;
        return String.valueOf(n);
    }

    private String checkNullDouble(double n){
        if(n==0) return null;
        return String.valueOf(n);
    }
}
