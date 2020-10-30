package juego.cartas.clasicos;

import java.util.List;

import org.junit.Assert;

import juego.cartas.clasicos.mazos.fact.FactMazoConcreto;
import juegos.cartas.cartas.cartas.ICartaNumeroPalo;
import juegos.cartas.cartas.cartas.dom.dominios.Dominio;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.func.MazoConsulta;

public class CrearMazosEspanioles 
{
	
	public static List<MazoGen<ICartaNumeroPalo<Integer, String>,Integer,String>> creaListaMazosPruebas()
	{
		FactMazoConcreto fm= new FactMazoConcreto(); 

		return List.of
		(
				fm.crearBarajaEspaniola()
				
				
		);
	}
	
	public static void main(String[] args) 
	{
		
		
		
		for(MazoGen<ICartaNumeroPalo<Integer, String>,Integer,String> mazo: creaListaMazosPruebas())
		{
			MazoConsulta<ICartaNumeroPalo<Integer, String>> mazoSimple=(MazoConsulta<ICartaNumeroPalo<Integer, String>>) mazo;
			
			Dominio<String> domP = mazo.getDominioPalos();
			Dominio<Integer> domV = mazo.getDominioValores();
			SupplierNewCarta<ICartaNumeroPalo<Integer, String>, Integer, String> supplier = mazo.getSupplierNewCarta();
			for(String palo:domP.getValues())
			{
				for(Integer num: domV.getValues())
				{
					
					ICartaNumeroPalo<Integer, String> carta=supplier.creaNuevaCarta(num, palo);
					boolean pertenece=mazoSimple.perteneceCartaAMazo(carta);
	
					System.out.println(carta + " " +pertenece  );
					Assert.assertTrue(pertenece);
				}
			}
		}
		
	}

}
