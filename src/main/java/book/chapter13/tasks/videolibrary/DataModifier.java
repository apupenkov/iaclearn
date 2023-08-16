package book.chapter13.tasks.videolibrary;

import java.sql.Connection;
import java.sql.SQLException;

public class DataModifier {
    private Connection connection;

    public DataModifier() throws SQLException {
        this.connection = DBConnection.getConnection();
    }
}
