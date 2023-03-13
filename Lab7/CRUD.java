package CSI2132;

import java.sql.*;

public class CRUD {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:postgresql://localhost:5432/Labs";
        String username = "postgres";
        String password = "Otter534#";
        try{
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            String Table = "Sailors";

            // Inserting a static row into Table
            String query = "INSERT INTO "+ Table +" VALUES (5,'Nihal',9,26)";
            InsertRowIntoSailors(statement, query);

            // Inserting a dynamic row into Table
            query = "INSERT INTO "+ Table +" VALUES (?,?,?,?)";
//            InsertRowDynamicallyIntoSailors(connection, query);

            // Reading values from Table
            String fields = "SID,SNAME,RATING,AGE";
            query = "SELECT "+fields+" FROM "+ Table;
//            SelectFromSailors(statement, query);

            // Update Row in Table (Can be Static or Dynamic)
            query = "UPDATE "+ Table +" SET sname = ? WHERE SID = ?";
//            UpdateSailorsDynamically(connection, query);

            // Delete Row from Table (Can be Static or Dynamic)
            query = "DELETE FROM "+ Table +" WHERE sname = ?";
            DeleteSailorsSynamically(connection, query);

            statement.close();
            connection.close();

        }catch (SQLException e){
            System.out.println("Error in connecting to PostgreSQL server");
            e.printStackTrace();
        }

    }

    private static void InsertRowIntoSailors(Statement statement, String query) throws SQLException {

        int rows = statement.executeUpdate(query);
        if(rows>0){
            System.out.println("New row inserted into database");
        }else{
            System.out.println("Insert Failed");
        }
    }

    private static void InsertRowDynamicallyIntoSailors(Connection connection, String query) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1,7);
        statement.setString(2,"Seinfield");
        statement.setInt(3,7);
        statement.setInt(4,23);

        int rows = statement.executeUpdate();
        if(rows>0){
            System.out.println("New row inserted into database");
        }else{
            System.out.println("Insert Failed");
        }
    }

    private static void SelectFromSailors(Statement statement, String query) throws SQLException {
        ResultSet rs = statement.executeQuery(query);

        while (rs.next())
        {
            // This will return column 1
            System.out.println(rs.getInt(1));
            // This will return column with name "sname"
            System.out.println(rs.getString("sname"));
        }

        // TO get the number of columns returned by the Query
        ResultSetMetaData rsMetaData = rs.getMetaData();
        int numberOfColumns = rsMetaData.getColumnCount();
        System.out.println("Number of Columns:"+numberOfColumns);
        rs.close();
    }

    private static void UpdateSailorsDynamically(Connection connection, String query) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1,"Travis");
        statement.setInt(2,5);

        int rows = statement.executeUpdate();
        if(rows>0){
            System.out.println("Row Updated");
        }else{
            System.out.println("Update Failed");
        }
    }

    private static void DeleteSailorsSynamically(Connection connection, String query) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1,"Travis");

        int rows = statement.executeUpdate();
        if(rows>0){
            System.out.println("Row Deleted");
        }else{
            System.out.println("Delete Failed");
        }
    }

}
