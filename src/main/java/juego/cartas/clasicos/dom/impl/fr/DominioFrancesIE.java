package juego.cartas.clasicos.dom.impl.fr;

import java.util.Comparator;

import juego.cartas.clasicos.modelos.imp.fr.CartaFrancesaImpIE;
import juego.cartas.clasicos.palos.PaloFrances;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

/**
 * dominio para cartas de baraja francesa que se implementa con enteros y enumerado paloFrances
 * @author victor
 *
 */
public class DominioFrancesIE extends DominioValorPalo<Integer, PaloFrances, CartaFrancesaImpIE>{

	public DominioFrancesIE(Dominio<Integer> domValor, Dominio<PaloFrances> domPalo,
			Comparator<CartaFrancesaImpIE> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
		// TODO Auto-generated constructor stub
	}

	public DominioFrancesIE(Dominio<Integer> domValor, Dominio<PaloFrances> domPalo) {
		super(domValor, domPalo);
		// TODO Auto-generated constructor stub
	}

	

	
	
}
