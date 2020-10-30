package juego.cartas.clasicos.mazos.fact;

import java.util.EnumMap;

import juego.cartas.clasicos.cartas.CartaFrancesaOld;
import juego.cartas.clasicos.dom.fact.FactDominiosCartasEnumEsp;
import juego.cartas.clasicos.dom.fact.FactDominiosCartasEnumFr;
import juego.cartas.clasicos.dom.fact.FactDominiosCartasEsp;
import juego.cartas.clasicos.dom.fact.FactDominiosCartasFr;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloEspaniola;
import juego.cartas.clasicos.modelos.ICartaNumeroPaloFrancesa;
import juego.cartas.clasicos.palos.PaloEspaniol;
import juego.cartas.clasicos.palos.PaloFrances;
import juego.cartas.clasicos.suppliers.SupplierNewCartaIntegerPaloEspaniol;
import juego.cartas.clasicos.suppliers.SupplierNewCartaIntegerPaloFrances;
import juego.cartas.clasicos.suppliers.SupplierNewCartaIntegerStringEs;
import juego.cartas.clasicos.suppliers.SupplierNewCartaIntegerStringFr;
import juegos.cartas.cartas.cartas.dom.dominios.DominioValorPalo;
import juegos.cartas.cartas.cartas.dom.fact.FactDominioDobleVP;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCarta;
import juegos.cartas.cartas.cartas.supplier.SupplierNewCartaIntegerString;
import juegos.cartas.cartas.mazos.fact.BuilderMazoClasicoComp;
import juegos.cartas.cartas.mazos.fact.TipoClasico;
import juegos.cartas.cartas.mazos.fact.TipoImplementacionMazo;
import juegos.cartas.cartas.mazos.fact.TipoParametrizacion;
import juegos.cartas.cartas.mazos.impl.gen.MazoGen;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazo;
import juegos.cartas.cartas.mazos.modelos.suppliers.SupplierMazoGenMatrizLista;

/**
 * Fachada de factoria de mazos clasicos ya implementados
 * Ofrece tantos los mazos en si ya construidos
 * como las piezas con las que se contruyen
 * como suppliers de cartas y mazos, dominios, 

 * 
 * @author victor
 *
 */
public class FactFachadaMazoEspFr 
{
	
	SupplierNewCarta
	<ICartaNumeroPaloEspaniola
	<Integer, String>,
	Integer,String> supplierCartaES_IS= new SupplierNewCartaIntegerStringEs();
	
	SupplierNewCarta
	<ICartaNumeroPaloEspaniola
	<Integer, PaloEspaniol>,
	Integer,PaloEspaniol> supplierCartaES_IE= new SupplierNewCartaIntegerPaloEspaniol();
	
	SupplierNewCarta
	<ICartaNumeroPaloFrancesa
	<Integer, String>,
	Integer,String> supplierCartaFR_IS= new SupplierNewCartaIntegerStringFr();
	
	SupplierNewCarta
	<ICartaNumeroPaloFrancesa
	<Integer, PaloFrances>,
	Integer,PaloFrances> supplierCartaFR_IE= new SupplierNewCartaIntegerPaloFrances();
	
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,SupplierNewCarta>> 
	suppliersCarta= new EnumMap<>(TipoClasico.class);
	
	
	FactDominiosCartasFr fDomFr_FR_IS= new FactDominiosCartasFr();
	FactDominiosCartasEnumFr fDomFr_FR_IE= new FactDominiosCartasEnumFr();
	FactDominiosCartasEsp fDomFr_ES_IS= new FactDominiosCartasEsp();
	FactDominiosCartasEnumEsp fDomFr_ES_IE= new FactDominiosCartasEnumEsp();
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,FactDominioDobleVP>> 
	factsDom= new EnumMap<>(TipoClasico.class);
	
	EnumMap<TipoClasico,EnumMap<TipoParametrizacion,DominioValorPalo>> 
	dominiosVP= new EnumMap<>(TipoClasico.class);
	
	SupplierMazo supplierMazoML= new SupplierMazoGenMatrizLista<>();
	EnumMap<TipoImplementacionMazo,SupplierMazo> suppliersMazo= new EnumMap<>(TipoImplementacionMazo.class);
	
