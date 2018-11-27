import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author admin
 *
 */
public class Programa {

	public static void main(String[] args) {
		
		Connection conexion; 
		Statement sentencia;
		ResultSet resultado; 
		String sqlquery;
		Scanner entrada = new Scanner(System.in);

		try {

			/**
			 *  importamos la libraria de la bbdd y cargamos el controlador
			 */
						
			Class.forName("com.mysql.jdbc.Driver"); 

			/**
			 *  Conexion a la base de datos auctiong2
			 *  usuario: curso
			 *  password:1111
			 */
			conexion = DriverManager.getConnection("jdbc:mysql://10.90.37.27:3306/auctiong2?user=curso&password=1111");
			
			/**
			 * Guardas la conexión en una variable sentencia para ejecutar las sqlquery
			 */
			
			sentencia = conexion.createStatement();
		
			System.out.println("he creado la conexion ");
			
			System.out.println("Bienvenidad a la casa de apuestas");
			
			
			/**
			 * Creo una query que recoja las personas y los lotes
			 */
			
		
			sqlquery="select persons.name, lots.description from auctiong2.persons "
					+ "join auctiong2.bids on persons.idperson = bids.idbid "
					+ "join auctiong2.lots on bids.idbid = lots.idlot";

			sentencia.execute(sqlquery);
			if(sentencia.execute(sqlquery)){
				resultado = sentencia.executeQuery(sqlquery);

			}else{
				resultado =null;
			}

			/**
			 * Sacamos por pantalla los atributos 
			 * @return -name: usuarios
			 * 		   -description: lotes
			 */
			
			String name, description;
			boolean correcto=true;
			while(resultado.next()&& correcto==true){
				
			
				name = resultado.getString("name");
		
				description = resultado.getString("description");
				System.out.println(" nombre: "+name+" description: "+description);
				
			}
			/**
			 *  Comprobamos si el usuario introducido es correcto.
			 */
			
			System.out.println("selecciona tu usuario");
			name = entrada.nextLine();
			if(correcto=true){
				if(name!=name){
					System.out.println("el usuario es distinto");
	
				}else{
					System.out.println("tu usario es "+ name);
	
				}
			}

			/**
			 * Recoge si se produce alguna exception y finaliza la conexion
			 */
			
			
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		}
		finally {
			System.out.println("pinando desde finally");
		}
			
			//sqlquery = "update antonio.titles set title='juego' where isbn='1'";
			
		/*
		ArrayList<Auction> subastas = new ArrayList();
		Person juan = new Person("Juan");
		Person pedro = new Person("Pedro");
		Person albert = new Person("Alberto");

		Auction subasta = new Auction();
		subastas.add(subasta);
		subasta.enterLot("jarron chino");
		subasta.enterLot("palillos chinos");
		
		subasta.bidFor(2, juan, 300);
		subasta.bidFor(2, pedro, 25);
		subasta.bidFor(23, juan, 200);
		
		juan.bidFor(2,subasta,400);

		Auction subastilla = new Auction();
		subastas.add(subastilla);
		subastilla.enterLot("bugatti");
		subastilla.enterLot("Hispano Suiza");
		pedro.bidFor(2, subastilla, 3000);
		
		//System.out.println(subasta.getLot(2).getDescription() + "  " +
		//		subasta.getLot(2).getHighestBid().getBidder().getName() + "  " 
		//		+ subasta.getLot(2).getHighestBid().getValue());
		
		System.out.println("\n\n");
		//System.out.println(subasta.getLot(2).toString());
		for(Auction s:subastas)
		{
			System.out.println(s.toString());
			boolean hayLote = true;
			int index = 1;
			while(hayLote)
			{
				String pujante;
				if(s.getLot(index) != null)
				{
					if(s.getLot(index).getHighestBid() != null)
					{
						pujante = s.getLot(index).getHighestBid().getBidder().getName();
					}
					else
					{
						pujante = " No hay Pujante";
					}
					System.out.println(s.getLot(index).toString() + 
							"  bidder: " + pujante);
					index++;
				}
				else 
				{
					hayLote = false;
				}
			}
			System.out.println("");
		}
		*/
	}

}
