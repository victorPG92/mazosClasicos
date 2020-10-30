package juego.cartas.clasicos.cartas;

import juego.cartas.clasicos.palos.PaloFrances;
import juegos.cartas.cartas.cartas.CartaNumeroPalo;
import juegos.cartas.cartas.cartas.NumeroCarta;

/**
 * Estructura carta con palo y numero usando enumerado
 * @author victor
 *
 */
public class CartaNumero 
extends CartaNumeroPalo<NumeroCarta, PaloFrances> 
implements Comparable<CartaNumero>
{
	
	public CartaNumero(NumeroCarta n , PaloFrances p)
	{
		super(n,p);
	}
		
	 
	
	public String toString()
	{
		return  numero + " of " +palo.ing();//.name();
	}

	@Override
	public int compareTo(CartaNumero o) 
	{
		//CartaNumero o= (CartaNumero) i;
		int n1=numero.getValor();
		int n2=o.numero.getValor();
		if(n1==1)n1 = 15;
		if(n2==1)n2 = 15;
		
		int r= Integer.compare(n1, n2);
		if(r==0)r=0;//tienen el mismo valor
		
		return r;
		
	}
	
	
	public String dameNombre()
	{
		return numero.toString();
	}
	
	public String dameLetras()
	{
		return numero.getLetra()+ Character.toLowerCase(palo.letr());
	}
	
	
	/**
	 * Suponiendo que juego con una unica baraja;(si no, pone un atributo idBaraja)
	 * POr lo que una carta sera igual a otra  si sus numeros y palos son coinciden
	 */
	public boolean equals(Object o)
	{
		try
		{
			CartaNumero c = (CartaNumero)o;
			return this.numero == c.numero && this.palo.equals(c.palo);
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
}
