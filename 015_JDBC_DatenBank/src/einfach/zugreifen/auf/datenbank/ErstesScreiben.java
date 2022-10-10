package einfach.zugreifen.auf.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ErstesScreiben {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/gummibärchendb" ;//? createDatabaseIfNotExist=true";
		String user ="root";
		String password = "";
		
		Connection verbindung = DriverManager.getConnection(url, user, password);
		Statement verpackung = verbindung.createStatement();
		
		//INSERT INTO table_name VALUES (value1, value2, value3, ...);
		String sqlEingabe = "INSERT INTO gummibaer VALUES(NULL,'Erdbeer','rot','5','2022-11-11')";
		verpackung.execute(sqlEingabe);
		System.out.println("Schreiben abgeschlossen");
	}

}
