package api;
import java.sql.*;
public class Data {

        public static void main(String[] args) throws SQLException {
            // Create in-memory database
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
            Statement stmt = conn.createStatement();
            // Create table
            stmt.execute("CREATE TABLE employees (id INT PRIMARY KEY, name VARCHAR(50), salary DOUBLE)");
            // Insert mock data
            stmt.execute("INSERT INTO employees VALUES (1, 'Alice', 50000)");
            stmt.execute("INSERT INTO employees VALUES (2, 'Bob', 60000)");
            // Query data
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("salary"));
            }

            conn.close();
        }
    }

