package myCraftForm.database.connection;
import java.sql.*;
/**
 *
 * Используется для подключения к базе данных  и выполнение запросов
 */

public class DB {
    
    private static final String url = "jdbc:mysql://localhost:3306/myinf?useSSL=false&useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "root";
    private static Connection con;
    public String INSERT_NEW = "INSERT INTO Products (product, sum, unit,description, availability, rating) VALUES (?, ?, ?, ?, ?, ?);";
    public String Delete = "DELETE FROM Products WHERE id = ?;";
    private static Statement stmt;
    private static ResultSet rs;
    PreparedStatement preparedStatement = null;
    
    public DB() throws SQLException {
    }
    public static void db() {
        try {
            con = DriverManager.getConnection(url, user, password);

            if(!con.isClosed()) {
                System.out.println("Соединение установлено");
            }
        }
        catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
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

    public void sqlInto (String productTextField, String sumTextField, String unitTextField, String descriptionTextField, String availabtext, int ratingtext){

        try {
            preparedStatement = con.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, productTextField);
            preparedStatement.setString(2, sumTextField);
            preparedStatement.setString(3, unitTextField);
            preparedStatement.setString(4, descriptionTextField);
            preparedStatement.setString(5, availabtext);
            preparedStatement.setInt(6, ratingtext);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
    public void sqlDeleteRow (int idR){

        try {
            preparedStatement = con.prepareStatement(Delete);
            preparedStatement.setInt(1, idR);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void sqlQuery(String query){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection con) {
        DB.con = con;
    }

    public void finalize(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}