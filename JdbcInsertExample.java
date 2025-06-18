import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JdbcInsertExample {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/test"; 
        String username = "root";                            
        String password = "Infant@2411";                        

        try {
            // Connect to database
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to database.");

            Statement stmt = connection.createStatement();

            // Corrected CREATE TABLE SQL
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employee ("
                    + "empcode INT PRIMARY KEY, "
                    + "empname VARCHAR(50), "
                    + "empage INT, "
                    + "esalary DOUBLE)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table created or already exists.");

            // Inserting data
            String insertSQL1 = "INSERT INTO employee VALUES (101, 'Johans', 25, 10000)";
            String insertSQL2 = "INSERT INTO employee VALUES (102, 'Surya', 30, 20000)";
            String insertSQL3 = "INSERT INTO employee VALUES (103, 'Arun', 20, 40000)";
            String insertSQL4 = "INSERT INTO employee VALUES (104, 'Mary', 40, 80000)";
            String insertSQL5 = "INSERT INTO employee VALUES (105, 'Infant', 25, 90000)";

            stmt.executeUpdate(insertSQL1);
            stmt.executeUpdate(insertSQL2);
            stmt.executeUpdate(insertSQL3);
            stmt.executeUpdate(insertSQL4);
            stmt.executeUpdate(insertSQL5);

            System.out.println("Data inserted successfully.");

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting or executing SQL: " + e.getMessage());
        }
    }
}