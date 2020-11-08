package Lab06;

import java.sql.*;

public class NorthwindUpdate_Customer {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind","root","");
            Statement stmt = conn.createStatement()) {
            String update = "Update customers set Address = '1A -Yet Kieu - Ha Noi' where CustomerID = 'FRANK'";
            System.out.println("The sql statement is: " + update + "\n");
            stmt.executeUpdate(update);
            System.out.println("Updated");
            ResultSet rSet = stmt.executeQuery("SELECT * from customers ");
            while (rSet.next()){
                System.out.println(rSet.getString("CustomerID") + ", "
                + rSet.getString("ContactName")+ ", "
                + rSet.getString("Address"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
