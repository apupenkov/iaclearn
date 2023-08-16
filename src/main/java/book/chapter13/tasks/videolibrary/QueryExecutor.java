package book.chapter13.tasks.videolibrary;

import java.sql.Connection;
import java.sql.SQLException;

public class QueryExecutor {
    private Connection connection;

    public QueryExecutor() throws SQLException {
        this.connection = DBConnection.getConnection();
    }
}
