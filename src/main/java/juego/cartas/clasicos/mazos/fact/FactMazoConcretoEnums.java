package juego.cartas.clasicos.mazos.fact;


import juego.cartas.clasicos.cartas.CartaFrancesaOld;
import juego.cartas.clasicos.dom.fact.FactDominiosCartasEnumEsp;
import juego.cartas.clasicos.dom.fact.FactDominiosCartasEnumFr;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juego.cartas.clasicos.palos.PaloEspaniol;
import juego.cartas.clasicos.palos.PaloFrances;
import juego.cartas.clasicos.suppliers.SupplierNewCartaIntegerPaloEspaniol;
import juego.cartas.clasicos.suppliers.SupplierNewCartaIntegerPaloFrances;
import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.impl.gen.MazoGenOptMatrizLista;

/**
 * Crea mazos concretos de barajas espaniola y francesa con palos enums
 * @author victor
 *
 */
public class FactMazoConcretoEnums 
{
	FactDominiosCartasEnumFr<CartaFrancesaOld> fDomFr= new FactDominiosCartasEnumFr<>();	

	FactDominiosCartasEnumEsp fDomEs= new FactDominiosCartasEnumEsp();	

	public MazoGen<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>, Integer, PaloEspaniol> crearBarajaEspaniola()
	{
		MazoGen<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>, Integer, PaloEspaniol> mazo;
		
		Dominio<PaloEspaniol> domP = fDomEs.getDominioPalosCartasEspaniolas();
		Dominio<Integer> domV = fDomEs.getDominioNumericoCartasEspaniolas();
	
		SupplierNewCarta<ICartaNumeroPaloEspaniola<Integer,PaloEspaniol>, Integer, PaloEspaniol> supplier= new SupplierNewCartaIntegerPaloEspaniol();
		mazo= new MazoGenOptMatrizLista<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>, Integer, PaloEspaniol>(supplier, domP, domV);		
		
		return mazo;
	}
	
	public MazoGen<ICartaNumeroPaloFrancesa<Integer,PaloFrances>, Integer, PaloFrances> crearBarajaFrancesa()
	{
		MazoGen<ICartaNumeroPaloFrancesa<Integer,PaloFrances>, Integer, PaloFrances> mazo;
		
		Dominio<PaloFrances> domP = fDomFr.getDominioPalosCartasFrancesa();
		Dominio<Integer> domV = fDomFr.getDominioNumericoCartasFrancesa();
	
		SupplierNewCarta<ICartaNumeroPaloFrancesa<Integer,PaloFrances>, Integer, PaloFrances> supplier= new SupplierNewCartaIntegerPaloFrances();
		mazo= new MazoGenOptMatrizLista<ICartaNumeroPaloFrancesa<Integer,PaloFrances>, Integer, PaloFrances>(supplier, domP, domV);		
		
		return mazo;
	}

}
