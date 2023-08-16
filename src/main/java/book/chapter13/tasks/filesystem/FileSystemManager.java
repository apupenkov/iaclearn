package book.chapter13.tasks.filesystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileSystemManager {
    private Connection connection;

    public FileSystemManager() throws SQLException {
        connection = DBConnection.getConnection();
    }

    public String getFullPath(int fileId) throws SQLException {
        String sql = "SELECT name, parent_id FROM file WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, fileId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String fileName = resultSet.getString("name");
                    int parentId = resultSet.getInt("parent_id");
                    return buildFullPath(parentId) + "/" + fileName;
                }
            }
        }
        return null;
    }

    private String buildFullPath(int fileId) throws SQLException {
        if (fileId == 0) {
            return "";
        }

        String sql = "SELECT name, parent_id FROM directory WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, fileId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String directoryName = resultSet.getString("name");
                    int parentId = resultSet.getInt("parent_id");
                    return buildFullPath(parentId) + "/" + directoryName;
                }
            }
        }
        return null;
    }

    public int countFilesInDirectory(int directoryId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM file WHERE parent_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, directoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        return 0;
    }

    public long calculateDiskSpace(int directoryId) throws SQLException {
        String sql = "SELECT SUM(size) FROM file WHERE parent_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, directoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getLong(1);
                }
            }
        }
        return 0;
    }

    public List<String> findFilesByMask(String mask) throws SQLException {
        List<String> matchingFiles = new ArrayList<>();
        String sql = "SELECT parent_id, name FROM file WHERE name LIKE ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, mask);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String fileName = resultSet.getString("name");
                    int parentId = resultSet.getInt("parent_id");
                    String fullPath = buildFullPath(parentId) + "/" + fileName;
                    matchingFiles.add(fullPath);
                }
            }
        }
        return matchingFiles;
    }

    public void moveFilesAndDirectories(int sourceDirectoryId, int targetDirectoryId) throws SQLException {
        String updateSql = "UPDATE file SET parent_id = ? WHERE parent_id = ?";
        try (PreparedStatement updateStatement = connection.prepareStatement(updateSql)) {
            updateStatement.setInt(1, targetDirectoryId);
            updateStatement.setInt(2, sourceDirectoryId);
            updateStatement.executeUpdate();
        }

        String updateDirsSql = "UPDATE directory SET parent_id = ? WHERE parent_id = ?";
        try (PreparedStatement updateDirsStatement = connection.prepareStatement(updateDirsSql)) {
            updateDirsStatement.setInt(1, targetDirectoryId);
            updateDirsStatement.setInt(2, sourceDirectoryId);
            updateDirsStatement.executeUpdate();
        }
    }

    public void deleteDirectory(int directoryId) throws SQLException {
        String deleteFilesSql = "DELETE FROM file WHERE parent_id = ?";
        try (PreparedStatement deleteFilesStatement = connection.prepareStatement(deleteFilesSql)) {
            deleteFilesStatement.setInt(1, directoryId);
            deleteFilesStatement.executeUpdate();
        }

        String deleteDirsSql = "DELETE FROM directory WHERE id = ?";
        try (PreparedStatement deleteDirsStatement = connection.prepareStatement(deleteDirsSql)) {
            deleteDirsStatement.setInt(1, directoryId);
            deleteDirsStatement.executeUpdate();
        }
    }


    public void close() throws SQLException {
        connection.close();
    }
}
