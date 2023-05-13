import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class App  {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        Connection conn = null;
        Statement stmt = null;
        try {
            // 1. Connect to the MySQL database
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","12345");

            // 2. Create a new database
            stmt = connection.createStatement();
            String sql = "Use DATABASE fitness_management";
            stmt.executeUpdate(sql);
            System.out.println("Database opened successfully");

            DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","12345");
            connection.createStatement();

            sql = "CREATE TABLE Admin (" +
                  "id INT ," +
                  "username VARCHAR(50)," +
                  "password VARCHAR(50)," +
                  "email VARCHAR(50)," +
                  "PRIMARY KEY (id)" +
                  ")";
            stmt.executeUpdate(sql);
            System.out.println("Table users created successfully");

            sql = "CREATE TABLE User (" +
                  "id INT," +
                  "user_id INT," +
                  "name VARCHAR(50)," +
                  "description TEXT," +
                  "date DATE," +
                  "PRIMARY KEY (id)," +
                  "FOREIGN KEY (user_id) REFERENCES users(id)" +
                  ")";
            stmt.executeUpdate(sql);
            System.out.println("Table workouts created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

    
