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
				member.setPriceSubscriptionMember(rsc.getBigDecimal("PrecioSubscripcion"));
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
	public void eliminateMember(Member id)
	{
		try
		{
			String sql ="";
			int ID = id.getIdMember();
			int activo = 0;

			sql = "UPDATE miembros SET Activo="+activo+" WHERE MiembroID="+ID+";";
			this.ejecutarActualizacion(sql);
		}
		catch (Exception e) {
			System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
		}

	}

	///AGREGAR MIEMBRO///
	public void registerMember(Member member)
	{
		try{

			String sql = "";

			int id = member.getIdMember();
			String dni = member.getDniMember();
			String name = member.getNameMember();
			String surname1 = member.getFirstsurnameMember();
			String surname2 = member.getSecondsurnameMember();
			String birthday = member.getDateOfBirthdayMember();
			int phone = member.getPhoneMember();
			String street = member.getStreetMember();
			String city = member.getCityMember();
			int postal = member.getPostalCodeMember();
			String method = member.getPaymentMethodMember();
			String number = member.getPaymentNumberMember();
			String admission = member.getDateSubscriptionMember();
			BigDecimal price = member.getPriceSubscriptionMember();
			String rate = member.getRateMember();
			String mail = member.getMailMember();
			boolean active = member.getActiveMember();
			sql = "INSERT INTO miembros (MiembroID, MiembroDNI, MiembroNombre, MiembroPrimerApellido,"+
					" MiembroSegundoApellido, MiembroFechaNacimiento, MiembroTelefono, MiembroCalle, MiembroCiudad, "+
					"MiembroCodigoPostal, MiembroMetodoPago, MiembroNumeroPago, MiembroFechaIngreso, "+
					"PrecioSubscripcion, Tarifa, EmpleadoCorreo, Activo) VALUES('"+id+"','"+dni+"','"+name+"'"+
					",'"+surname1+"','"+surname2+"','"+birthday+"',"+phone+",'"+street+"','"+city+"',"+postal+""+
					",'"+method+"','"+number+"','"+admission+"',"+price+",'"+rate+"','"+mail+"',"+active+");";

			this.ejecutarActualizacion(sql);
		}
		catch (Exception e)
		{
			System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
		}
	}

	///MODIFICAR MIEMBRO///
	//tarifa, precio, cuenta, telefono, mail, direccion
	public void modifyMember(Member member)
	{
		try
		{
			String sql = "";

			int id = member.getIdMember();
			String rate = member.getRateMember();
			BigDecimal price = member.getPriceSubscriptionMember();
			String method = member.getPaymentMethodMember();
			String number = member.getPaymentNumberMember();
			int phone = member.getPhoneMember();
			String mail = member.getMailMember();
			String street = member.getStreetMember();
			String city = member.getCityMember();
			int postal = member.getPostalCodeMember();

			sql = "UPDATE miembros SET Tarifa = '"+rate+"', PrecioSubscripcion = '"+price+"', MiembroMetodoPago = "+
					"'"+method+"', MiembroNumeroPago = '"+number+"', MiembroTelefono = "+phone+", MiembroCorreo = "+
					"'"+mail+" MiembroCalle = '"+street+"', MiembroCiudad ='"+city+"', MiembroCodigoPostal = "+postal+" "+
					"WHERE MiembroID = '"+id+"';";
			this.ejecutarActualizacion(sql);
		}
		catch (Exception e) {
			System.out.println("Error conexión con el Servidor MySQL.\n" + e.getMessage());
		}

	}

	public boolean subirPrecio(int id, double precio){
		try{
			String sql = "Select * from miembros where MiembroID="+id+";";
			ResultSet rsc = this.ejecutarSQL(sql);

			rsc.next();
			double p=rsc.getDouble("PrecioSubscripcion")+precio;
			rsc.close();

			String sql2 = "UPDATE miembros SET PrecioSubscripcion ="+p+" WHERE MiembroID = '"+id+"';";
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
}
