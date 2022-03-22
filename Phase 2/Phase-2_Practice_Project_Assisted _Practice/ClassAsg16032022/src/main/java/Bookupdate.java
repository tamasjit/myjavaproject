import java.sql.*;
 
/**
 * A Java program demonstrates how to create a MySQL stored procedure
 * using JDBC.
 *
 * @author www.codejava.net
 */
public class Bookupdate {
 
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/bookstore";
        String user = "root";
        String password = "Abc@123";
 
        try (
            Connection conn = DriverManager.getConnection(dbURL, user, password);
 
            Statement statement = conn.createStatement();
        ) {
 
            String queryDrop = "DROP PROCEDURE IF EXISTS update_price";
 
            String queryCreate = "CREATE PROCEDURE update_price (IN auth INT, IN bID INT, IN upprice INT)";
            queryCreate += "UPDATE book SET price = upprice WHERE author = auth and BookId = bID ";
 
            // drops the existing procedure if exists
            statement.execute(queryDrop);
 
            // then creates a new stored procedure
            statement.execute(queryCreate);
 
            statement.close();
 
            System.out.println("Stored procedure created successfully!");
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}