import java.sql.*;

public class FirstExercise {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:postgresql://localhost:5432/Labs";
        String username = "postgres";
        String password = "Otter534#";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();

            String query1 = "SELECT bname, color FROM Boats";

            ResultSet rs = statement.executeQuery(query1);
            System.out.println("Name\tColor");
            while (rs.next())
            {
                // This will return column 1
                System.out.print(rs.getString(1) + "\t");
                // This will return column 2
                System.out.println(rs.getString(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
