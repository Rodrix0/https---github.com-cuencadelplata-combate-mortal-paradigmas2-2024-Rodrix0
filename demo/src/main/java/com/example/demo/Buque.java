package com.example.demo;

public class Buque implements Guerra {
	private int disparosRecibidos;
	private boolean vivo;
	int escudo;
	int disparo;

	public int getDisparo() {
		return 1;
	}

	public void setDisparo(int disparo) {
		this.disparo = disparo;
	}
	public int getEscudo() {

		return escudo;
	}

	public Buque() {//buque con escudo
		this.vivo=true;//comienza vivo
		this.disparosRecibidos=0;
		this.escudo=1;
	}
	public Buque(int escudo) {//buque sin escudo
		this.vivo=true;
		this.disparosRecibidos=0;
		this.escudo=escudo;
	}
	public void recibirDisparo() {
		if(escudo>0) {
			escudo--;
		}else {
			disparosRecibidos++;
		}
		if(disparosRecibidos>=3) {
				this.vivo=false;
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
