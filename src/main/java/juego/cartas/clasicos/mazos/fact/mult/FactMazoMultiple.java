package juego.cartas.clasicos.mazos.fact.mult;

import juego.cartas.clasicos.mazos.fact.FactFachadaMazoEspFr;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.fact.TipoClasico;
import juegos.cartas.cartas.mazos.fact.TipoParametrizacion;
import juegos.cartas.cartas.mazos.impl.gen.mult.MazoMultipleGenOptMatrizLista;
import juegos.cartas.cartas.mazos.modelos.func.MazoMultiple;

public class FactMazoMultiple<C extends ICartaNumeroPaloFrancesa<Integer, P>,P>
{
	
	FactFachadaMazoEspFr fach= FactFachadaMazoEspFr.getInst();
	/*
	SupplierNewCarta<C, N, P> supplier;
	FactD
	*/
	public MazoMultiple<C> creaMazoMult(int numMazos, TipoClasico cl,TipoParametrizacion tipoParam)
	{
		//TipoClasico fr= TipoClasico.Francesa;
		
		SupplierNewCarta<C, Integer, P> supplier = fach.dameSuplierCarta(cl, tipoParam);
		
		DominioValorPalo<Integer, P, C> dom= fach.dameDominio(cl, tipoParam);
		return 
				new MazoMultipleGenOptMatrizLista<>(supplier, dom,numMazos);
		
	}

}
