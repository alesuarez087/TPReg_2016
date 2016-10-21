package logic;

import javax.swing.JOptionPane;
import org.apache.logging.log4j.Level;
import entities.Personaje;
import utils.ApplicationException;

public class ControladorEditor extends Controlador{

	public ControladorEditor(){
		super();
	}
	
	public boolean eliminar(Personaje p){
		boolean valida = false; 
		try {
			super.delete(p);
			super.notifyUser("Eliminado Correctamente");
			valida = true;
		} catch (ApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valida;
	}
	
	public boolean modificar(Personaje p)
	{	boolean valida=false;
		try {
			if(p.isValid())
			{
				try
				{
					super.update(p);
					JOptionPane.showMessageDialog(null, "Personaje modificado Correctamente");
				} catch (ApplicationException e){
					super.notifyUser(e.getMessage(), e, Level.DEBUG);
				} catch(ArithmeticException e){
					super.notifyUser("Ha ocurido un error inesperado. Dirigirse a administrador", e, Level.ERROR);
				} catch(Exception e) {
					super.notifyUser("Ha ocurrido algo totalmente inesperado. Dirigirse al administrador", e, Level.FATAL);
				}
				valida = true;
			}
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return valida;
	}
	
	public boolean agregar(Personaje p)
	{
		boolean valida = false;
		try {
			if(p.isValid())
			{
				try
				{
					this.add(p);;
					JOptionPane.showMessageDialog(null, "Personaje agregador Correctamente");
					valida = true;
				}
				catch (ApplicationException e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}
		} catch (ApplicationException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return valida;
	}

	public Personaje buscar(String nombre){
		Personaje p = super.getPersonaje(nombre);
		return p;
	}
}
