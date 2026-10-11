import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int total_Marks = 0;
        int count_Marks = 0;
        int marks = 0;
        int subjects = 0;

        boolean valid1 = false;

        // Get the number of subjects
        while (!valid1) {
            try {
                System.out.print("Number of Subjects: ");
                subjects = scan.nextInt();

                if (subjects > 0) {
                    valid1 = true;
                } else {
                    System.out.println("Enter a valid subject count.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid value. Enter a number.");
                scan.nextLine();
            }
        }

        // Create an array to store marks
        int[] marksArray = new int[subjects];

        // Get and validate marks
        for (int i = 0; i < subjects; i++) {

            boolean valid = false;

            while (!valid) {
                try {
                    System.out.print("Enter marks for Subject " + (i + 1) + ": ");
                    marks = scan.nextInt();

                    if (marks > 100 || marks < 0) {
                        System.out.println("Enter marks between 0 and 100.");
                    } else {
                        marksArray[i] = marks;
                        valid = true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Enter a number.");
                    scan.nextLine();
                }
            }

            count_Marks++;
        }

        // Calculate total marks using the array
        total_Marks = 0;

        for (int i = 0; i < marksArray.length; i++) {
            total_Marks = total_Marks + marksArray[i];
        }

        // Calculate average percentage
        double average_percentage = (double) total_Marks / count_Marks;

        // Determine grade
        String grade;

        if (average_percentage >= 90) {
            grade = "Grade A";
        } else if (average_percentage >= 80) {
            grade = "Grade B";
        } else if (average_percentage >= 70) {
            grade = "Grade C";
        } else {
            grade = "Fail";
        }

        // Determine pass or fail
        String result;

        if (average_percentage >= 40) {
            result = "Pass";
        } else {
            result = "Fail";
        }

        // Display individual subject marks
        System.out.println("\n--- Subject Marks ---");

        for (int i = 0; i < marksArray.length; i++) {
            System.out.println("Subject " + (i + 1) + ": " + marksArray[i]);
        }

        // Display final results
        System.out.println("\n--- Student Results ---");
        System.out.println("Total Marks: " + total_Marks);
        System.out.println("Average Percentage: " + average_percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Result: " + result);

        scan.close();
    }
}