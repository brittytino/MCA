abstract class Staff {
    protected String name;
    protected String department;
    public static final String UNIVERSITY_NAME = "PSG University";

    public Staff(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public abstract double calculatePay();

    public void displayDetails() {
        System.out.println("Name: " + name + ", Department: " + department + ", University: " + UNIVERSITY_NAME);
    }
}

interface Attendance {
    void markAttendance(boolean present);
}

class Professor extends Staff implements Attendance {
    private final double monthlyPay;
    private int attendanceCount = 0;

    public Professor(String name, String department, double monthlyPay) {
        super(name, department);
        this.monthlyPay = monthlyPay;
    }

    @Override
    public double calculatePay() {
        return monthlyPay;
    }

    @Override
    public void markAttendance(boolean present) {
        if (present) {
            attendanceCount++;
        }
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }
}

class LabAssistant extends Staff implements Attendance {
    private final double dailyPay;
    private final int workingDays;
    private int attendanceCount = 0;

    public LabAssistant(String name, String department, double dailyPay, int workingDays) {
        super(name, department);
        this.dailyPay = dailyPay;
        this.workingDays = workingDays;
    }

    @Override
    public double calculatePay() {
        return dailyPay * workingDays;
    }

    @Override
    public void markAttendance(boolean present) {
        if (present) {
            attendanceCount++;
        }
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }
}

public class UniversityStaffSystem {
    public static void main(String[] args) {
        Professor prof = new Professor("Dr. Meera", "Computer Applications", 85000);
        LabAssistant assistant = new LabAssistant("Karthik", "Computer Applications", 1200, 24);

        prof.markAttendance(true);
        prof.markAttendance(true);
        assistant.markAttendance(true);

        prof.displayDetails();
        System.out.println("Professor Pay: " + prof.calculatePay());
        System.out.println("Professor Attendance Days: " + prof.getAttendanceCount());

        assistant.displayDetails();
        System.out.println("Lab Assistant Pay: " + assistant.calculatePay());
        System.out.println("Lab Assistant Attendance Days: " + assistant.getAttendanceCount());
    }
}
