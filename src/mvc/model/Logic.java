package mvc.model;

import mvc.model.dao.ActivityDAO;
import mvc.model.dao.TrackDAO;
import mvc.model.dao.EmployeeDAO;
import mvc.model.dao.MemberDAO;
import mvc.model.dao.MaterialDAO;
import mvc.model.dao.OrderDAO;
import mvc.model.vo.Material;
import mvc.model.vo.Order;
import mvc.model.vo.Member;
import mvc.model.vo.Employee;
import mvc.model.vo.Activity;
import mvc.model.vo.Track;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Logic {
    private String dniEmpleadoEnSesion;
    private String rangoEmpleadoEnSesion;

    public int validarInicioSesion(String dni, String pass){
        if(validarDNI(dni)){
            EmployeeDAO emp = new EmployeeDAO();
            String r = emp.validarInicioSesion(dni,pass);
            if(r!="f") {
                this.dniEmpleadoEnSesion = dni;
                this.rangoEmpleadoEnSesion = r;
                return 1;
            }
            else { return 0;}
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
                double n = pist.apuntarMiembroPista(cod,id,horasDuracion);
                if(n!=-1) {
                    MemberDAO mem = new MemberDAO();
                    if(mem.subirPrecio(id, n)){ return 2;} else {return 1;} //2 = apuntar correcto
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

    public Activity solicitarInfoA(int CodigoActividad){
        Activity info = new Activity();
        if(validarCodigoActividad(CodigoActividad)){
            ActivityDAO act = new ActivityDAO();
            info = act.mostrarInfoAtributos(CodigoActividad);
        }else{
            info.setCodigoActividad(0); // si info.codigoActividad==0 entonces codigo de actividad inválido
        }
        return info;
    }

    public Track solicitarInfoP(int CodigoPista){
        Track info = new Track();
        if(validarCodigoPista(CodigoPista)){
            TrackDAO pist = new TrackDAO();
            info = pist.mostrarInfoAtributos(CodigoPista);
        }else{
            info.setCodigoPista(0); // si info.codigoPista==0 entonces codigo de pista inválido
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

    public int validarAdicionPedido(Order or, ArrayList<Material> mat){
        if(this.rangoEmpleadoEnSesion=="Recepcionista"){ return -10; } //-10 = rango inválido para realizar accion

        ArrayList<String> atributos = new ArrayList<String>();
        atributos.add(or.getNameProviderOrder());
        atributos.add(String.valueOf(or.getWeightOrder()));
        atributos.add(String.valueOf(or.getPriceOrder()));
        atributos.add(or.getDateDeliveryOrder());

        if(validarAtributos("pedido", atributos)){
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            or.setOrderDateOrder(dateFormat.format(now));
            or.setEmployeeDniOrder(this.dniEmpleadoEnSesion);
            or.setPriceOrder(0);

            OrderDAO orD = new OrderDAO();
            String nid = orD.generarNID();
            or.setNidOrder(nid);
            if(orD.registerOrder(or)) {
                for (int i=0;i<mat.size();i++) {
                    String mid = mat.get(i).getMidMaterial();
                    String u = String.valueOf(mat.get(i).getUnitsMaterial());
                    String p = String.valueOf(mat.get(i).getPriceOrderMaterial());
                    if(validarMID(mat.get(i).getMidMaterial()) && validarInt(u) && (validarDouble(p) || validarInt(p))){
                        if(!orD.addMaterial(nid,mat.get(i))) {return 0;} // 0 = adiccion fallida
                    }else{
                        return -2; // -2 = materiales inválidos
                    }
                }
                return 1;
            }else{
                return 0;
            }
            // 1 = adicion correcta; 0= adicion fallida
        }else{
            return -1; // -1 = atributos inválidos
        }
    }

    public int validarCancelacionPedido(String nid){
        if(this.rangoEmpleadoEnSesion=="Recepcionista"){ return -10; } //-10 = rango inválido para realizar accion

        if(validarNID(nid)){
            OrderDAO orD = new OrderDAO();
            if(orD.checkCancel(nid)){
                orD.cancelOrder(nid);
                return 1; // 1 = eliminacion correcta
            }else{
                return -1; // -1 = eliminacion no posible ya, fecha muy tarde para cancelar
            }

        }else{
            return -2; //-2 = nid de pedido no existente
        }
    }

    public int validarCompletarPedido(String nid){
        if(this.rangoEmpleadoEnSesion=="Recepcionista"){ return -10; } //-10 = rango inválido para realizar accion

        if(validarNID(nid)){
            OrderDAO orD = new OrderDAO();
            MaterialDAO maD = new MaterialDAO();
            ArrayList<Material> list = orD.completarPedido(nid);

            for (int i=0;i<list.size();i++) {
                String mid = list.get(i).getMidMaterial();
                int u = list.get(i).getUnitsMaterial();
                maD.verificarModificacion(mid,u,"Aumentar");
            }
            return 1; // 1 = pedido completado con exito

        }else{
            return -2; //-2 = nid de pedido no existente
        }
    }

    public int validarAdicionMaterial(Material ma){
        if(this.rangoEmpleadoEnSesion=="Recepcionista"){ return -10; } //-10 = rango inválido para realizar accion

        ArrayList<String> atributos = new ArrayList<String>();
        String nom = ma.getNameMaterial();
        atributos.add(nom);
        atributos.add(String.valueOf(ma.getWeightMaterial()));
        atributos.add(String.valueOf(ma.getUnitsMaterial()));
        atributos.add(ma.getActivityMaterial());
        atributos.add(ma.getBrandMaterial());
        atributos.add(ma.getOthersMaterial());

        if(validarAtributos("material", atributos)){
            MaterialDAO maD = new MaterialDAO();
            String mid = maD.generarMID();
            ma.setMidMaterial(mid);
            if(maD.registerMaterial(ma)) {return 1;} else { return 0;}
            // 1 = adicion correcta; 0= adicion fallida
        }else{
            return -1; // -1 = atributos inválidos
        }
    }

    public int validarEliminacionMaterial(String mid){
        if(this.rangoEmpleadoEnSesion=="Recepcionista"){ return -10; } //-10 = rango inválido para realizar accion

        if(validarMID(mid)){
            MaterialDAO maD = new MaterialDAO();
            if(!maD.validarMaterialEnPedido(mid)){
                maD.eliminateMaterial(mid);
                return 1;
                // 1 = eliminacion correcta
            }else{
                return -1; // -1 = material esta presente en un pedido
            }
        }else{
            return -2; //-2 = mid de material no existente
        }
    }

    public int validarModificacionMaterial(String mid, String tipo, int uds){ //tipo debe ser "Aumentar" o "Disminuir"
        if(this.rangoEmpleadoEnSesion=="Recepcionista"){ return -10; } //-10 = rango inválido para realizar accion

        if(validarMID(mid)){
            MaterialDAO maD = new MaterialDAO();
            if(maD.verificarModificacion(mid,uds,tipo)){
                return 1;
                // 1 = modificacion correcta
            }else{
                return -1; // -1 = atributos de modificacion incorrectos
            }
        }else{
            return -2; //-2 = mid de material no existente
        }
    }

    public ArrayList<Material> solicitarListaMateriales(){
        MaterialDAO m = new MaterialDAO();
        return m.listMaterial();
    }

    public ArrayList<Order> solicitarListaPedidos(){
        OrderDAO p = new OrderDAO();
        return p.listOrder();
    }

    private boolean validarAtributos(String tipo, ArrayList<String> atributos){
        if(tipo=="actividad" || tipo=="pista"){
            if(!validarInt(atributos.get(1))){ return false;}
            if(!validarFecha(atributos.get(2))){ return false; }
            if(!atributos.get(4).equals("0") && !atributos.get(4).equals("1")) { return false; }
            if(tipo=="actividad"){
                if(atributos.get(3)!=null && !validarFormatoDNI(atributos.get(3))){ return false; }
                if(!validarInt(atributos.get(5))){ return false; }
            }
            if (tipo == "pista") {
                if(!validarInt(atributos.get(3))){ return false; }
                if(!validarDouble(atributos.get(5)) && !validarInt(atributos.get(5))){ return false; }
            }
            return true;
        }

        if(tipo=="material"){
            if(!validarInt(atributos.get(2))){ return false; }
            if(!validarDouble(atributos.get(1)) && !validarInt(atributos.get(1))){ return false; }
            return true;
        }

        if(tipo=="pedido"){
            if(!validarDouble(atributos.get(1)) && !validarInt(atributos.get(1))){ return false; }
            if(!validarDouble(atributos.get(2)) && !validarInt(atributos.get(2))){ return false; }
            if(!validarFechaSimple(atributos.get(3))){ return false; }
            return true;
        }

        return false;
    }

    private boolean validarDNI(String dni){
        EmployeeDAO emp = new EmployeeDAO();
        return emp.validarDNI(dni);
    }

    private boolean validarID(int id){
        MemberDAO emp = new MemberDAO();
        return emp.validarID(id);
    }

    private boolean validarID_activo(int id){
        MemberDAO emp = new MemberDAO();
        return emp.validarID_activo(id);
    }

    private boolean validarCodigoActividad(int cod){
        ActivityDAO act = new ActivityDAO();
        return act.validarCodigoActividad(cod);
    }

    private boolean validarCodigoPista(int cod){
        TrackDAO pist = new TrackDAO();
        return pist.validarCodigoPista(cod);
    }

    private boolean validarMID(String mid){
        MaterialDAO ma = new MaterialDAO();
        return ma.validarMID(mid);
    }

    private boolean validarNID(String nid){
        OrderDAO or = new OrderDAO();
        return or.validarNID(nid);
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

    private static boolean validarFechaSimple(String fecha) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
