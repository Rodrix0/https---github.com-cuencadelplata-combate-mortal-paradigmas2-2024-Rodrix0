package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GuerraTest {
	

	@Test
	void soldado_disparo() {
		Guerra soldado=new Soldado();
		assertEquals(1,soldado.getDisparo());//soldado disparo
		
	}
	@Test
	void tanque_dispara() {
		 Guerra tanque =new Tanque();
		assertEquals(1,tanque.getDisparo());//tanque disparo
		
	}
	@Test
	void buque_disparo() {
		Guerra buque=new Buque();
		assertEquals(1,buque.getDisparo());//buque disparo
		
	}
	@Test
	void muerte_soldado() {
		Guerra soldado =new Soldado(0);
		assertTrue(soldado.estaVivo());//esta vivo
		soldado.recibirDisparo();//recibe el disparo
		assertFalse(soldado.estaVivo());//muere
		
	}
	@Test
	void muerte_tanque() {
		Guerra tanque =new Tanque(0);
		assertTrue(tanque.estaVivo());//esta vivo
		tanque.recibirDisparo();//recibe el disparo
		assertTrue(tanque.estaVivo());
		tanque.recibirDisparo();
		assertFalse(tanque.estaVivo());//muere


		
	}
	@Test
	void muerte_bunque() {
		Guerra buque =new Buque(0);
		assertTrue(buque.estaVivo());//esta vivo
		buque.recibirDisparo();//recibe el disparo
		assertTrue(buque.estaVivo());
		buque.recibirDisparo();
		assertTrue(buque.estaVivo());
		buque.recibirDisparo();
		assertFalse(buque.estaVivo());//muere


		
	}
	@Test
	void escudo_soldado() {
		Guerra soldado=new Soldado();
		assertEquals(1,soldado.getEscudo());//escudo activo
		assertTrue(soldado.estaVivo());//esta vivo
		soldado.recibirDisparo();//recibe el disparo
		assertTrue(soldado.estaVivo());//vive por el escudo
		soldado.recibirDisparo();//recibe el disparo
		assertFalse(soldado.estaVivo());//muere

	}
	@Test
	void escudo_tanque() {
		Guerra tanque=new Tanque();
		assertEquals(1,tanque.getEscudo());//escudo activo
		assertTrue(tanque.estaVivo());//esta vivo
		tanque.recibirDisparo();//recibe el disparo
		assertTrue(tanque.estaVivo());//vive por el escudo
		tanque.recibirDisparo();//recibe el disparo
		assertTrue(tanque.estaVivo());//50%
		tanque.recibirDisparo();//recibe el disparo
		assertFalse(tanque.estaVivo());//muere
	}
	@Test
	void escudo_buque() {
		Guerra buque=new Buque();
		assertEquals(1,buque.getEscudo());//escudo activo
		assertTrue(buque.estaVivo());//esta vivo
		buque.recibirDisparo();//recibe el disparo
		assertTrue(buque.estaVivo());//vive por el escudo
		buque.recibirDisparo();//recibe el disparo
		assertTrue(buque.estaVivo());//50%
		buque.recibirDisparo();//recibe el disparo
		assertTrue(buque.estaVivo());
		buque.recibirDisparo();//recibe el disparo
		assertFalse(buque.estaVivo());//muere
	}
	@Test
	void tanque_dispara_soldado() {
		Guerra soldado=new Soldado();
		Guerra tanque=new Tanque();
		assertTrue(soldado.estaVivo());//soldado vivo
		((Tanque)tanque).dispararA(soldado);//tanque ataca a soldado
		assertTrue(soldado.estaVivo());//soldado vive por el escudo
		((Tanque)tanque).dispararA(soldado);//tanque ataca a soldado
		assertFalse(soldado.estaVivo());//muere
		
	}
	@Test
	void tanque_dispara_buque() {
		Guerra buque=new Buque();
		Guerra tanque=new Tanque();
		assertTrue(buque.estaVivo());//buque vivo
		((Tanque)tanque).dispararA(buque);//tanque ataca a buque
		assertTrue(buque.estaVivo());//buque vive por el escudo
		((Tanque)tanque).dispararA(buque);//tanque ataca a buque
		assertTrue(buque.estaVivo());//queda 2 vidas
		((Tanque)tanque).dispararA(buque);
		assertTrue(buque.estaVivo());//queda 1 vida
		((Tanque)tanque).dispararA(buque);
		assertFalse(buque.estaVivo());//muere

	}
	@Test
	void soldado_dispara_buque() {
		Guerra buque=new Buque();
		Guerra soldado=new Soldado();
		assertTrue(buque.estaVivo());//buque vivo
		((Soldado)soldado).dispararA(buque);//soldado ataca a buque
		assertTrue(buque.estaVivo());//buque vive por el escudo
		((Soldado)soldado).dispararA(buque);//soldado ataca a buque
		assertTrue(buque.estaVivo());//queda 3 vidas
		((Soldado)soldado).dispararA(buque);
		assertTrue(buque.estaVivo());//queda 2 vida
		((Soldado)soldado).dispararA(buque);
		assertFalse(buque.estaVivo());//muere
		



	}
	@Test
	void soldado_dispara_tanque() {
		Guerra tanque=new Tanque();
		Guerra soldado=new Soldado();
		assertTrue(tanque.estaVivo());//tanque vivo
		((Soldado)soldado).dispararA(tanque);//soldado ataca a tanque
		assertTrue(tanque.estaVivo());//tanque vive por el escudo
		((Soldado)soldado).dispararA(tanque);//soldado ataca a tanque
		assertTrue(tanque.estaVivo());//queda 1 vida
		((Soldado)soldado).dispararA(tanque);
		assertFalse(tanque.estaVivo());//muere
		

	}
	@Test
	void buque_dispara_tanque() {
		Guerra tanque=new Tanque();
		Guerra buque=new Buque();
		assertTrue(tanque.estaVivo());//tanque vivo
		((Buque)buque).dispararA(tanque);//buque ataca a tanque
		assertTrue(tanque.estaVivo());//tanque vive por el escudo
		((Buque)buque).dispararA(tanque);//buque ataca a tanque
		assertTrue(tanque.estaVivo());//queda 1 vida
		((Buque)buque).dispararA(tanque);
		assertFalse(tanque.estaVivo());//muere
		

	}
	@Test
	void buque_dispara_soldado() {
		Guerra soldado=new Soldado();
		Guerra buque=new Buque();
		assertTrue(soldado.estaVivo());//soldado vivo
		((Buque)buque).dispararA(soldado);//buque ataca a soldado
		assertTrue(soldado.estaVivo());//soldado vive por el escudo
		((Buque)buque).dispararA(soldado);//buque ataca a soldado
		assertFalse(soldado.estaVivo());//muere
		
	}
	@Test
	void tanque_dispara_ChuckNorris() {
		Guerra chuck=new ChuckNorris(0);
		Guerra tanque=new Tanque();
		assertTrue(chuck.estaVivo());//soldado vivo
		((Tanque)tanque).dispararA(chuck);//tanque ataca a soldado
		assertTrue(chuck.estaVivo());//soldado vive por el escudo
		((Tanque)tanque).dispararA(chuck);//tanque ataca a soldado
		assertTrue(chuck.estaVivo());
		((Tanque)tanque).dispararA(chuck);//tanque ataca a soldado
		((Tanque)tanque).dispararA(chuck);//tanque ataca a soldado
		((Tanque)tanque).dispararA(chuck);//tanque ataca a soldado
		((Tanque)tanque).dispararA(chuck);//tanque ataca a soldado
		assertTrue(chuck.estaVivo());




	}
	
	
	
	
	

}
