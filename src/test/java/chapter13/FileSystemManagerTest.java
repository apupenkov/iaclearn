package chapter13;

import book.chapter13.tasks.filesystem.FileSystemManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemManagerTest {
    private FileSystemManager fileSystemManager;

    @BeforeEach
    void setUp() throws Exception {
        fileSystemManager = new FileSystemManager();
    }

    @AfterEach
    void tearDown() throws Exception {
        fileSystemManager.close();
    }

    @Test
    void testGetFullPath() {
        assertDoesNotThrow(() -> {
            String fullPath = fileSystemManager.getFullPath(1);
            assertEquals("/root/directory1/directory2/file.txt", fullPath);
        });

        assertDoesNotThrow(() -> {
            String fullPath = fileSystemManager.getFullPath(2);
            assertEquals("/root/directory1/file2.txt", fullPath);
        });

        assertDoesNotThrow(() -> {
            String fullPath = fileSystemManager.getFullPath(3);
            assertEquals("/root/file3.txt", fullPath);
        });
    }

    @Test
    void testGetFullPathInvalidId() {
        assertDoesNotThrow(() -> {
            String fullPath = fileSystemManager.getFullPath(1000);
            assertNull(fullPath);
        });
    }

    @Test
    void testCountFilesInDirectory() {
        assertDoesNotThrow(() -> {
            int fileCount = fileSystemManager.countFilesInDirectory(1);
            assertEquals(2, fileCount);
        });

        assertDoesNotThrow(() -> {
            int fileCount = fileSystemManager.countFilesInDirectory(2);
            assertEquals(1, fileCount);
        });

        assertDoesNotThrow(() -> {
            int fileCount = fileSystemManager.countFilesInDirectory(3);
            assertEquals(1, fileCount);
        });
    }

    @Test
    void testCountFilesInEmptyDirectory() {
        assertDoesNotThrow(() -> {
            int fileCount = fileSystemManager.countFilesInDirectory(4);
            assertEquals(0, fileCount);
        });
    }

    @Test
    void testCalculateDiskSpace() {
        assertDoesNotThrow(() -> {
            long diskSpace = fileSystemManager.calculateDiskSpace(1);
            assertEquals(300, diskSpace);
        });

        assertDoesNotThrow(() -> {
            long diskSpace = fileSystemManager.calculateDiskSpace(2);
            assertEquals(150, diskSpace);
        });

        assertDoesNotThrow(() -> {
            long diskSpace = fileSystemManager.calculateDiskSpace(3);
            assertEquals(200, diskSpace);
        });
    }

    @Test
    void testCalculateDiskSpaceEmptyDirectory() {
        assertDoesNotThrow(() -> {
            long diskSpace = fileSystemManager.calculateDiskSpace(4);
            assertEquals(0, diskSpace);
        });
    }

    @Test
    void testFindFilesByMask() {
        assertDoesNotThrow(() -> {
            List<String> matchingFiles = fileSystemManager.findFilesByMask("*.txt");
            assertEquals(3, matchingFiles.size());
            assertTrue(matchingFiles.contains("/root/directory1/directory2/file.txt"));
            assertTrue(matchingFiles.contains("/root/directory1/file2.txt"));
            assertTrue(matchingFiles.contains("/root/file3.txt"));
        });

        assertDoesNotThrow(() -> {
            List<String> matchingFiles = fileSystemManager.findFilesByMask("file?.txt");
            assertEquals(2, matchingFiles.size());
            assertTrue(matchingFiles.contains("/root/directory1/file2.txt"));
            assertTrue(matchingFiles.contains("/root/file3.txt"));
        });

        assertDoesNotThrow(() -> {
            List<String> matchingFiles = fileSystemManager.findFilesByMask("file?.doc");
            assertEquals(0, matchingFiles.size());
        });
    }

//    @Test
//    void testMoveFilesAndDirectories() {
//    }

//    @Test
//    void testDeleteDirectory() {
//    }
}
