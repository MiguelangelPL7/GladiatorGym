package mvc.model.dao;

import conexion.ConexionBD;

import mvc.model.vo.Material;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialDAO extends ConexionBD {

    ///LISTA DE MATERIAL///
    public ArrayList<Material> listMaterial()
    {
        ArrayList<Material> listOfMaterial = new <Material>ArrayList();
        try {

            String sql = "SELECT * FROM materiales";
            ResultSet rsc = this.ejecutarSQL(sql);


            while (rsc.next()) {
                Material material = new Material();
                material.setMidMaterial(rsc.getString("MID"));
                material.setNameMaterial(rsc.getString("NombreMaterial"));
                material.setWeightMaterial(rsc.getDouble("Peso"));
                material.setUnitsMaterial(rsc.getInt("Unidades"));
                material.setActivityMaterial(rsc.getString("ActividadAsociada"));
                material.setBrandMaterial(rsc.getString("Marca"));
                material.setOthersMaterial(rsc.getString("OtraInfo"));

                listOfMaterial.add(material);

            }

            rsc.close();
        } catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

        return(listOfMaterial);
    }

    ///ELIMINAR MATERIAL///
    public void eliminateMaterial(String mid)
    {
        try
        {
            String sql = "";

            sql = "DELETE FROM materiales WHERE MID='"+mid+"';";
            this.ejecutarActualizacion(sql);
        }
        catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

    }

    ///AGREGAR EMPLEADO///
    public boolean registerMaterial(Material material)
    {
        try{

            String sql = "";

            String mid = material.getMidMaterial();
            String name = material.getNameMaterial();
            double weight = material.getWeightMaterial();
            int units = material.getUnitsMaterial();
            String activity = checkNullString(material.getActivityMaterial());
            String brand = checkNullString(material.getBrandMaterial());
            String others = checkNullString(material.getOthersMaterial());


            sql = "INSERT INTO materiales (MID, NombreMaterial, Peso, Unidades,"+
                    " ActividadAsociada, Marca, OtraInfo) VALUES('"+mid+"','"+name+"',"+weight+","+
                    ""+units+","+activity+","+brand+","+others+");";

            this.ejecutarActualizacion(sql);
        }
        catch (Exception e)
        {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    ///MODIFICAR MATERIAL///
    public void modifyMaterial(Material material)
    {
        try
        {
            String sql = "";

            String name = material.getNameMaterial();
            int units = material.getUnitsMaterial();

            sql = "UPDATE materiales SET Unidades = "+units+" WHERE NombreMaterial = '"+name+"';";
            this.ejecutarActualizacion(sql);
        }
        catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

    }

    private boolean cambiarUnidades(String mid, int ud, String mod){
        try{
            String sql = "UPDATE materiales SET Unidades ="+ud+" WHERE MID = '"+mid+"';";
            this.ejecutarActualizacion(sql);

        }catch (Exception e) {
            System.out.println("Error al actualizar unidades de material.\n" + e.getMessage());
            return false;
        }

        return true;
    }

    public boolean verificarModificacion(String mid, int ud, String mod){
        if(!mod.equals("Disminuir") && !mod.equals("Aumentar")) {return false;}
        int uds;

        try{
            String sql = "Select * from materiales where MID='"+mid+"';";

            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.next();
            uds=rsc.getInt("Unidades");
            rsc.close();

            if(mod.equals("Disminuir")){
                if(uds<=ud){
                    return false;
                }else{
                    uds= uds-ud;
                }
            }else{
                uds = uds+ud;
            }

        }catch (SQLException e) {
            System.out.println("Error con atributos de modificacion de material.\n" + e.getMessage());
            return false;
        }

        return cambiarUnidades(mid,uds,mod);
    }

    public String generarMID(){
        String mid=null;

        while(mid==null || validarMID(mid)){
            int num = (int)(Math.random()*9000+1000);
            char c1 = (char)(Math.random()*26+65);
            char c2 = (char)(Math.random()*26+65);
            mid=String.valueOf(num)+c1+c2;
        }

        return mid;
    }

    public boolean validarMID(String mid){
        try{
            String sql = "Select * from materiales where MID='"+mid+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar MID de material.\n" + e.getMessage());
            return false;
        }
    }

    public boolean validarMaterialEnPedido(String mid){
        try{
            String sql = "Select * from materialespedido where MID='"+mid+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar MID de materialespedio.\n" + e.getMessage());
            return false;
        }
    }

    private String checkNullString(String s){
        if(s != null){ s="'"+s+"'"; }
        return s;
    }
}
