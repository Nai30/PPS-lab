import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class DBConnection {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("Enter your database name, user name and password");
String database = input.nextLine();
String user = input.nextLine();
String password = input.nextLine();
String url = "jdbc:mariadb://localhost:3306/"+ database;
ArrayList<Sales> infoList = new ArrayList<Sales>();
try {
Connection conn = DriverManager.getConnection(url, user, password);
Statement stmt = conn.createStatement();
System.out.println("Connection to MariaDB established successfully!");
// Example: Execute a query
ResultSet rs = stmt.executeQuery("select o.order_no as orderN, c.customer_name as customerN, c.city as customer_city, s.name as salesmanN, o.purchase_amt as amount, s.commission from orders o inner join customer c on c.customer_id=o.customer_id inner join salesman s on c.salesman_id = s.salesman_id; ");
while (rs.next()) {
int orderNumber=rs.getInt("orderN");
String customerName=rs.getString("customerN");
 String customerCity= rs.getString("customer_city");
    String salesmanName=rs.getString("salesmanN");
    double amount= rs.getDouble("amount");
    double commissionAmount= amount* (rs.getDouble("commission"));
Sales ne = new Sales(orderNumber,customerName,customerCity,salesmanName,amount,commissionAmount);
infoList.add(ne);
System.out.println(ne);
}
} catch (SQLException e) {
System.err.println("Database connection failed:");
e.printStackTrace();
}
}
}

    

