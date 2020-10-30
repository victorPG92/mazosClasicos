package juego.cartas.clasicos.dom.impl.es;

import java.util.Comparator;

import juego.cartas.clasicos.modelos.imp.es.CartaEspaniolaImpIS;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

/**
 * dominio para cartas de baraja espaniola que se implementa con enteros y string
 * @author victor
 *
 */
public class DominioEspaniolIS extends DominioValorPalo<Integer, String, CartaEspaniolaImpIS>{

	public DominioEspaniolIS(Dominio<Integer> domValor, Dominio<String> domPalo) {
		super(domValor, domPalo);
	
	}

	public DominioEspaniolIS(Dominio<Integer> domValor, Dominio<String> domPalo,
			Comparator<CartaEspaniolaImpIS> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
	}

	
	
}
