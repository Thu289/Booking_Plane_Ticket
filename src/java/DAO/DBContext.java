/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vostro 5502
 */
public class DBContext {

    public DBContext() {
    }
    
    public DBContext(String user, String pass) {
        userID=user;
        password=pass;
    }
    
    public Connection getConnection() throws Exception{
        String url="jdbc:sqlserver://"+serverName+":"+portNumber +
                ";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    private final String serverName="localhost";
    private final String dbName="PRJ301_SE1625";
    private final String portNumber="1433";
    private String userID="sa";
    private String password="1234";
}  
    class Using{
        public static void main(String[] args) {
            try {
                new DBContext().getConnection();
                System.out.println("Successfully");
            } catch (Exception e) {
                System.out.println("fail");
            }
        }
    }
