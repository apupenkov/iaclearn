package book.chapter13.chapter_examples.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedMain {
    public static void main(String[] args) {
        try(Connection connection = ConnectionCreator.createConnection()){
            String sql = "INSERT INTO phonebook(idphonebook, lastname, phone) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, 43);
            statement.setString(2, "Skaryna");
            statement.setInt(3, 990077);
            int rowsUpdate = statement.executeUpdate();
            System.out.println(rowsUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
