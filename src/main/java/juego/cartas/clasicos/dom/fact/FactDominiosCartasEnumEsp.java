package juego.cartas.clasicos.dom.fact;

import java.util.HashSet;
import java.util.Set;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juego.cartas.clasicos.palos.PaloEspaniol;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactComparator;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;

/**
* Crea dominios concretos de valores y palos de las cartas espaniola y francesa
* con palos con tipo enumerados
* @author victor
*
*/
public class FactDominiosCartasEnumEsp <C extends ICartaNumeroPaloEspaniola<Integer,PaloEspaniol >>
extends FactDominioDobleVP<Integer, PaloEspaniol, C>
{
	
	public Dominio<Integer> getDominioNumerico()
	{
		return getDominioNumericoCartasEspaniolas();
	}
	public Dominio<Integer> getDominioNumericoCartasEspaniolas()
	{
		FactComparator fComp= new FactComparator();
		Set<Integer> valores= new HashSet<>();
		for(int i=1;i<8;i++)
			valores.add(i);
		
		for(int i=10;i<13;i++)
			valores.add(i);
		
		Dominio<Integer> dom= new Dominio<>(valores, fComp.creaComparadorDeComparable());
		
		return dom;
	}
	
	public Dominio<PaloEspaniol> getDominioPalos()
	{
		return getDominioPalosCartasEspaniolas();
	}
	public Dominio<PaloEspaniol> getDominioPalosCartasEspaniolas()
	{
		return new Dominio<>(Set.of(PaloEspaniol.OROS, PaloEspaniol.COPAS, PaloEspaniol.ESPADAS, PaloEspaniol.BASTOS),
				new FactComparator().creaComparadorDeComparable());
		
	}

		
			
}
