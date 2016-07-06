import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jeff on 7/6/16.
 */
public class Book {
    private int id = 0;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s(%d) written by %s", title, id, author);
    }

    public void save(Connection conn) throws SQLException {
        if(id > 0){
            PreparedStatement statement =
                    conn.prepareStatement("UPDATE books SET title = ?, author = ? WHERE id = ?");
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setInt(3, id);
            statement.execute();
        }
        else{
            PreparedStatement insert =
                    conn.prepareStatement("INSERT INTO book (title, author) VALUES(?, ?)");
            insert.setString(1, title);
            insert.setString(2, author);
            insert.execute();

        }
    }
}
