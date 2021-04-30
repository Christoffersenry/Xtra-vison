/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Card;

/**
 *
 * @author Andressa Gomes
 */
public class DBConnection {
    //    INFO TO CONNECT TO DATABASE
    private String dbServer = "jdbc:mysql://apontejaj.com:3306/Rylee_2019145?useSSL=false";
    private String dbUser = "Rylee_2019145";
    private String dbPassword = "2019145";
    
    Card c;
    
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public boolean boolNCC = true;
    
    public String[] movieTitles;
    
    public DBConnection(Card c) {
        this.c = c;
        openConnection();
    }
    
    public void openConnection(){
        try{
            //             CONNECT TO DATABASE
            conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

//             GET A STATEMENT FROM THE CONNECTION
            stmt = conn.createStatement();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

//             SQL EXCEPTIONS LOOP
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void getMovieSelection(){
        String query = "SELECT DISTINCT title FROM movie;";
        
        try{
            rs= stmt.executeQuery(query);
            
            while (rs.next()) {
                String title = rs.getString(1);
                System.out.println(title);
//                System.out.println(rs.getString("title"));
            }            
            rs.close();
            
        }catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void insertNewCustCard(String newCardNum) {
        try {
//            STRING FOR SQL STATEMENT INSERTING NEW CUSTOMER CARD DETAILS
            String insertQuery = "INSERT INTO card (card) VALUES (?);";
            
//           PREPARE STATEMENT WITH VALIDATED (NEW GEN) CARD NUMBER 
           PreparedStatement pStmt = conn.prepareStatement(insertQuery);
           pStmt.setString(1, newCardNum); 
           
//           EXECUTE PREPARED STATEMENT AND CLOSE
           pStmt.execute();
           pStmt.close();  
           
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public boolean newCustCheck(Card c) {
        try {
           String selectQuery = "SELECT count(*) AS exist FROM card WHERE card='"+c.getCardNum()+"';"; 
           rs = stmt.executeQuery(selectQuery);
           
           if (rs.next()) {
               boolNCC = false;
               System.out.println("Not a new customer.");
           }
           
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return boolNCC;
    }
    
    
    
    public void closeConnection() {
        try {
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            while (se != null) {                                                        // Loop through the SQL Exceptions
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
