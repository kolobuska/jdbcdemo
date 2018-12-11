import org.testng.annotations.Test;

import java.sql.*;

public class Main {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/api";
    private static final String user = "root";
    private static final String password = "";

    // JDBC variables for opening and managing connection
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    @Test
    public void test1() {


        try {
            // opening database connection to MySQL server
            connection = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            statement = connection.createStatement();

            // executing SELECT query
            String query = "select count(*) from api_users";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int count = resultSet.getInt(1);
                System.out.println("Total number of users in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,statement and resultset here
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    @Test
    public void test2(){

        try {
            // opening database connection to MySQL server
            connection = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            String query = "select * from api_users";
            statement = connection.createStatement();

            // executing SELECT query
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String username = resultSet.getString(3);
                String email = resultSet.getString("email");
                System.out.printf("id: %d, name: %s, username: %s, email: %s %n",
                        id, name, username, email);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,statement and resultset here
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }

    @Test
    public void test3(){

        try {
            // opening database connection to MySQL server
            connection = DriverManager.getConnection(url, user, password);

            // getting Statement object to execute query
            statement = connection.createStatement();

            // executing SELECT query
            String query = "INSERT INTO `api`.`api_users`\n" +
                    "(`name`,\n" +
                    "`username`,\n" +
                    "`email`,\n" +
                    "`address`,\n" +
                    "`phone`)\n" +
                    "VALUES\n" +
                    "('test123',\n" +
                    "'test123',\n" +
                    "'test123',\n" +
                    "'test123',\n" +
                    "'test123');";
            statement.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,statement and resultset here
            try {
                connection.close();
                statement.close();
            } catch (SQLException se) { /*can't do anything */ }
        }
    }
}