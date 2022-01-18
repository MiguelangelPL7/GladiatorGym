package mvc.model.dao;

import conexion.ConexionBD;

import mvc.model.vo.Employee;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO extends ConexionBD{

    ///LISTA DE EMPLEADOS///
    public ArrayList<Employee> listEmployee()
    {
        ArrayList<Employee> listOfEmployee = new <Employee>ArrayList();
        try {

            String sql = "SELECT * FROM empleados";
            ResultSet rsc = this.ejecutarSQL(sql);


            while (rsc.next()) {
                Employee employee = new Employee();
                employee.setDniEmployee(rsc.getString("EmpleadoDNI"));
                employee.setNameEmployee(rsc.getString("EmpleadoNombre"));
                employee.setFirstSurnameEmployee(rsc.getString("EmpleadoPrimerApellido"));
                employee.setSecondSurnameEmployee(rsc.getString("EmpleadoSegundoApellido"));
                employee.setDateOfBirthdayEmployee(rsc.getString("EmpleadoFechaNacimiento"));
                employee.setMailEmployee(rsc.getString("EmpleadoCorreo"));
                employee.setPhoneEmployee(rsc.getInt("EmpleadoTelefono"));
                employee.setStreetEmployee(rsc.getString("EmpleadoCalle"));
                employee.setCityEmployee(rsc.getString("EmpleadoCiudad"));
                employee.setPostalCodeEmployee(rsc.getInt("EmpleadoCodigoPostal"));
                employee.setPaymentMethodEmployee(rsc.getString("EmpleadoMetodoPago"));
                employee.setPaymentNumberEmployee(rsc.getString("EmpleadoNumeroPago"));
                employee.setDateAdmissionEmployee(rsc.getString("EmpleadoFechaIngreso"));
                employee.setSalaryEmployee(rsc.getBigDecimal("SalarioMensual"));
                employee.setUserEmployee(rsc.getString("Usuario"));
                employee.setPasswordEmployee(rsc.getString("Contraseña"));
                employee.setGradeEmployee(rsc.getString("Rango"));

                listOfEmployee.add(employee);

            }

            rsc.close();
        } catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

        return(listOfEmployee);
    }

    ///ELIMINAR EMPLEADO///
    public void eliminateEmployee(String dni)
    {
        try
        {
            String sql = "";
            String DNI = dni;

            sql = "DELETE FROM empleados WHERE EmpleadoDNI="+DNI+";";
            this.ejecutarActualizacion(sql);
        }
        catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

    }

    ///AGREGAR EMPLEADO///
    public boolean registerEmployee(Employee employee)
    {
        try{

            String sql = "";

            String dni = employee.getDniEmployee();
            String name = employee.getNameEmployee();
            String surname1 = employee.getFirstSurnameEmployee();
            String surname2 = employee.getSecondSurnameEmployee();
            String birthday = employee.getDateOfBirthdayEmployee();
            String mail = employee.getMailEmployee();
            int phone = employee.getPhoneEmployee();
            String street = employee.getStreetEmployee();
            String city = employee.getCityEmployee();
            int postal = employee.getPostalCodeEmployee();
            String method = employee.getPaymentMethodEmployee();
            String number = employee.getPaymentNumberEmployee();
            String admission = employee.getDateAdmissionEmployee();
            BigDecimal salary = employee.getSalaryEmployee();
            String user = employee.getUserEmployee();
            String password = employee.getPasswordEmployee();
            String grade = employee.getGradeEmployee();

            sql = "INSERT INTO empleados (EmpleadoDNI, EmpleadoNombre, EmpleadoPrimerApellido, EmpleadoSegundoApellido,"+
                    " EmpleadoFechaNacimiento, EmpleadoCorreo, EmpleadoTelefono, EmpleadoCalle, EmpleadoCiudad, "+
                    "EmpleadoCodigoPostal, EmpleadoMetodoPago, EmpleadoNumeroPago, EmpleadoFechaIngreso, "+
                    "SalarioMensual, Usuario, Cotraseña, Rango) VALUES('"+dni+"','"+name+"','"+surname1+"',"+
                    "'"+ surname2+"','"+birthday+"','"+mail+"',"+phone+",'"+street+"','"+city+"',"+postal+","+
                    "'"+method+ "','"+number+"','"+admission+"',"+salary+",'"+user+"','"+password+"','"+grade+"');";

            this.ejecutarActualizacion(sql);
        }
        catch (Exception e)
        {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }
        
        return true;
    }

    public Employee mostrarInfoAtributos(String DNI){
        Employee employee = new Employee();
        try{
            String sql = "Select * from empleados where EmpleadoDNI="+DNI+";";
            ResultSet rsc = this.ejecutarSQL(sql);
            rsc.next();

            employee.setDniEmployee(rsc.getString("EmpleadoDNI"));
            employee.setNameEmployee(rsc.getString("EmpleadoNombre"));
            employee.setFirstSurnameEmployee(rsc.getString("EmpleadoPrimerApellido"));
            employee.setSecondSurnameEmployee(rsc.getString("EmpleadoSegundoApellido"));
            employee.setDateOfBirthdayEmployee(rsc.getString("EmpleadoFechaNacimiento"));
            employee.setMailEmployee(rsc.getString("EmpleadoCorreo"));
            employee.setPhoneEmployee(rsc.getInt("EmpleadoTelefono"));
            employee.setStreetEmployee(rsc.getString("EmpleadoCalle"));
            employee.setCityEmployee(rsc.getString("EmpleadoCiudad"));
            employee.setPostalCodeEmployee(rsc.getInt("EmpleadoCodigoPostal"));
            employee.setPaymentMethodEmployee(rsc.getString("EmpleadoMetodoPago"));
            employee.setPaymentNumberEmployee(rsc.getString("EmpleadoNumeroPago"));
            employee.setDateAdmissionEmployee(rsc.getString("EmpleadoFechaIngreso"));
            employee.setSalaryEmployee(rsc.getBigDecimal("SalarioMensual"));
            employee.setUserEmployee(rsc.getString("Usuario"));
            employee.setPasswordEmployee(rsc.getString("Contraseña"));
            employee.setGradeEmployee(rsc.getString("Rango"));

            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al obtener info del empleado.\n" + e.getMessage());
        }

        return(employee);
    }

    
    ///MODIFICAR EMPLEADO///
    public void modifyEmployee(Employee employee)
    {
        try
        {
            String sql = "";

            String dni = employee.getDniEmployee();
            String grade = employee.getGradeEmployee();
            BigDecimal salary = employee.getSalaryEmployee();
            String method = employee.getPaymentMethodEmployee();
            String number = employee.getPaymentNumberEmployee();
            String phone = checkNullInt(employee.getPhoneEmployee());
            String mail = employee.getMailEmployee();
            String street = employee.getStreetEmployee();
            String city = employee.getCityEmployee();
            String postal = checkNullInt(employee.getPostalCodeEmployee());

            sql = "UPDATE empleados SET Rango = '"+grade+"', SalarioMensual = '"+salary+"', EmpleadoMetodoPago = "+
                    "'"+method+"', EmpleadoNumeroPago = '"+number+"', EmpleadoTelefono = "+phone+", EmpleadoCorreo = "+
                    "'"+mail+"', EmpleadoCalle = '"+street+"', EmpleadoCiudad ='"+city+"', EmpleadoCodigoPostal = "+
                    ""+postal+" WHERE EmpleadoDNI = '"+dni+"';";
            this.ejecutarActualizacion(sql);
        }
        catch (Exception e) {
            System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
        }

    }

    public String validarInicioSesion(String dni, String pass){
        String realPass;
        String range;
        try{
            String sql = "Select * from empleados where EmpleadoDNI='"+dni+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            rsc.next();
            realPass=rsc.getString("Contraseña");
            range=rsc.getString("Rango");
            rsc.close();
        }catch (SQLException e) {
            System.out.println("Error al comprobar DNI de empleado.\n" + e.getMessage());
            return "f";
        }

        if(pass.equals(realPass)){
            return range;
        }
        return "f";
    }

    public boolean validarDNI(String dni){
        try{
            String sql = "Select EmpleadoDNI from empleados where EmpleadoDNI='"+dni+"';";
            ResultSet rsc = this.ejecutarSQL(sql);

            if(rsc.next()){
                rsc.close();
                return true;
            }else{
                rsc.close();
                return false;
            }

        }catch (SQLException e) {
            System.out.println("Error al comprobar DNI de empleado.\n" + e.getMessage());
            return false;
        }
    }

    private String checkNullInt(int n){
        if(n==0) return null;
        return String.valueOf(n);
    }
}
