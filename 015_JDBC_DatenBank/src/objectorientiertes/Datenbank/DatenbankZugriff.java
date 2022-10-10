package objectorientiertes.Datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Ahnlich wie AmigurumiDaoImpDatenBank
 * @author Alfa
 *
 */
public class DatenbankZugriff {
	
	private String url =  "jdbc:mysql://127.0.0.1:3306/gummibärchendb" ;
	private String user ="root";
	private String password = "";
	
	
	/**
	 * Datenbakverbindung müssen geschlossen werden : close
	 * 
	 * demonstriert try-catch-resourses: wie in den ()chinter try erstellet wird, wird automatisch geschlossen
	 * @return
	 */
	public List<Gummibaerchen> lesenAllerGummibaerchen(){
		List<Gummibaerchen> dieGummibaerchen = new ArrayList<>();

		String sql = "SELECT * FROM gummibaer";
		try(Connection verbindung = DriverManager.getConnection(url, user, password);
		Statement verpackung = verbindung.createStatement();
		ResultSet antwort = verpackung.executeQuery(sql)){ 
		while(antwort.next()) {

		int primaerschluessel = antwort.getInt("gummibaerId");
		String farbe = antwort.getString("farbe");
		String frucht = antwort.getString("frucht");
		int groesse = antwort.getInt("groesse");
		LocalDate mindestensHaltbarBis = antwort.getDate("mindesHaltbarkeit").toLocalDate();

		Gummibaerchen gelesenerBaer = new Gummibaerchen(frucht, farbe, groesse, mindestensHaltbarBis);
		gelesenerBaer.setPrimaerSchlussel(primaerschluessel);

		dieGummibaerchen.add(gelesenerBaer);
		}

		}catch(SQLException ausnahme) {
		ausnahme.printStackTrace();
		}




		
//		Connection verbindung = null;
//		Statement verpackung = null;
//		ResultSet antwort = null;
//		try {
//		verbindung = DriverManager.getConnection(url, user, passwort);
//		verpackung = verbindung.createStatement();
//		antwort = verpackung.executeQuery(sql);
//
//		System.out.println(antwort);
//
//		}catch(SQLException ausnahme) {
//		ausnahme.printStackTrace();
//		} finally { //finally Block wird immer ausgeführt, egal ob eine Exception geworfen wurde oder nicht
//		if(verbindung != null) {
//		try {
//		verbindung.close();
//		}catch(SQLException nochNeAusnahme) {
//		nochNeAusnahme.printStackTrace();
//		}
//		}
//		if(verpackung != null) {
//		try {
//		verpackung.close();
//		}catch(SQLException nochNeAusnahme) {
//		nochNeAusnahme.printStackTrace();
//		}
//		}
//		if(antwort != null) {
//		try {
//		antwort.close();
//		}catch(SQLException nochNeAusnahme) {
//		nochNeAusnahme.printStackTrace();
//		}
//		}
//		}
//		
		return dieGummibaerchen;
	}
	//* Erstellen AmigurumiDB, Amigurumi-Tabelle, 2 Beispieldatensätze eingeben

	//Überarbeiten der Bewerbungsunterlagen mit: Clean Code, Design Pattern

	/*
	* Zusatzaufgabe!
	* Metropolis-Projekt:
	* Bei jedem Abflug besteht ein 25% Chance, dass Superman sein Cape vergisst:
	* Löst die CapeVergessenException (Checked Exception)aus
	* 
	* Bei jeden Abflug bestehr ein 10% Chance, dass der Spatz die Federn nicht gut genug geputzt hat
	* Löst die FederkleidNichtSauberException aus
	*
	* ...
	*/
	
}
