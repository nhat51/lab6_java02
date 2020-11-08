package Lab06;

import java.sql.*;

public class JDBCUpdate {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookself",
                "root","");
             Statement stmt = conn.createStatement()){
            String strUpdate = "update books set price = price*0.7, qty = qty + 1 where bookID = 1001";
            System.out.println("The sql statement is: " + strUpdate +"\n");
            int countUpdate = stmt.executeUpdate(strUpdate);
            System.out.println(countUpdate + " records effected.");

            String strSelect = "Select * from books where bookID = 1001";
            System.out.println("The sql statement is: " + strSelect);
            ResultSet rSet = stmt.executeQuery(strSelect);
            while (rSet.next()){
                System.out.println(rSet.getInt("bookID")
                + rSet.getString("BookName")+", "
                +rSet.getString("author")+", "
                +rSet.getDouble("price")+", "
                +rSet.getInt("qty"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
