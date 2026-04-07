
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplaySales {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("Enter your database name, user name and password");
String database = input.nextLine();
String user = input.nextLine();
String password = input.nextLine();
String url = "jdbc:mariadb://localhost:3306/"+ database;
ArrayList<SalesPerson> salesPersonList = new ArrayList<SalesPerson>();
try {
Connection conn = DriverManager.getConnection(url, user, password);
Statement stmt = conn.createStatement();
System.out.println("Connection to MariaDB established successfully!");
// Example: Execute a query
ResultSet rs = stmt.executeQuery("select  a.name, a.city, a.commission, b.purchase_amt as purchase from salesman a join orders b on a.salesman_id = b.salesman_id; ");

while (rs.next()) {
   
    String name= rs.getString("name");
    String city= rs.getString("city");
    int commission= rs.getInt("commission");
    int totalSales= rs.getInt("purchase");
    SalesPerson sp = new SalesPerson(name, city, commission, totalSales);
    salesPersonList.add(sp);
    System.out.println(sp);
    
}
// 1. Print all names and total sales
            System.out.println("\n--- Sales Report ---");
            System.out.printf("%-20s | %-10s\n", "Name", "Total Sales");
            System.out.println("---------------------------------------");
            salesPersonList.stream()
                .forEach(sp -> System.out.printf("%-20s | $%-10.2f\n", sp.getName(), sp.getTotalSales()));

            // 2. Print all names and total commissions (Sales * Commission Rate)
            System.out.println("\n--- Commission Report ---");
            System.out.printf("%-20s | %-10s\n", "Name", "Commission");
            System.out.println("---------------------------------------");
            salesPersonList.stream()
                .forEach(sp -> {
                    double commissionEarned = sp.getTotalSales() * sp.getCommissionRate();
                    System.out.printf("%-20s | $%-10.2f\n", sp.getName(), commissionEarned);
                });
} catch (SQLException e) {
System.err.println("Database connection failed:");
e.printStackTrace();
}

}
 
}
