package juego.cartas.clasicos;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import juego.cartas.clasicos.mazos.fact.FactMazoConcretoEnums;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juego.cartas.clasicos.palos.PaloFrances;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;

public class BarajaFrancesaFactTest
{
	
	@Test
	void testCrearBaraja() throws Exception {
		
		MazoGen<ICartaNumeroPaloFrancesa<Integer,PaloFrances>, Integer, PaloFrances> mazo = new FactMazoConcretoEnums().crearBarajaFrancesa();
		
		Assert.assertNotNull(mazo);
	}

}
