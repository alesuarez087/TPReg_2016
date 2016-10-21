package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Personaje;
import utils.ApplicationException;

public class DataPersonaje {

	public void update(Personaje p){
		PreparedStatement stmt=null;
		String sql = "UPDATE personajes SET nombre=?, vida=?, energia=?, defensa=?, evasion=?, pto_totales=? WHERE id=?";
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(sql);
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());
			stmt.setInt(7, p.getId());
			
			stmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ApplicationException e){
			e.printStackTrace();
		}finally{
			try {
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public void delete(Personaje p){
		PreparedStatement stmt=null;
		
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM personajes WHERE id=?");
			stmt.setInt(1, p.getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(ApplicationException e){
			e.printStackTrace();
		} finally{
			try {
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
	public Personaje getByNombre(String nombre){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Personaje p =new Personaje();
		String sql = "SELECT * FROM personajes WHERE nombre=?";
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(sql);
			stmt.setString(1, nombre);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Personaje();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setDefensa(rs.getInt(3));
				p.setEnergia(rs.getInt(4));
				p.setEvasion(rs.getInt(5));
				p.setVida(rs.getInt(6));
				p.setPuntosTotales(rs.getInt(7));
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ApplicationException e){ 
			e.printStackTrace();
		} finally{
			try {
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return p;
	}
		
	public void add(Personaje p){
		ResultSet rs = null;
		PreparedStatement stmt = null;
		
		String sql = "INSERT INTO personajes(nombre, vida, energia, defensa, evasion ,pto_totales) VALUES (?, ?, ?, ?, ?, ?)";
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getNombre());
			stmt.setInt(2, p.getVida());
			stmt.setInt(3, p.getEnergia());
			stmt.setInt(4, p.getDefensa());
			stmt.setInt(5, p.getEvasion());
			stmt.setInt(6, p.getPuntosTotales());
			stmt.execute();
			
			rs=stmt.getGeneratedKeys();
			if(rs!=null && rs.next()){
				p.setId(rs.getInt(1));
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ApplicationException e){
			e.printStackTrace();
		} finally{
			try {
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Personaje> getAll(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Personaje> lista = null; 
		Personaje p = null;
		String sql = "SELECT * FROM personajes";
		try{
			lista = new ArrayList<Personaje>();
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(sql);
			rs= stmt.executeQuery();
			while(rs != null && rs.next()){
				p=new Personaje();
				p.setId(rs.getInt("id"));
				p.setNombre(rs.getString("nombre"));
				p.setVida(rs.getInt("vida"));
				p.setEnergia(rs.getInt("energia"));
				p.setDefensa(rs.getInt("defensa"));
				p.setEvasion(rs.getInt("evasion"));
				p.setPuntosTotales(rs.getInt("pto_totales"));
				lista.add(p);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} catch(ApplicationException e){ 
			e.printStackTrace();
		} finally{
			try {
				if(stmt!=null) stmt.close();
				if(rs!=null) rs.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (ApplicationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		return lista;
	}

}
