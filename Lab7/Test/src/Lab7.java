import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lab7 {
    public static void main(String[] args){
        String jdbcURL = "jdbc:postgresql://localhost:5432/Labs";
        String username = "postgres";
        String password = "Otter534#";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

    }
}