	BuilderMazoClasicoComp<Integer, String, ICartaNumeroPaloEspaniola<Integer,String>> bMazo;
	/*
	SupplierMazo<ICartaNumeroPalo<N,P>, N, P> supplierMazoListaMatriz=
			new SupplierMazoGenMatrizLista<>();
	
	*/
	
	protected FactFachadaMazoEspFr()
	{
		for(TipoClasico tipoClasico: TipoClasico.values())
		{
			dominiosVP.put(tipoClasico, new EnumMap<>(TipoParametrizacion.class));

		}
		
		//al no estar inicializados, se guardan como nulll, por lo que se hace despues de construir, en getInst
		inicializa();
		
		
		
		
		/*dominiosVP.put(TipoClasico.Espaniola, new EnumMap<>(TipoParametrizacion.class));
		dominiosVP.put(TipoClasico.Francesa, new EnumMap<>(TipoParametrizacion.class));*/
		
	}
	
	private void inicializa()
	{
		inicializaFactDom();
		inicializaSuppliersCarta();
		
		suppliersMazo.put(TipoImplementacionMazo.listaMatriz,supplierMazoML);
		
	}
	
	private void inicializaFactDom()
	{
		EnumMap<TipoParametrizacion,FactDominioDobleVP> mapaFr= new EnumMap<>(TipoParametrizacion.class);
		mapaFr.put(TipoParametrizacion.Int_Enum, fDomFr_FR_IE);
		mapaFr.put(TipoParametrizacion.Int_String, fDomFr_FR_IS);
		factsDom.put(TipoClasico.Francesa, mapaFr);
		
		
		EnumMap<TipoParametrizacion,FactDominioDobleVP> mapaEs= new EnumMap<>(TipoParametrizacion.class);
		mapaEs.put(TipoParametrizacion.Int_Enum, fDomFr_ES_IE);
		mapaEs.put(TipoParametrizacion.Int_String, fDomFr_ES_IS);
		factsDom.put(TipoClasico.Espaniola, mapaEs);
		
	}
	
	private void inicializaSuppliersCarta()
	{
		 
		EnumMap<TipoParametrizacion,SupplierNewCarta> mapaFr= new EnumMap<>(TipoParametrizacion.class);
		mapaFr.put(TipoParametrizacion.Int_Enum, supplierCartaFR_IE);
		mapaFr.put(TipoParametrizacion.Int_String, supplierCartaFR_IS);
		suppliersCarta.put(TipoClasico.Francesa, mapaFr);
		System.out.println("insertando supliers carta "+TipoClasico.Francesa +" "+  mapaFr);
		
		EnumMap<TipoParametrizacion,SupplierNewCarta> mapaEs= new EnumMap<>(TipoParametrizacion.class);
		mapaEs.put(TipoParametrizacion.Int_Enum, supplierCartaES_IE);
		mapaEs.put(TipoParametrizacion.Int_String, supplierCartaES_IS);
		suppliersCarta.put(TipoClasico.Espaniola, mapaEs);
		
		System.out.println("insertando supliers carta "+TipoClasico.Espaniola +" "+  mapaEs);

		
	}
	
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> crearBarajaEspaniolaIS()
	{
		return crearBaraja(TipoClasico.Espaniola, TipoParametrizacion.Int_String, TipoImplementacionMazo.listaMatriz);
		
		
	}
	public MazoGen<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>, Integer, PaloEspaniol> crearBarajaEspaniolaIE()
	{
		return crearBaraja(TipoClasico.Espaniola, TipoParametrizacion.Int_Enum, TipoImplementacionMazo.listaMatriz);
		
		
	}
	public MazoGen<ICartaNumeroPaloFrancesa<Integer, String>, Integer, String> crearBarajaFrancesaIS()
	{
		return crearBaraja(TipoClasico.Francesa, TipoParametrizacion.Int_String, TipoImplementacionMazo.listaMatriz);
		
		
	}
	
