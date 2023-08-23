package book.chapter13.chapter_examples.mysql;

import book.chapter13.chapter_examples.mysql.entities.Abonent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SimpleJdbcMain {
    public static void main(String[] args) {
//        try {
//            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        String url = "jdbc:mysql://localhost:3306/testphones";
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "pass");
        prop.put("autoReconnect", "true");
        prop.put("characterEncoding", "UTF-8");
        prop.put("useUnicode", "true");
        prop.put("useSSL", "true");
        prop.put("useJDBCCompliantTimezoneShift", "true");
        prop.put("useLegacyDatetimeCode", "false");
        prop.put("serverTimezone", "UTC");
        prop.put("serverSslCert", "classpath:server.crt");
        try (Connection connection = DriverManager.getConnection(url, prop);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT idphonebook, lastname, phone FROM phonebook";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Abonent> abonents = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int number = resultSet.getInt("phone");
                abonents.add(new Abonent(id, name, number));
            }
            System.out.println(abonents);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
