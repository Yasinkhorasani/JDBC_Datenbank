package objectorientiertes.Datenbank;

import java.time.LocalDate;

/**
 * entspricht einen datensatz in der Tabelle der Datenbank
 * @author Alfa
 *
 */
public class Gummibaerchen {
	
	
	
	/** 
	 * Entspricht der Spalte gummibaerID
	 */
	private int primaerSchlussel;
/**
 * Entspricht der grosse gummibaer
 */
	private String frucht;
	
	private  String farbe;
	
	private int groesse;
	
	private LocalDate mindesthaltbarkeit;
	
	@Override
	public String toString() {
		return "Gummibaerchen [primaerSchlussel=" + primaerSchlussel + ", frucht=" + frucht + ", farbe=" + farbe
				+ ", groesse=" + groesse + ", mindesthaltbarkeit=" + mindesthaltbarkeit + "]";
	}

	/**
	 * @return the primaerSchlussel
	 */
	public int getPrimaerSchlussel() {
		return primaerSchlussel;
	}

	/**
	 * @param primaerSchlussel the primaerSchlussel to set
	 */
	public void setPrimaerSchlussel(int primaerSchlussel) {
		this.primaerSchlussel = primaerSchlussel;
	}

	/**
	 * @return the frucht
	 */
	public String getFrucht() {
		return frucht;
	}

	/**
	 * @param frucht the frucht to set
	 */
	public void setFrucht(String frucht) {
		this.frucht = frucht;
	}

	/**
	 * @return the farbe
	 */
	public String getFarbe() {
		return farbe;
	}

	/**
	 * @param farbe the farbe to set
	 */
	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	/**
	 * @return the groesse
	 */
	public int getGroesse() {
		return groesse;
	}

	/**
	 * @param groesse the groesse to set
	 */
	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	/**
	 * @return the mindesthaltbarkeit
	 */
	public LocalDate getMindesthaltbarkeit() {
		return mindesthaltbarkeit;
	}

	/**
	 * @param mindesthaltbarkeit the mindesthaltbarkeit to set
	 */
	public void setMindesthaltbarkeit(LocalDate mindesthaltbarkeit) {
		this.mindesthaltbarkeit = mindesthaltbarkeit;
	}

	/**
	 * @param frucht
	 * @param farbe
	 * @param groesse
	 * @param mindesthaltbarkeit
	 */
	public Gummibaerchen(String frucht, String farbe, int groesse, LocalDate mindesthaltbarkeit) {
		this.frucht = frucht;
		this.farbe = farbe;
		this.groesse = groesse;
		this.mindesthaltbarkeit = mindesthaltbarkeit;
	}

	
}