	public MazoGen<CartaFrancesaOld, Integer, PaloFrances> crearBarajaFrancesaIE()
	{
		return crearBaraja(TipoClasico.Francesa, TipoParametrizacion.Int_Enum, TipoImplementacionMazo.listaMatriz);
		
		
	}
	
	
	public MazoGen crearBaraja(TipoClasico tipoClasico,TipoParametrizacion tipoParam, TipoImplementacionMazo tipoImplMazo)
	{
		bMazo= 
				new
		BuilderMazoClasicoComp<>(
				dameDominio(tipoClasico, tipoParam),
				dameSuplierCarta(tipoClasico, tipoParam),
				dameSupplierMazo(tipoImplMazo)
				);
		
		return bMazo.crearBaraja();
	}
	 
	
	public DominioValorPalo/*<V, P, C extends ICartaNumeroPalo<V,P>>*/ dameDominio(TipoClasico tipoClasico,TipoParametrizacion tipoParam )
	{
		
		EnumMap<TipoParametrizacion, DominioValorPalo> mapaCl = dominiosVP.get(tipoClasico);//todos los tipos son insertados, no debe ser null
		if(mapaCl.containsKey(tipoParam))
		{
			return mapaCl.get(tipoParam);
		}
		else
		{
			DominioValorPalo dom = dameFactDom(tipoClasico, tipoParam).creaDominioVP();
			mapaCl.put(tipoParam,dom);
			
			return dom;
		}
	}
	
	public SupplierMazo/*<C extends ICartaNumeroPalo<N,P>, N, P>*/ dameSupplierMazo(TipoImplementacionMazo tipoImpl)
	{
		//if(TipoImplementacionMazo.lista.equals(tipoImpl))
			return new SupplierMazoGenMatrizLista();
		
		
		/*else
			return null;*/
			
	}
	
	public FactDominioDobleVP dameFactDom(TipoClasico tipoClasico,TipoParametrizacion tipoParam)
	{
		return factsDom.get(tipoClasico).get(tipoParam);
	}
	
	public SupplierNewCarta dameSuplierCarta(TipoClasico tipoClasico,TipoParametrizacion tipoParam)
	{
		SupplierNewCarta s = suppliersCarta.get(tipoClasico).get(tipoParam);
		System.out.println("supplier new carta "+tipoClasico + " "+ tipoParam + "-> "+s);
		return s;
	}
	
	

	/*
	public SupplierNewCarta<ICartaNumeroPaloEspaniola<Integer, String>, Integer, String> getSupplierCartaES_IS() {
		return supplierCartaES_IS;
	}

	public SupplierNewCarta<ICartaNumeroPaloEspaniola<Integer, PaloEspaniol>, Integer, PaloEspaniol> getSupplierCartaES_IE() {
		return supplierCartaES_IE;
	}

	public SupplierNewCarta<ICartaNumeroPaloFrancesa<Integer, String>, Integer, String> getSupplierCartaFR_IS() {
		return supplierCartaFR_IS;
	}

	public SupplierNewCarta<ICartaNumeroPaloFrancesa<Integer, PaloEspaniol>, Integer, PaloEspaniol> getSupplierCartaFR_IE() {
		return supplierCartaFR_IE;
	}

	public EnumMap<TipoClasico, EnumMap<TipoParametrizacion, SupplierNewCarta>> getSuppliersCarta() {
		return suppliersCarta;
	}

	public FactDominiosCartasFr getfDomFr_FR_IS() {
		return fDomFr_FR_IS;
	}

	public FactDominiosCartasEnumFr getfDomFr_FR_IE() {
		return fDomFr_FR_IE;
	}

	public FactDominiosCartasEsp getfDomFr_ES_IS() {
		return fDomFr_ES_IS;
	}

	public FactDominiosCartasEnumEsp getfDomFr_ES_IE() {
		return fDomFr_ES_IE;
	}

	public EnumMap<TipoClasico, EnumMap<TipoParametrizacion, FactDominioDobleVP>> getFactsDom() {
		return factsDom;
	}

	public EnumMap<TipoClasico, EnumMap<TipoParametrizacion, DominioValorPalo>> getDominiosVP() {
		return dominiosVP;
	}

	public SupplierMazo getSupplierMazoML() {
		return supplierMazoML;
	}

	public EnumMap<TipoImplementacionMazo, SupplierMazo> getSuppliersMazo() {
		return suppliersMazo;
	}
*/
	
	private static FactFachadaMazoEspFr inst;
	public static FactFachadaMazoEspFr getInst()
	{
		if(inst==null)
		{
			inst= new FactFachadaMazoEspFr();
			inst.inicializa();
		}
		return inst;
	}

	
	
	

}
