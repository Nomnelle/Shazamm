/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shazamm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author linazaarate
 */
public class BDD {
    
    Connection con;
    String host;
    String dbName;
    String port;
    String username;
    String password;
    
    public BDD(){
        con = null;
        host = "mysql-shazamm-mick-purson-zaarate.alwaysdata.net";
        dbName = "shazamm-mick-purson-zaarate_mysql";
        port = "3306";
        username = "312193";
        password = "Shazamm.2023";
    }
    
    private void openConnexion(){
        
        if (this.con != null) {
            this.closeConnexion();
        }
        
        try {
            String connectUrl = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(connectUrl, username, password);
            System.out.println("Database connection established.");
       } catch (ClassNotFoundException cnfe) {
            System.out.println("Cannot load db driver: com.mysql.jdbc.Driver");
            cnfe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erreur inattendue");
            e.printStackTrace();
        }
        
    }
    
    private void closeConnexion() {
        if (this.con != null) {
            try {
                this.con.close();
                System.out.println("Database connection terminated.");
            } catch (Exception e) { /* ignore close errors */ }
        }
    }
    
    public ArrayList<String> getTuples(){
        ArrayList<String> res = null;
        String query = "SELECT nom_gagnant, COUNT(*) AS nombre_victoires FROM Shazamm GROUP BY nom_gagnant;";
        try {
            this.openConnexion();
            Statement stmt = this.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData metadata = rs.getMetaData(); // permet de récupérer les noms des colonnes des tuples en sortie de la requête
            String tuple;
            res = new ArrayList<>();
            while (rs.next()) {
                tuple = "";
                for (int i = 1; i <= metadata.getColumnCount(); i++) {
                    tuple += rs.getString(i);
                    if (i<metadata.getColumnCount()) {
                        tuple +=";";
                    }
                }
                res.add(tuple);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Probleme avec la requete");
        } finally {
            this.closeConnexion();
        }
        return res;
    }
    
    /*
     * Insère un ou plusieurs tuples dans la base à partir de la requête passée en paramètre
     * Pour cela, il faut utiliser la méthode executeUpdate dans la classe Statement
     */
    public void insertTuples(String nomJoueur, String couleur) {
        String updateQuery = "INSERT INTO Shazamm (nom_gagnant, couleur) VALUES('"+nomJoueur+"', '"+couleur+"')";
        try {
            this.openConnexion();
            Statement stmt = this.con.createStatement();
            int n = stmt.executeUpdate(updateQuery);
            System.out.println(n+" tuples inseres");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Probleme avec la requete d'insertion");
        } finally {
            this.closeConnexion();
        }
    }
    
    public static void main(String args[]){
        
        BDD test = new BDD();
        test.insertTuples("Socrate", "rouge");
        test.insertTuples("Tesla", "vert");
        test.insertTuples("Tesla", "vert");
        ArrayList<String> resultat = test.getTuples();
        System.out.println(resultat.toString());
        
    }

}
