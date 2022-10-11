package einfach.zugreifen.auf.datenbank;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * /**
 * zugriff mit URL:
 * protokol://rechnername(IP):port/Seite(die DatenBank) ?Schlüsselwert
 * zusätzlich : Username und passwort Hier:root, ""
 * @author Alfa
 *
 * No suitable driver found exeption :
 * ursachen:1. tippfehler
 * 			2. es fehlt eine bibilothek aus der eine entsprechenden object erstellt wwerden kann
 * 			
 * 			oder datenBank nicht gestartet
 *java Databaseconnectivity
 *in JDBC fängt mit dem index 1 an
 * @author Yasin
 *
 */
public class ErstesLesen {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/gummibärchendb" ;//? createDatabaseIfNotExist=true";
		String user ="root";
		String password = "";
		
		Connection verbindung = DriverManager.getConnection(url, user, password);
		Statement verpackung = verbindung.createStatement();
		
		//System.out.println(verpackung);
		
		String sql = "SELECT * FROM gummibaer";
		
		ResultSet antwort = verpackung.executeQuery(sql);
		System.out.println(antwort);
		
		antwort.next();// schiebt den datenbankzeiger auf den erten Datensatz(zeile)
		int primaerSchluessel = antwort.getInt("gummibaerId");// zugriff auf die spalte it der name gummibärId
		String frucht = antwort.getString("frucht");// Wandelt warchar zu String
		String farbe = antwort.getString("farbe");
		int groesse = antwort.getInt("groesse");
		LocalDate mindestestensHaltbarBis = antwort.getDate("mindeshaltbarkeit").toLocalDate();
		System.out.println("Das Gummibärchen ist von der fruchtsorte " + frucht +"."
				+ "Es hat die Farbe" + farbe + ". Ist " + groesse + "cm groesse"  
				+" Es hat mindes haltbar:" + mindestestensHaltbarBis + "hat die DatenbakId:"+ primaerSchluessel);
		
		antwort.next();// / schiebt den datenbankzeiger auf den zweiten Datensatz(zeile)
		primaerSchluessel = antwort.getInt(1);
		frucht = antwort.getString(2);
		farbe = antwort.getString(3);
		groesse = antwort.getInt(4);
		 mindestestensHaltbarBis = antwort.getDate(5).toLocalDate();
		 System.out.println("Das Gummibärchen ist von der fruchtsorte " + frucht +"."
				+ "Es hat die Farbe" + farbe + ". Ist " + groesse + "cm groesse"  
				+" Es hat mindes haltbar:" + mindestestensHaltbarBis + "hat die DatenbakId:"+ primaerSchluessel);
			
		if( antwort.next()){
		 primaerSchluessel = antwort.getInt(1);
			frucht = antwort.getString(2);
			farbe = antwort.getString(3);
			groesse = antwort.getInt(4);
			 mindestestensHaltbarBis = antwort.getDate(5).toLocalDate();
			 System.out.println("Das Gummibärchen ist von der fruchtsorte " + frucht +"."
					+ "Es hat die Farbe" + farbe + ". Ist " + groesse + "cm groesse"  
					+" Es hat mindes haltbar:" + mindestestensHaltbarBis + "hat die DatenbakId:"+ primaerSchluessel);
				
	}else {
		System.out.println(" kein weitere Datensatz");
		}
		System.out.println("*****************************");
		antwort.beforeFirst();// datensatz-zeiger wieder an der Ausgangposition
		while(antwort.next()) {
			 primaerSchluessel = antwort.getInt(1);
				frucht = antwort.getString(2);
				farbe = antwort.getString(3);
				groesse = antwort.getInt(4);
				 mindestestensHaltbarBis = antwort.getDate(5).toLocalDate();
				 System.out.println("Das Gummibärchen ist von der fruchtsorte " + frucht +"."
						+ "Es hat die Farbe" + farbe + ". Ist " + groesse + "cm groesse"  
						+" Es hat mindes haltbar:" + mindestestensHaltbarBis + "hat die DatenbakId:"+ primaerSchluessel);
					
		}
	}
	
}
