package mvc.model;

import mvc.model.dao.ActivityDAO;
import mvc.model.dao.EmployeeDAO;
import mvc.model.vo.Activity;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Logic {
    public boolean validarDNI(String dni){
        EmployeeDAO emp = new EmployeeDAO();
        return emp.validarDNI(dni);
    }

    public boolean validarCodigoActividad(int cod){
        ActivityDAO act = new ActivityDAO();
        return act.validarCodigoActividad(cod);
    }

    public ArrayList<String> solicitarInfoA(int CodigoActividad){
        ArrayList<String> info = new ArrayList<String>();
        if(validarCodigoActividad(CodigoActividad)){
            ActivityDAO act = new ActivityDAO();
            info = act.mostrarInfoAtributos(CodigoActividad);
        }else{
            info.add("null"); // si info.get(0)=="null" entonces codigo de actividad inválido
        }
        return info;
    }

    public int validarModificarAtributosA(Activity act){
        int cod = act.getCodigoActividad();
        ArrayList<String> atributos = new ArrayList<String>();
        atributos.add(String.valueOf(cod));
        atributos.add(String.valueOf(act.getActividadPID()));
        atributos.add(act.getActividadHorario());
        atributos.add(act.getMonitorDNI());
        atributos.add(String.valueOf(act.getActividadDisponibilidad() ? 1 : 0));
        atributos.add(String.valueOf(act.getCapacidadMaxima()));

        if(validarCodigoActividad(cod)){
            if(validarAtributos("actividad", atributos)){
                ActivityDAO actD = new ActivityDAO();
                if(actD.actualizar(act)) {return 1;} else { return 0;}
            }else{
                return -1; // -1 = atributos inválidos
            }
        }else{
            return -2; //-2 = codigo de actividad inválido
        }
    }

    public boolean validarAtributos(String tipo, ArrayList<String> atributos){
        if(tipo=="actividad"){
            if(!validarInt(atributos.get(1)) && atributos.get(1)!=null){ return false;}
            if(!validarFecha(atributos.get(2)) && atributos.get(2)!=null){ return false; }
            if(atributos.get(3)!=null && !validarFormatoDNI(atributos.get(3))){ return false; }
            if(!atributos.get(4).equals("0") && !atributos.get(4).equals("1")) { return false; }
            if(!validarInt(atributos.get(5)) && atributos.get(5)!=null){ return false;}
            return true;
        }
        return false;
    }

    private static boolean validarFecha(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(fecha.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    private static boolean validarInt(String num) {
        if(num.matches("[0-9]+") && num.length() > 2) { return true;}
        return false;
    }

    private static boolean validarFormatoDNI(String num) {
        if(num.length()!=9 || Character.isLetter(num.charAt(8)) == false) { return false;}
        return true;
    }
}
