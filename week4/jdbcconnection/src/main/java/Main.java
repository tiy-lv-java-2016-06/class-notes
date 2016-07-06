import java.sql.*;

/**
 * Created by jeff on 7/6/16.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:postgresql:books");

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM books LIMIT 5");
        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");

            Book book = new Book(id, title, author);

            System.out.println(book);
        }
    }
}
