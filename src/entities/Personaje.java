package entities;

import utils.ApplicationException;
import java.util.Random;

import javax.swing.JOptionPane;

public class Personaje {

	public final static int MAX_DEFENSA=20;
	public final static int MAX_EVASION=80;
	public final static int PUNTOS_INICIO=200;
	public final static int VICTORIA=10;
	
	
	private int id;
	private String nombre;
	private int vida;
	private int puntosTotales;
	private int evasion;
	private int defensa;
	private int energia;
	
	private int danio;
	private int desgaste;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getPuntosTotales() {
		return puntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		this.puntosTotales = puntosTotales;
	}
	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	public int getVidaRestante(){
		return vida-danio;
	}
	public int getEnergiaRestante(){
		return energia-desgaste;
	}
	
	public boolean isValid() throws ApplicationException{
		boolean valid=false;
		if(nombre.length()==0){
			throw new ApplicationException("Debe ingresar Nombre");
		} else{
			if(defensa>MAX_DEFENSA){
				throw new ApplicationException("Los puntos de defensa deben ser como máximos "+MAX_DEFENSA);
			} else{
				if(evasion > MAX_EVASION){
					throw new ApplicationException("Los puntos de evasion deben ser como máximo "+MAX_EVASION);
				} else{ 
					if(vida+energia+defensa+evasion>puntosTotales){
						throw new ApplicationException("Los puntos asignados son mayores a los disponibles");
				} else{
					valid = true;
					}
				} 
			}
		}
		return valid;
	}
	
	@Override
	public String toString(){
		return nombre;
	}
	
	@Override
	public boolean equals(Object p){
		return p instanceof Personaje && ((Personaje) p).getId() == this.getId();
	}

	public void ganador(){
		puntosTotales +=VICTORIA;
	}

	public boolean evade(){
		boolean evade = false;
		Random r = new Random();
		int nro = ((int)r.nextDouble())*100;
		if(nro<evasion) evade=true;
		return evade;
	}
	
	public void realizarAtaque(int ataque){
		desgaste+=ataque;
	}
	
	public void recibirAtaque(int ataque){
		if(evade()){
			JOptionPane.showMessageDialog(null, nombre +" ha evadido el ataque !");
		} else{
			danio+=ataque;
		}
	}
	
	public void defiende(){
		danio-=vida*defensa/250;
		desgaste-=energia*defensa/100;
		if(danio<0) danio=0;
		if(desgaste<0) desgaste=0;
	}
}
