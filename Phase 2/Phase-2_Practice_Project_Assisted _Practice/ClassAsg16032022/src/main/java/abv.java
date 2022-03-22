import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class abv {
   static final String DB_URL = "jdbc:mysql://localhost:3306/bookstore";
   static final String USER = "root";
   static final String PASS = "Abc@123";
   static final String QUERY = "SELECT * FROM book";
//DBConnection conn = new DBConnection("jdbc:mysql://localhost:3306/ecommerce","root","Abc@123");
   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
      ) {		      
         String sql = "UPDATE book " +
            "SET price = 700 WHERE author = 2 and BookId = 4 ";
         stmt.executeUpdate(sql);
         ResultSet rs = stmt.executeQuery(QUERY);
         while(rs.next()){
            //Display values
            System.out.print(" BookId: " + rs.getInt("BookId"));
            System.out.print(", ISBN: " + rs.getInt("ISBN"));
            System.out.print(", book_name: " + rs.getString("book_name"));
            System.out.println(", author: " + rs.getInt("author"));
            System.out.println(", ed_num: " + rs.getInt("ed_num"));
            System.out.println(", price: " + rs.getInt("price"));
            System.out.println(", pages: " + rs.getInt("pages"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}