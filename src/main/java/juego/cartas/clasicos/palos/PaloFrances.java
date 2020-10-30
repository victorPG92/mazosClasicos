package juego.cartas.clasicos.palos;

/**
 * Los palos de la baraja francesa
 * @author victor
 *
 */
public enum PaloFrances
{
	PICAS("spades",'S'),DIAMANTES("diamonds",'D'),TREBOLES("clubs",'C'),CORAZONES("hearts",'H');
	
	private String ingles;
	private char letra;
	
	PaloFrances(String i, char c)
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
