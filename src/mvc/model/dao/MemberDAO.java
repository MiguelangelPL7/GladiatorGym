package mvc.model.dao;

import conexion.ConexionBD;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import mvc.model.vo.Member;


public class MemberDAO extends ConexionBD {

	///LISTA MIEMBROS///
	public ArrayList<Member> listMember()
	{
		ArrayList<Member> listOfMember = new <Member>ArrayList();
		try {

			String sql = "SELECT * FROM miembros";
			ResultSet rsc = this.ejecutarSQL(sql);


			while (rsc.next()) {
				Member member = new Member();
				member.setIdMember(rsc.getInt("MiembroDNI"));
				member.setDniMember(rsc.getString("MiembroDNI"));
				member.setNameMember(rsc.getString("MiembrpNombre"));
				member.setFirstsurnameMember(rsc.getString("MiembroPrimerApellido"));
				member.setSecondsurnameMember(rsc.getString("MiembroSegundoApellido"));
				member.setDateOfBirthdayMember(rsc.getString("MiembroFechaNacimiento"));
				member.setPhoneMember(rsc.getInt("MiembroTelefono"));
				member.setStreetMember(rsc.getString("MiembroCalle"));
				member.setCityMember(rsc.getString("MiembroCiudad"));
				member.setPostalCodeMember(rsc.getInt("MiembroCodigoPostal"));
				member.setPaymentMethodMember(rsc.getString("MiembroMetodoPago"));
				member.setPaymentNumberMember(rsc.getString("MiembroNumeroPago"));
				member.setDateSubscriptionMember(rsc.getString("MiembroFechaIngreso"));
				member.setPriceSubscriptionMember(rsc.getDouble("PrecioSubscripcion"));
				member.setRateMember(rsc.getString("Tarifa"));
				member.setMailMember(rsc.getString("MiembroCorreo"));
				member.setActiveMember(rsc.getBoolean("Activo"));

				listOfMember.add(member);

			}

			rsc.close();
		} catch (Exception e) {
			System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
		}

		return(listOfMember);
	}

	///ELIMINAR MIEMBRO///
	public void eliminateMember(int id)
	{
		try
		{
			String sql ="";
			int ID = id;
			int activo = 0;

			sql = "UPDATE miembros SET Activo="+activo+" WHERE MiembroID="+ID+";";
			this.ejecutarActualizacion(sql);
		}
		catch (Exception e) {
			System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
		}

	}

	///AGREGAR MIEMBRO///
	public boolean registerMember(Member member)
	{
		try{

			String sql = "";

			int id = member.getIdMember();
			String dni = member.getDniMember();
			String name = member.getNameMember();
			String surname1 = checkNullString(member.getFirstsurnameMember());
			String surname2 = member.getSecondsurnameMember();
			String birthday = member.getDateOfBirthdayMember();
			String phone = checkNullInt(member.getPhoneMember());
			String street = checkNullString(member.getStreetMember());
			String city = checkNullString(member.getCityMember());
			String postal = checkNullInt(member.getPostalCodeMember());
			String method = member.getPaymentMethodMember();
			String number = checkNullString(member.getPaymentNumberMember());
			String admission = member.getDateSubscriptionMember();
			String price = checkNullDouble(member.getPriceSubscriptionMember());
			String rate = checkNullString(member.getRateMember());
			String mail = checkNullString(member.getMailMember());
			int active = member.getActiveMember() ? 1 : 0;
			sql = "INSERT INTO miembros (MiembroID, MiembroDNI, MiembroNombre, MiembroPrimerApellido,"+
					" MiembroSegundoApellido, MiembroFechaNacimiento, MiembroTelefono, MiembroCalle, MiembroCiudad, "+
					"MiembroCodigoPostal, MiembroMetodoPago, MiembroNumeroPago, MiembroFechaIngreso, "+
					"PrecioSubscripcion, Tarifa, EmpleadoCorreo, Activo) VALUES("+id+","+dni+","+name+""+
					","+surname1+","+surname2+","+birthday+","+phone+","+street+","+city+","+postal+""+
					","+method+","+number+","+admission+","+price+","+rate+","+mail+","+active+");";

			this.ejecutarActualizacion(sql);
		}
		catch (Exception e)
		{
			System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
		}
		return true;
	}

