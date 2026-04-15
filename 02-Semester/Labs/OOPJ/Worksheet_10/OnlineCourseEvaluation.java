interface Course {
    int PASS_MARK = 50;

    void enrollStudent(String studentName, int marks);

    String calculateGrade(int marks);
}

class ProgrammingCourse implements Course {
    @Override
    public void enrollStudent(String studentName, int marks) {
        System.out.println(studentName + " enrolled in Programming Course. Grade: " + calculateGrade(marks));
    }

    @Override
    public String calculateGrade(int marks) {
        if (marks >= 85) {
            return "A";
        }
        if (marks >= 70) {
            return "B";
        }
        if (marks >= PASS_MARK) {
            return "C";
        }
        return "F";
    }
}

class MathCourse implements Course {
    @Override
    public void enrollStudent(String studentName, int marks) {
        System.out.println(studentName + " enrolled in Math Course. Grade: " + calculateGrade(marks));
    }

    @Override
    public String calculateGrade(int marks) {
        if (marks >= 90) {
            return "A";
        }
        if (marks >= 75) {
            return "B";
        }
        if (marks >= PASS_MARK) {
            return "C";
        }
        return "F";
    }
}

public class OnlineCourseEvaluation {
    public static void main(String[] args) {
        Course programming = new ProgrammingCourse();
        Course math = new MathCourse();

        programming.enrollStudent("Arun", 82);
        math.enrollStudent("Devi", 67);
        programming.enrollStudent("Nila", 45);
    }
}
