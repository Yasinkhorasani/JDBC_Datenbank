package objectorientiertes.Datenbank;

import java.util.List;

public class GummibaerchenShop {

	public static void main(String[] args) {

			DatenbankZugriff quelle = new DatenbankZugriff();
			List<Gummibaerchen> allerSuesskram = quelle.lesenAllerGummibaerchen();
			allerSuesskram.forEach(System.out::println);
			}
			

	}


