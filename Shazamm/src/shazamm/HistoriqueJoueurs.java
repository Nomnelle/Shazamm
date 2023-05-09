/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shazamm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author linazaarate
 */
public class HistoriqueJoueurs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = null;
        ResultSet rs;
        String host = "mysql-shazamm-mick-purson-zaarate.alwaysdata.net";
        String dbname = "shazamm-mick-purson-zaarate";
        String port = "3306";
        String password = "312193";
        String username = "Shazamm.2023";//mot de passe de l'utilisateur
        String query;
        
        try {
            String connectUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbname;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(connectUrl, username, password);
            System.out.println("Database connection established.");

            Statement stmt = con.createStatement();
            
            query = "SELECT * FROM joueurs";
            rs = stmt.executeQuery(query);
            
            while (rs.next()){
                
            }
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Cannot load db driver: com.mysql.jdbc.Driver");
            cnfe.printStackTrace();
        } catch (SQLException se) {
            System.out.println("Avez-vous pensé à démarrer EasyPHP/Wamp ?");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erreur inattendue");
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Database connection terminated.");
                } catch (Exception e) { /* ignore close errors */ }
            }
    
        }
    }
}
