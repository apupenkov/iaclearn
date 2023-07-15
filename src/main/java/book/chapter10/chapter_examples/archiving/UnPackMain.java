package book.chapter10.chapter_examples.archiving;

public class UnPackMain {
    public static void main(String[] args) {
        String nameJar = "example.jar";
        String destinationPath = "c:/temp";
        new UnPackJar().unpack(destinationPath, nameJar);
    }
}
