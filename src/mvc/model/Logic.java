package mvc.model;

import mvc.model.dao.ActivityDAO;
import mvc.model.dao.TrackDAO;
import mvc.model.dao.EmployeeDAO;
import mvc.model.dao.MemberDAO;
import mvc.model.vo.Activity;
import mvc.model.vo.Track;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Logic {
    public boolean validarDNI(String dni){
        EmployeeDAO emp = new EmployeeDAO();
        return emp.validarDNI(dni);
    }

    public boolean validarID(int id){
        MemberDAO emp = new MemberDAO();
        return emp.validarID(id);
    }

    public boolean validarID_activo(int id){
        MemberDAO emp = new MemberDAO();
        return emp.validarID_activo(id);
    }

    public boolean validarCodigoActividad(int cod){
        ActivityDAO act = new ActivityDAO();
        return act.validarCodigoActividad(cod);
    }

    public boolean validarCodigoPista(int cod){
        TrackDAO pist = new TrackDAO();
        return pist.validarCodigoPista(cod);
    }

    public int validarInicioSesion(String dni, String pass){
        if(validarDNI(dni)){
            EmployeeDAO emp = new EmployeeDAO();
            if(emp.validarInicioSesion(dni,pass)) {return 1;} else {return 0;}
            //1=inicio de sesión correcto, 0=contraseña incorrecta
        }
        return -1; //-1 = dni no existe
    }

    public int validarApuntarMiembroA(int id, int pid, String horario){
        if(validarID_activo(id)){
            ActivityDAO act = new ActivityDAO();
            int cod = act.validarHorario(pid, horario);
            if(cod!=0){
                if(act.validarMiembroActividad(cod,id)){return 100;}
                //100 = miembro ya apuntado
                if(act.apuntarMiembroActividad(cod,id)){return 2;} else {return 1;}
                //2 = apuntado correctamente, 1 = apuntar fallido
            }else{
                return 0; //0 = actividad no encontrada o no disponible
            }
        }
        return -1; //-1 = id de miembro no existe
    }

    public int validarApuntarMiembroP(int id, int pid, String horario, int horasDuracion){
        if(validarID_activo(id)){
            TrackDAO pist = new TrackDAO();
            int cod = pist.validarHorario(pid, horario);
            if(cod!=0){
                int n = pist.apuntarMiembroPista(cod,id,horasDuracion);
                if(n!=-1) {
                    MemberDAO mem = new MemberDAO();
                    if(mem.subirPrecio(id, n)){ return 2;} else {return 1;}
                }else{
                    return 1;
                    //1 = apuntar fallido
                }
            }else{
                return 0; //0 = actividad no encontrada o no disponible
            }
        }
        return -1; //-1 = id de miembro no existe
    }

    public ArrayList<String> solicitarInfoA(int CodigoActividad){
        ArrayList<String> info = new ArrayList<String>();
        if(validarCodigoActividad(CodigoActividad)){
            ActivityDAO act = new ActivityDAO();
            info = act.mostrarInfoAtributos(CodigoActividad);
        }else{
            info.add(null); // si info.get(0)==null entonces codigo de actividad inválido
        }
        return info;
    }

    public ArrayList<String> solicitarInfoP(int CodigoPista){
        ArrayList<String> info = new ArrayList<String>();
        if(validarCodigoPista(CodigoPista)){
            TrackDAO pist = new TrackDAO();
            info = pist.mostrarInfoAtributos(CodigoPista);
        }else{
            info.add(null); // si info.get(0)==null entonces codigo de pista inválido
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
                // 1 = actualizacion correcta; 0= actualizacion fallida
            }else{
                return -1; // -1 = atributos inválidos
            }
        }else{
            return -2; //-2 = codigo de actividad inválido
        }
    }

    public int validarModificarAtributosP(Track pist){
        int cod = pist.getCodigoPista();
        ArrayList<String> atributos = new ArrayList<String>();
        atributos.add(String.valueOf(cod));
        atributos.add(String.valueOf(pist.getPistaPID()));
        atributos.add(pist.getPistaHorario());
        atributos.add(String.valueOf(pist.getMiembroID()));
        atributos.add(String.valueOf(pist.getPistaDisponibilidad() ? 1 : 0));
        atributos.add(String.valueOf(pist.getPrecioPorHora()));

        if(validarCodigoPista(cod)){
            if(validarAtributos("pista", atributos)){
                TrackDAO pistD = new TrackDAO();
                if(pistD.actualizar(pist)) {return 1;} else { return 0;}
                // 1 = actualizacion correcta; 0= actualizacion fallida
            }else{
                return -1; // -1 = atributos inválidos
            }
        }else{
            return -2; //-2 = codigo de actividad inválido
        }
    }

    public boolean validarAtributos(String tipo, ArrayList<String> atributos){
        if(tipo=="actividad" || tipo=="pista"){
            if(!validarInt(atributos.get(1)) && atributos.get(1)!=null){ return false;}
            if(!validarFecha(atributos.get(2)) && atributos.get(2)!=null){ return false; }
            if(!atributos.get(4).equals("0") && !atributos.get(4).equals("1")) { return false; }
            if(tipo=="actividad"){
                if(atributos.get(3)!=null && !validarFormatoDNI(atributos.get(3))){ return false; }
                if(!validarInt(atributos.get(5)) && atributos.get(5)!=null){ return false;}
            }
            if (tipo == "pista") {
                if(!validarInt(atributos.get(3)) && atributos.get(3)!=null){ return false;}
                if(!validarDouble(atributos.get(5)) && !validarInt(atributos.get(5)) && atributos.get(5)!=null){ return false;}
            }
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
        try { int d = Integer.parseInt(num); } catch (NumberFormatException nfe) { return false; }
        return true;
    }

    private static boolean validarDouble(String num) {
        try { double d = Double.parseDouble(num); } catch (NumberFormatException nfe) { return false; }
        return true;
    }


    private static boolean validarFormatoDNI(String num) {
        if(num.length()!=9 || Character.isLetter(num.charAt(8)) == false) { return false;}
        return true;
    }
}
