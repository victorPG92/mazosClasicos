package juego.cartas.clasicos.palos;

/**
 * Los palos de la baraja espaniola
 * @author victor
 *
 */
public enum PaloEspaniol
{
	OROS("golds",'O'),
	COPAS("cups",'C'),
	ESPADAS("swords",'E'),
	BASTOS("bastos",'B');
	
	private String ingles;
	private char letra;
	
	PaloEspaniol(String i, char c)
	{
		ingles=i;
		letra=c;
	}
	
	
	public String ing()
	{
		return ingles;
	}
	
	public char letr()
	{
		return letra;
	}
	
}
