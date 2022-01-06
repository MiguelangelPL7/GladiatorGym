package mvc.model.dao;
import conexion.ConexionBD;
import mvc.model.vo.Track;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrackDAO extends ConexionBD{

    public ArrayList<Track> listar() throws Exception{
        ArrayList<Track> listaPistas = new <Track>ArrayList();
        try{
            String sql = "Select * from pistas;";
            ResultSet rsc = this.ejecutarSQL(sql);

            while(rsc.next()){
                Track pista = new Track();
                pista.setCodigoPista(rsc.getInt("CodigoPista"));
                pista.setPistaPID(rsc.getInt("PistaPid"));
                pista.setPistaHorario(rsc.getTimestamp("PistaHorario"));
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

    public void eliminar(Track pista) throws Exception{
        try{
            int cod = pista.getCodigoPista();
            String sql = "DELETE FROM pistas WHERE CodigoPista="+cod+";";
            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al eliminar Pista.\n" + e.getMessage());
        }
    }

    public void registrar(Track pista) throws Exception{
        try{
            int a = pista.getCodigoPista();
            int b = pista.getPistaPID();
            String c = pista.getPistaHorario().toString();
            int d = pista.getMiembroID();
            int e = pista.getPistaDisponibilidad() ? 1 : 0;
            double f = pista.getPrecioPorHora();

            String sql = "INSERT INTO pistas (CodigoPista, PistaPID, PistaHorario, " +
                    "MiembroID, PistaDisponibilidad, PrecioPorHora) VALUES ("+a+","+b+","+
                    c+","+d+","+e+","+f+");";

            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al registar Pista.\n" + e.getMessage());
        }
    }
}
