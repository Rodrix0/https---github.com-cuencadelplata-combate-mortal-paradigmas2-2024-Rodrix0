package com.example.demo;

public class Tanque implements Guerra {
	int disparo;
	private boolean vivo;
	private int disparosRecibidos;
	int escudo;

	public int getDisparo() {
		return 1;
	}

	public void setDisparo(int disparo) {
		this.disparo = disparo;
	}
	public int getEscudo() {

		return escudo;
	}

	public Tanque() {
		this.vivo=true;//comienza vivo
		this.disparosRecibidos=0;
		this.escudo=1;
	}
	public Tanque(int escudo) {
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
		if(disparosRecibidos>=2) {
				this.vivo=false;
		}
		
	}
	public boolean estaVivo() {
		return vivo;
	}

	@Override
	public int escudo() {

		return 0;
	}
	public void dispararA(Guerra objetivo) {
		objetivo.recibirDisparo();
	}

	
}
