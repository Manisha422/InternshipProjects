package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.book;
public class bookDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/salesdb?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";

    private static final String INSERT_BOOKS_SQL = "INSERT INTO books" + "  (name, edition, price) VALUES " +" (?, ?, ?);";

    private static final String SELECT_BOOK_BY_ID = "select id,name,edition,price from books where id =?";
    private static final String SELECT_ALL_BOOKS = "select * from books";
    private static final String DELETE_BOOKS_SQL = "delete from books where id = ?;";
    private static final String UPDATE_BOOKS_SQL = "update books set name = ?,edition= ?, price =? where id = ?;";
    
    public bookDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    public void insertBooks(book user) throws SQLException {
        System.out.println(INSERT_BOOKS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getEdition());
            preparedStatement.setDouble(3, user.getPrice());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public book selectBook(int id) {
        book user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                int edition = rs.getInt("edition");
                double price = rs.getDouble("price");
                user = new book(id, name, edition, price);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }
    public List < book > selectAllBooks() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List < book > users = new ArrayList < > ();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int edition = rs.getInt("edition");
                double price = rs.getDouble("price");
                users.add(new book(id, name, edition, price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_BOOKS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public boolean updateBook(book user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL);) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getEdition());
            statement.setDouble(3, user.getPrice());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
