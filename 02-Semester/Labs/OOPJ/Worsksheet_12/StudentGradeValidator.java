import java.util.Scanner;

class GradeValidator {
    public char calculateGrade(int marks) throws Exception {
        if (marks < 0 || marks > 100) {
            throw new Exception("Invalid marks entered");
        }
        if (marks >= 90) {
            return 'A';
        }
        if (marks >= 75) {
            return 'B';
        }
        if (marks >= 50) {
            return 'C';
        }
        return 'F';
    }
}

public class StudentGradeValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeValidator validator = new GradeValidator();

        while (scanner.hasNextInt()) {
            int marks = scanner.nextInt();
            try {
                System.out.println(validator.calculateGrade(marks));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
