package juego.cartas.clasicos.dom.impl.fr;

import java.util.Comparator;

import juego.cartas.clasicos.modelos.imp.fr.CartaFrancesaImpIS;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

/**
 * dominio para cartas de baraja francesa que se implementa con enteros y string
 * @author victor
 *
 */
public class DominioFrancesIS extends DominioValorPalo<Integer, String, CartaFrancesaImpIS>{

	public DominioFrancesIS(Dominio<Integer> domValor, Dominio<String> domPalo) {
		super(domValor, domPalo);
	
	}

	public DominioFrancesIS(Dominio<Integer> domValor, Dominio<String> domPalo,
			Comparator<CartaFrancesaImpIS> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
	}

	
	
}