	public Member mostrarInfoAtributos(String ID){
		Member member = new Member();
		try{
			String sql = "Select * from miembros where MiembroID="+ID+";";
			ResultSet rsc = this.ejecutarSQL(sql);
			rsc.next();

			member.setIdMember(rsc.getInt("MiembroDNI"));
			member.setDniMember(rsc.getString("MiembroDNI"));
			member.setNameMember(rsc.getString("MiembrpNombre"));
			member.setFirstsurnameMember(rsc.getString("MiembroPrimerApellido"));
			member.setSecondsurnameMember(rsc.getString("MiembroSegundoApellido"));
			member.setDateOfBirthdayMember(rsc.getString("MiembroFechaNacimiento"));
			member.setPhoneMember(rsc.getInt("MiembroTelefono"));
			member.setStreetMember(rsc.getString("MiembroCalle"));
			member.setCityMember(rsc.getString("MiembroCiudad"));
			member.setPostalCodeMember(rsc.getInt("MiembroCodigoPostal"));
			member.setPaymentMethodMember(rsc.getString("MiembroMetodoPago"));
			member.setPaymentNumberMember(rsc.getString("MiembroNumeroPago"));
			member.setDateSubscriptionMember(rsc.getString("MiembroFechaIngreso"));
			member.setPriceSubscriptionMember(rsc.getDouble("PrecioSubscripcion"));
			member.setRateMember(rsc.getString("Tarifa"));
			member.setMailMember(rsc.getString("MiembroCorreo"));
			member.setActiveMember(rsc.getBoolean("Activo"));

			rsc.close();
		}catch (SQLException e) {
			System.out.println("Error al obtener info del empleado.\n" + e.getMessage());
		}

		return(member);
	}
	
	///MODIFICAR MIEMBRO///
	//tarifa, precio, cuenta, telefono, mail, direccion
	public boolean modifyMember(Member member)
	{
		try
		{
			String sql = "";

			int id = member.getIdMember();
			String rate = checkNullString(member.getRateMember());
			String price = checkNullDouble(member.getPriceSubscriptionMember());
			String method = member.getPaymentMethodMember();
			String number = checkNullString(member.getPaymentNumberMember());
			String phone = checkNullInt(member.getPhoneMember());
			String mail = checkNullString(member.getMailMember());
			String street = checkNullString(member.getStreetMember());
			String city = checkNullString(member.getCityMember());
			String postal = checkNullInt(member.getPostalCodeMember());

			sql = "UPDATE miembros SET Tarifa = "+rate+", PrecioSubscripcion = "+price+", MiembroMetodoPago = "+
					""+method+", MiembroNumeroPago = "+number+", MiembroTelefono = "+phone+", MiembroCorreo = "+
					""+mail+" MiembroCalle = "+street+", MiembroCiudad ="+city+", MiembroCodigoPostal = "+postal+" "+
					"WHERE MiembroID = "+id+";";
			this.ejecutarActualizacion(sql);
		}
		catch (Exception e) {
			System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
		}

		return true;
	}

	public int generarID(){
		int id = 0;

		while(id == 0 || validarID(id)){
			double n = 10000+ Math.random()*90000;
			id = (int)n;
		}

		return id;
	}

	public boolean subirPrecio(int id, double precio){
		try{
			String sql = "Select * from miembros where MiembroID="+id+";";
			ResultSet rsc = this.ejecutarSQL(sql);

			rsc.next();
			double p=rsc.getDouble("PrecioSubscripcion")+precio;
			rsc.close();

			String sql2 = "UPDATE miembros SET PrecioSubscripcion ="+p+" WHERE MiembroID = "+id+";";
			this.ejecutarActualizacion(sql2);

		}catch (SQLException e) {
			System.out.println("Error al subir precio de miembro.\n" + e.getMessage());
			return false;
		}

		return true;
	}

	public boolean validarID(int id){
		try{
			String sql = "Select MiembroID from miembros where MiembroID="+id+";";
			ResultSet rsc = this.ejecutarSQL(sql);

			if(rsc.next()){
				rsc.close();
				return true;
			}else{
				rsc.close();
				return false;
			}

		}catch (SQLException e) {
			System.out.println("Error al comprobar ID de miembro.\n" + e.getMessage());
			return false;
		}
	}

	public boolean validarID_activo(int id){
		if(!validarID(id)) return false;
		int activo;
		try{
			String sql = "Select * from miembros where MiembroID="+id+";";
			ResultSet rsc = this.ejecutarSQL(sql);

			rsc.next();
			activo=rsc.getInt("Activo");
			rsc.close();

		}catch (SQLException e) {
			System.out.println("Error al comprobar ID de miembro.\n" + e.getMessage());
			return false;
		}

		if(activo==1) return true;
		return false;
	}
	

	public boolean validarDNI(String dni){
		try{
			String sql = "Select MiembroDNI from miembros where MiembroDNI='"+dni+"';";
			ResultSet rsc = this.ejecutarSQL(sql);

			if(rsc.next()){
				rsc.close();
				return true;
			}else{
				rsc.close();
				return false;
			}

		}catch (SQLException e) {
			System.out.println("Error al comprobar DNI de miembro.\n" + e.getMessage());
			return false;
		}
	}

	private String checkNullInt(int n){
		if(n==0) return null;
		return String.valueOf(n);
	}

	private String checkNullDouble(double n){
		if(n==0) return null;
		return String.valueOf(n);
	}

	private String checkNullString(String s){
		if(s != null){ s="'"+s+"'"; }
		return s;
	}
}
