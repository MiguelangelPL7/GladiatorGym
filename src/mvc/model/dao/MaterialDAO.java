package mvc.model.dao;

import conexion.ConexionBD;

import mvc.model.vo.Material;

import java.math.BigDecimal;
import java.sql.ResultSet;
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
                material.setWeightMaterial(rsc.getBigDecimal("Peso"));
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
    public void eliminateMaterial(String name)
    {
        try
        {
            String sql = "";
            String Name = name;

            sql = "DELETE FROM materiales WHERE NombreMaterial="+Name+";";
            this.ejecutarActualizacion(sql);
        }
        catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

    }

    ///AGREGAR EMPLEADO///
    public void registerMaterial(Material material)
    {
        try{

            String sql = "";

            String mid = material.getMidMaterial();
            String name = material.getNameMaterial();
            BigDecimal weight = material.getWeightMaterial();
            int units = material.getUnitsMaterial();
            String activity = material.getActivityMaterial();
            String brand = material.getBrandMaterial();
            String others = material.getOthersMaterial();


            sql = "INSERT INTO materiales (MID, NombreMaterial, Peso, Unidades,"+
                    " ActividadAsociada, Marca, OtraInfo) VALUES('"+mid+"','"+name+"','"+weight+"',"+
                    ""+units+",'"+activity+"','"+brand+"','"+others+"');";

            this.ejecutarActualizacion(sql);
        }
        catch (Exception e)
        {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }
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
}
