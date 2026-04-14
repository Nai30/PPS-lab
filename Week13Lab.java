import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.function.*;
public class Week13Lab {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("Enter your database name, user name and password");
String database = input.nextLine();
String user = input.nextLine();
String password = input.nextLine();
String url = "jdbc:mariadb://localhost:3306/"+ database;

try {
Connection conn = DriverManager.getConnection(url, user, password);
Statement stmt = conn.createStatement();
System.out.println("Connection to MariaDB established successfully!");
// Example: Execute a query
String query="select id, name, salary from employees;";
ResultSet rs = stmt.executeQuery(query);
List<Employee> employeesList=new ArrayList<Employee>();

//creating a mapping function to convert each row of the result set into a Customer object
Function<ResultSet, Employee> rsSet = resultSet -> {
try {
return new Employee(resultSet.getInt("id"),
resultSet.getString("name"),
resultSet.getDouble("salary"));
} catch (SQLException e) {
throw new RuntimeException("Error mapping ResultSet to Employee", e);
}
};



//looping through the resultset and applying mapping func
while (rs.next()) {
Employee emp = rsSet.apply(rs);
employeesList.add(emp);

}
// Define the Consumer
Consumer<Employee> printEmp = e -> System.out.println(e.getId() + " - " + e.getName() + " - $" + e.getSalary());
employeesList.forEach(printEmp);

//Define a Predicate to filter employees with salary greater than 50000
Predicate<Employee>isGreaterPredicate= (emp) -> emp.getSalary()>5000;
List<Employee> highEarners =employeesList.stream().filter(isGreaterPredicate).collect(Collectors.toList());
highEarners.forEach(printEmp);

//Define a Function to apply a 15% tax to the salary of each employee
Function<Employee,Employee> applyTax= (emp) -> { double newSalary= emp.getSalary()*0.85; return new Employee(emp.getId(),emp.getName(), newSalary);};
List<Employee> afterTax = highEarners.stream().map(applyTax).collect(Collectors.toList());
System.out.println("Employees with salary greater than 5000 after tax:");
afterTax.forEach(printEmp);

//format the salary to 2 decimal places and add a $ sign
Function<Employee,String> formatSalary = (emp) ->{ double newSalary= Math.round(emp.getSalary()*100.0)/100.0;return "$"+newSalary;};
List<Employee> highEarnerRef= employeesList.stream().filter(isGreaterPredicate).map(applyTax).collect(Collectors.toList());
highEarnerRef.forEach(emp-> { String formattedSalary = formatSalary.apply(emp); System.out.println(emp.getId() + " - " + emp.getName() + " - " + formattedSalary); });
} catch (SQLException e) {
System.err.println("Database connection failed:");
e.printStackTrace();
}
}
    
}
