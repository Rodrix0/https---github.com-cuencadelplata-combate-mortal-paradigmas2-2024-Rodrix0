package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class GuerraTest {
	

	@Test
	void soldado_disparo() {
		Guerra soldado=new Soldado("rodri");
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
		Guerra soldado=new Soldado("rodri");
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
		Guerra soldado=new Soldado("rodri");
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
		Guerra soldado=new Soldado("rodri");
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
		Guerra soldado=new Soldado("rodri");
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
		Guerra soldado=new Soldado("rodri");
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
	@Test
	void Filtro_soldado_numeros_test() {

		var soldados = new ArrayList<Soldado>();
	
		for (int i = 0; i < 10000; i++) {
			soldados.add(new Soldado("Soldado " + i));
			
		}
		
		assertEquals(10000, soldados.size());

		Stream<Soldado> nombreSoldados = soldados.stream()
												.sorted((a, b) -> b.getNombre().compareTo(a.getNombre()))
												.limit(2);

		assertEquals("Soldado 9999", nombreSoldados.findFirst().get().getNombre());
        Stream<Soldado> nombreSoldadosMenor = soldados.stream()
												.sorted((a, b) -> a.getNombre().compareTo(b.getNombre()))
												.limit(2);

		assertEquals("Soldado 0", nombreSoldadosMenor.findFirst().get().getNombre());
	}
    @Test
	void Filtro_soldado_numeros_parcial_test() {

		var soldados = new ArrayList<Soldado>();
        Soldado soldado1=new Soldado("ChuckNorris");
	
		for (int i = 0; i < 10000; i++) {
			soldados.add(new Soldado("Soldado " + i));
			
		}
		
		assertEquals(10000, soldados.size());

        var verEsosSoldados=soldados.stream()
                                .filter(soldado->soldado.getNombre().endsWith("00")&&soldado.getNombre().contains("6"))
                                .toList();

        assertEquals(19, verEsosSoldados.size());

        for (Soldado soldado:verEsosSoldados){
            soldado1.dispararA(soldado);
        }
        for(Soldado soldado:verEsosSoldados){
            assertFalse(soldado.estaVivo());
		}
        long vivos=soldados.stream()
                            .filter(soldado->soldado.estaVivo())
                            .count();
        assertEquals(9981, vivos);
	}

    @Test
	void Filtro_soldado_numeros_parcial_or_test() {

		var soldados = new ArrayList<Soldado>();
        Soldado soldado1=new Soldado("ChuckNorris");

	
		for (int i = 0; i < 10000; i++) {
			soldados.add(new Soldado("Soldado " + i));
			
		}
		
		

        var verEsosSoldados=soldados.stream()
                                .filter(soldado->soldado.getNombre().endsWith("00")||soldado.getNombre().contains("6"))
                                .toList();

        assertEquals(3519, verEsosSoldados.size());

        for (Soldado soldado:verEsosSoldados){
			assertTrue(soldado.getNombre().endsWith("00")||soldado.getNombre().contains("6"));
            soldado1.dispararA(soldado);
			assertFalse(soldado.estaVivo());


        }
        for(Soldado soldado:verEsosSoldados){
            assertFalse(soldado.estaVivo());
        }
        long vivos=soldados.stream()
                            .filter(soldado->soldado.estaVivo())
                            .count();
        assertEquals(6481, vivos);




	}

	
	
	
	
	

}
