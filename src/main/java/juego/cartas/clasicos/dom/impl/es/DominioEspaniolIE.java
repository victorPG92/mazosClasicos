package juego.cartas.clasicos.dom.impl.es;

import java.util.Comparator;

import juego.cartas.clasicos.modelos.imp.es.CartaEspanioIampIE;
import juego.cartas.clasicos.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;

/**
 * dominio para cartas de baraja espaniola que se implementa con enteros y enumerado paloEspaniol
 * @author victor
 *
 */
public class DominioEspaniolIE extends DominioValorPalo<Integer, PaloEspaniol, CartaEspanioIampIE>{

	public DominioEspaniolIE(Dominio<Integer> domValor, Dominio<PaloEspaniol> domPalo,
			Comparator<CartaEspanioIampIE> comparadorCartasValoracion) {
		super(domValor, domPalo, comparadorCartasValoracion);
	}

	public DominioEspaniolIE(Dominio<Integer> domValor, Dominio<PaloEspaniol> domPalo) {
		super(domValor, domPalo);
	}

	

	
	
}
