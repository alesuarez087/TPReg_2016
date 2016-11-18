package logic;

import javax.swing.JOptionPane;

import entities.Personaje;
import utils.ApplicationException;

public class ControladorPartida extends Controlador{

	private Personaje jugador_1;
	private Personaje jugador_2;
	private Personaje ataca;
	private Personaje recibe;
	
	private boolean fin;

	public Personaje getJugador_1() {
		return jugador_1;
	}
	public Personaje getJugador_2() {
		return jugador_2;
	}
	public boolean getFin() {
		return fin;
	}
	
	public void inicioPartida(Personaje p1, Personaje p2){
		this.jugador_1 = p1;
		this.jugador_2 = p2;
		ataca = p1;
		recibe = p2;
		fin = false;
	}
	
	public void cambiarTurno()
	{
		Personaje aux = ataca;
		ataca = recibe;
		recibe = aux;
	}
	
	public Personaje getTurno(){
		return ataca;
	}
	
	public boolean atacar(int ataque) throws ApplicationException{
		if(ataque>ataca.getEnergiaRestante()){
			JOptionPane.showMessageDialog(null, "Los puntos de Ataque ingresado son superiores a la Energía Restante !\nReintente");
			return false;
		} else{
			ataca.realizarAtaque(ataque);
			recibe.recibirAtaque(ataque);
			if(recibe.getVidaRestante()<1){
				fin = true;
				ataca.ganador();
				super.update(ataca);
			} else{
				this.cambiarTurno();
			}
			return true;
		}
	}
	
	public void defender() throws ApplicationException{
		ataca.defiende();
		this.cambiarTurno();
	}


}
