/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Andressa Gomes
 */
public class DBConnection {
    //    INFO TO CONNECT TO DATABASE
    private String dbServer = "jdbc:mysql://apontejaj.com:3306/Rylee_2019145?useSSL=false";
    private String dbUser = "Rylee_2019145";
    private String dbPassword = "2019145";
    
    private Connection conn;
    private Statement stmt;
    
    public void OpenConnection(){
        try{
        //CONNECT TO DATABASE
            conn = DriverManager.getConnection(dbServer, dbUser, dbPassword);

        //GET A STATEMENT FROM THE CONNECTION
            stmt = conn.createStatement();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

        //SQL EXCEPTIONS LOOP
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
            stmt.close();
            conn.close();
            }catch (SQLException e) {
            System.out.println(e);   
        } 
        }
        
    }
    
}
