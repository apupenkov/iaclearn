package book.chapter10.chapter_examples.archiving;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.stream.Collectors;
import java.util.zip.Deflater;

public class PackJar {
    private String jarFileName;
    public final static int BUFFER = 2_048;

    public PackJar(String jarFileName) throws FileNotFoundException {
        if (!jarFileName.endsWith(".jar")) {
            throw new FileNotFoundException(jarFileName + " incorrect archive name");
        }
        this.jarFileName = jarFileName;
    }

    public void pack(String dirName) throws FileNotFoundException {
        Path dirPath = Paths.get(dirName);
        if (Files.notExists(dirPath) || !Files.isDirectory(dirPath)) {
            throw new FileNotFoundException(dirPath + " not found");
        }
        List<Path> listFileToJar = null;
        try {
            listFileToJar = Files.walk(dirPath, 10).filter(
                    f -> !Files.isDirectory(f)).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        Path[] temp = {};
        Path[] filesToJar = listFileToJar.toArray(temp);
        // actually archiving

        try (FileOutputStream outputStream = new FileOutputStream(jarFileName);
             JarOutputStream jarOutputStream = new JarOutputStream(outputStream)) {
            byte[] buffer = new byte[BUFFER];
            jarOutputStream.setLevel(Deflater.DEFAULT_COMPRESSION);
            for (int i = 0; i < filesToJar.length; i++) {
                String file = filesToJar[i].toString();
                jarOutputStream.putNextEntry(new JarEntry(file));
                try (FileInputStream in = new FileInputStream(file)) {
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        jarOutputStream.write(buffer, 0, len);
                    }
                    jarOutputStream.closeEntry();
                } catch (FileNotFoundException e) {
                    System.err.println("File not found " + e);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Incorrect data " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
