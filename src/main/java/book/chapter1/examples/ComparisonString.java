package book.chapter1.examples;

public class ComparisonString {
    public static void main(String[] args) {
        String str1, str2, str3;
        str1 = "Java";
        str3 = "Java";
        str2 = str1;
        System.out.println("comparison of references " + (str1 == str2));
        System.out.println("comparison of references " + (str1 == str3));
        str2 = new String("Java");
        System.out.println("comparison of references " + (str1 == str2));
        System.out.println("comparison fo values " + str1.equals(str2));
    }
}
