package objectorientiertes.Datenbank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;






/**
 * Ahnlich wie AmigurumiDaoImpDatenBank
 * try withn Resources
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


		return dieGummibaerchen;
	}
	
	public void schreibenEinesGummibaer(Gummibaerchen zuSpeinern) {
		String sqlEingabe = "INSERT INTO gummibaer VALUE("
				+ "NULL, "
				+ "'" + zuSpeinern.getFrucht()+"','"
				+ zuSpeinern.getFarbe()+"',"
				+ zuSpeinern.getGroesse()+",'"
				+ zuSpeinern.getMindesthaltbarkeit().getYear()+"-"
				+ zuSpeinern.getMindesthaltbarkeit().getMonthValue()+"-"
				+ zuSpeinern.getMindesthaltbarkeit().getDayOfMonth()+"'"
				+ ")";
		try(Connection verbindung = DriverManager.getConnection(url, user, password);
				Statement verpackung = verbindung.createStatement()){
			verpackung.execute(sqlEingabe);
		}catch(SQLException ausnahme) {
			ausnahme.printStackTrace();
		}
	}
		public void besserSchreibenEinsGummibaer(Gummibaerchen zuSpeichern) {
			if(zuSpeichern.getPrimaerSchlussel() != 0) {
				System.out.println("Datensatz schon geschrieben");
				return;
			} 
			
			String sqlEingabe = "INSERT INTO gummibaer VALUE(NULL, ?,?,?,?)";
			
			try(Connection verbindung = DriverManager.getConnection(url, user, password);
					PreparedStatement verpackung = verbindung.prepareStatement(sqlEingabe, Statement.RETURN_GENERATED_KEYS)){
//					PreparedStatement verpackung = verbindung.prepareStatement(sqlEingabe)){
				verpackung.setString(1, zuSpeichern.getFrucht());
				verpackung.setString(2, zuSpeichern.getFarbe());
				verpackung.setInt(3, zuSpeichern.getGroesse());
				verpackung.setDate(4, Date.valueOf(zuSpeichern.getMindesthaltbarkeit()));
				
				verpackung.execute();
				
				//setPrimaerSchluessel(int i)
//				ResultSet antwort = verbindung.createStatement().executeQuery("SELECT * FROM gummibaer");
//				int id = 0;
//				while(antwort.next()) {
//					id = antwort.getInt(1);
//				}
//				zuSpeichern.setPrimaerSchlussel(id);
				
				ResultSet antwort = verpackung.getGeneratedKeys();
				antwort.next();
				int id = antwort.getInt(1);
				zuSpeichern.setPrimaerSchlussel(id);
				
			}catch(SQLException ausnahme) {
				ausnahme.printStackTrace();
			}
		}
		
		
		
		public void loeschen(String frucht) {
			String sqlEntfernen = "DELETE FROM gummibaer WHERE frucht = '" + frucht+ "'";
			try(Connection verbindung = DriverManager.getConnection(url, user, password);
					Statement verpackung = verbindung.createStatement()){
				verpackung.execute(sqlEntfernen);
			}catch(SQLException ausnahme) {
				ausnahme.printStackTrace();
			}
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
	* /* 
* Übung : 
* DAO-Projekt: AmigurumiDAOImplMitDB: SELECT/INSERT Optional: UPDATE und DELETE
* Amigurumi Klasse verbessern: setPK-Methode mit Kontrollen (optional:eigene Exception auslösen)
* Maker: Beispieldaten in Tabelle, Maker nicht ändern! 
* Erstellen einer Datenbank-Füller-Klasse mit main: Schreibt vom Maker erstellte Objekte in die Datenbank
* Testen: Frontend/Middletier : Ändern der Factory
*/
	
	
}
