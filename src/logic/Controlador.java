package logic;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.Level;

import data.DataPersonaje;
import utils.ApplicationException;
import utils.SuperLogger;
import entities.Personaje;


public class Controlador {

	private DataPersonaje control;
	
	public Controlador(){
		control = new DataPersonaje();
	}
	
	public void add(Personaje p) throws ApplicationException
	{
		control.add(p);
	}
	
	public void update(Personaje p) throws ApplicationException
	{
		control.update(p);
	}

	public void delete(Personaje p) throws ApplicationException
	{
		control.delete(p);
	}
	
	public Personaje getPersonaje(String nombre)
	{
		return control.getByNombre(nombre);
	}
	
	public ArrayList<Personaje> getAll(){
		return control.getAll();
	}
	
	public void notifyUser(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void notifyUser(String mensaje, Exception e, Level l)
	{
		notifyUser(mensaje);
		SuperLogger.logger.log(l, mensaje, e);
	}
}
