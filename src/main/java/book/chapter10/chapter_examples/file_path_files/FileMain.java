package book.chapter10.chapter_examples.file_path_files;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

public class FileMain {
    public static void main(String[] args) {
        File file = new File("data" + File.separator + "info.txt");
        if (file.exists() && file.isFile()) {
            System.out.println("Path" + file.getPath());
            System.out.println("Absolute Path " + file.getPath());
            System.out.println("Absolute Path" + file.getAbsolutePath());
            System.out.println("Size " + file.length());
            System.out.println("Dir " + file.getParent());
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            File dir = new File("data");
            if (dir.exists() && dir.isDirectory()) {
                for (File current : dir.listFiles()) {
                    long millis = current.lastModified();
                    Instant date = Instant.ofEpochMilli(millis);
                    System.out.println(current.getPath() + "\t" + current.length() + "\t" + date);
                }
                File root = File.listRoots()[0];
                System.out.printf("\n%s %,d free bytes", root.getPath(), root.getUsableSpace(), root.getTotalSpace());
            }
        }
    }
}
