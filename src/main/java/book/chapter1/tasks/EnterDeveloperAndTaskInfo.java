package book.chapter1.tasks;

import java.util.Scanner;

public class EnterDeveloperAndTaskInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter developer surname:");
        String surname = scanner.next();
        System.out.println("Enter the date the assignment was received:");
        String date = scanner.next();
        System.out.println("Enter the time the assignment was received:");
        String time = scanner.next();
        System.out.println("Enter the due date for the assignment:");
        String dueDate = scanner.next();
        System.out.println("Enter the due time for the assignment:");
        String dueTime = scanner.next();
        System.out.printf("Developer: %s.\nDate and time the task was received: %s %s.\n" +
                "Date and time of submission of the task: %s, %s", surname, date, time, dueDate, dueTime);
    }
}
