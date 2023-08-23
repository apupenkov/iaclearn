package book.chapter13.chapter_examples.mysql;

import java.sql.*;
import java.util.Arrays;

public class BatchMain {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = ConnectionCreator.createConnection();
            connection.setAutoCommit(false); // turn off autocommit
            Statement statement = connection.createStatement();
            statement.addBatch("INSERT INTO phonebook VALUES (92, 'Sapega', 112211)");
            statement.addBatch("INSERT INTO location VALUES (201, 'Minsk')");
            statement.addBatch("INSERT INTO location VALUES (202, 'polotesk')");
// submit a batch of update commands for execution
            int[] updateCounts = statement.executeBatch();
            connection.commit();
            System.out.println(Arrays.toString(updateCounts));
        } catch (SQLException e) {
            try {
                if(connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if(connection != null) { // turn on autocommit
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
