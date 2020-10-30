package juego.cartas.clasicos.dom.fact;

import java.util.HashSet;
import java.util.Set;

import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.dom.fact.FactComparator;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;

/**
 * Crea dominios concretos de valores y palos de las cartas espaniola y francesa
 * con palos tipo string
 * @author victor
 *
 */
public class FactDominiosCartasEsp<C extends ICartaNumeroPaloEspaniola<Integer,String>> 
extends FactDominioDobleVP<Integer, String, C>
//implements FactDominioDoble<Integer, String, ICartaNumeroPaloEspaniola<Integer,String>>
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
	
	public Dominio<String> getDominioPalos()
	{
		return getDominioPalosCartasEspaniolas();
	}
	public Dominio<String> getDominioPalosCartasEspaniolas()
	{
		return new Dominio<>(Set.of("oros","copas","espadas","bastos"),
				new FactComparator().creaComparadorDeComparable());
		
	}



	
}
