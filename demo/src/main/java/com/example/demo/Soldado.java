package com.example.demo;

public class Soldado implements Guerra {
	int disparo;
	private boolean vivo;
	int escudo;
	private int disparosRecibidos;
	private String nombre;

	public int getDisparo() {
		return 1;
	}

	public void setDisparo(int disparo) {
		this.disparo = disparo;
	}
	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}
	public int getEscudo() {
		return escudo;
	}
	public Soldado(String nombre) {//soldado con escudo
		this.vivo=true;//comienza vivo
		this.disparosRecibidos=0;
		this.escudo=0;
		this.setNombre(nombre);
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String valor){
		this.nombre=valor;
	}
	public Soldado(int escudo) {//Soldado sin escudo
		this.vivo=true;
		this.disparosRecibidos=0;
		this.escudo=escudo;
	}
	public void recibirDisparo() {
		if(escudo>0) {
			escudo--;
		}else {
			disparosRecibidos++;
			if(disparosRecibidos>=1) {
				this.vivo=false;//

		}
		}
	}
	public boolean estaVivo() {
		return vivo;
	}
	
	public int escudo() {
	
		return 0;
	}
	public void dispararA(Guerra objetivo) {
		objetivo.recibirDisparo();
	}

}
