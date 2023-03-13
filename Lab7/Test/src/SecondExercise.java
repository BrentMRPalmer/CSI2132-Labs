import java.sql.*;

public class SecondExercise {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Labs";
        String username = "postgres";
        String password = "Otter534#";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();

            String[] fields = {"sname", "age", "rating"};
            String query = "SELECT " + String.join(", ", fields) + " FROM Sailors";

            ResultSet rs = statement.executeQuery(query);
            System.out.println("Name Age Rating");
            while (rs.next())
            {
                // This will return column 1
                System.out.print(rs.getString(1) + " ");
                // This will return column 2
                System.out.print(rs.getInt(2) + " ");
                //This will return column 3
                System.out.println(rs.getInt(3));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
