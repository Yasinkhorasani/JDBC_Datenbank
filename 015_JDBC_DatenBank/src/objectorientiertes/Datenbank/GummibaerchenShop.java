package objectorientiertes.Datenbank;

import java.time.LocalDate;
import java.util.List;



public class GummibaerchenShop {

	public static void main(String[] args) {

		DatenbankZugriff quelle = new DatenbankZugriff();
//		List<Gummibaerchen> allerSuesskram = quelle.lesenAllerGummibaerchen();
//		allerSuesskram.forEach(System.out::println);
		Gummibaerchen neu = new Gummibaerchen("Banane", "Gelb", 15, LocalDate.now());
//		quelle.schreibenEinesGummibaer(neu);
//		quelle.schreibenEinesGummibaer(neu);
////		System.out.println("Ende");
//		
//		
//		Gummibaerchen beispiel = new Gummibaerchen("Pflaume", "Blau", 7, LocalDate.of(2022,2,2));
//		Gummibaerchen siehtAusWieBeispiel = new Gummibaerchen("Pflaume", "Blau", 7, LocalDate.of(2022,2,2));
//		System.out.println(beispiel);
//		quelle.besserSchreibenEinsGummibaer(beispiel);
//		System.out.println(beispiel);
//		quelle.besserSchreibenEinsGummibaer(beispiel);
//		quelle.besserSchreibenEinsGummibaer(siehtAusWieBeispiel);
		quelle.loeschen("Pflaume");
		

	}

}
/* 
* Übung : 
* DAO-Projekt: AmigurumiDAOImplMitDB: SELECT/INSERT Optional: UPDATE und DELETE
* Amigurumi Klasse verbessern: setPK-Methode mit Kontrollen (optional:eigene Exception auslösen)
* Maker: Beispieldaten in Tabelle, Maker nicht ändern! 
* Erstellen einer Datenbank-Füller-Klasse mit main: Schreibt vom Maker erstellte Objekte in die Datenbank
* Testen: Frontend/Middletier : Ändern der Factory
*/