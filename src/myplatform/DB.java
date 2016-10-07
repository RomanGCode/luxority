/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myplatform;

import java.sql.*;


/**
 *
 * @author crafttor
 */
public class DB
{
    private static final String url = "jdbc:mysql://localhost:3306/myinf";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection con;


    private static Statement stmt;
    private static ResultSet rs;

    public static void db() {
    try {
        con = DriverManager.getConnection(url, user, password);
      //  Statement statement = con.createStatement();

      //  stmt = con.createStatement();
        if(!con.isClosed()) {
            System.out.println("Соединение установлено");
        }

//       statement.execute("INSERT INTO Products (product, sum, unit, availability, description, rating) VALUES ('чтото', '122', 'шт', '1', 'вкусно', '2');");
//        con.close();
    }
    catch (SQLException sqlEx)
        {
            sqlEx.printStackTrace();
        }

    }
    public void finalize(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet resultSetQuery(String query){
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public void sqlQuery(String query){
//        try {
//            Statement stmt = con.createStatement();
//            stmt.executeUpdate(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DB.con = con;
    }

}
