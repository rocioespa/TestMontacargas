package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMontaCarga {

	@Test
	public void queSePuedaCrearUnMontaCraga() {
		MontaCarga mc = new MontaCarga(1,800.0,0.0);
		assertNotNull(mc);
	}
	
	@Test
	public void queSePuedaCrearUnaCarga() {
		Carga c = new Carga(1,0.0);
		assertNotNull(c);
	}

	@Test
	public void queSePuedaAgregarUnaCargaAlMontaCargas() throws NoRespetaElLimiteDeCarga {
		MontaCarga mc = new MontaCarga(1,1100.0,200.0);
		Carga c = new Carga(2,150.0);
		mc.agregarCarga(c);
	    assertEquals(1,mc.getCargas().size());
	
	}
	
	
	@Test
	public void queSeObtenerElPesoDeLaCargaActual() throws NoSeEncontroLaCarga, NoRespetaElLimiteDeCarga {
		MontaCarga mc = new MontaCarga(1,1100.0,200.0);
		Carga c = new Carga(2,150.0);
		
		mc.agregarCarga(c);
		
		assertEquals(1, mc.getCargas().size());
		assertEquals((Double)350.0,mc.obtenerPesoDeLaCarga(c));
	}
	
	@Test
	public void queSePuedaDescargarElMontacargas() throws NoRespetaElLimiteDeCarga  {
		MontaCarga mc = new MontaCarga(1,1100.0,200.0);
		Carga c = new Carga(2,150.0);
		Carga c1 = new Carga(1,250.0);
		Carga c2 = new Carga(3,150.0);
		mc.agregarCarga(c);
		mc.agregarCarga(c1);
		mc.agregarCarga(c2);
		assertEquals(3, mc.getCargas().size());
		
		mc.descargarCarga();
		assertEquals(0, mc.getCargas().size());
		assertEquals((Double)200.0, mc.getPesoActual());
		
		
	}
	
	@Test
	public void queSePuedaHacerUnPromedioDelPesoDelMontacargas() throws NoRespetaElLimiteDeCarga  {
		MontaCarga mc = new MontaCarga(1,1100.0,200.0);
		Carga c = new Carga(2,150.0);
		Carga c1 = new Carga(1,250.0);
		Carga c2 = new Carga(3,150.0);
		mc.agregarCarga(c);
		mc.agregarCarga(c1);
		mc.agregarCarga(c2);
		assertEquals(3, mc.getCargas().size());
	
		assertEquals((Double)183.3, mc.promedioDeCargas(),0.1);
		
	}
}
