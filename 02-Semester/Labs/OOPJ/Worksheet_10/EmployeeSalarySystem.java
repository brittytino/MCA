abstract class Employee {
    protected String name;
    protected int id;
    public static final String COMPANY_NAME = "PSG Solutions";
    protected static int employeeCount = 0;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
        employeeCount++;
    }

    public abstract double calculateSalary();

    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Company: " + COMPANY_NAME
                + ", Salary: " + calculateSalary());
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }
}

class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private final double hourlyRate;
    private final int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class EmployeeSalarySystem {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Anu", 101, 45000);
        Employee e2 = new PartTimeEmployee("Ravi", 102, 300, 80);
        Employee e3 = new FullTimeEmployee("Kavi", 103, 55000);

        e1.displayEmployee();
        e2.displayEmployee();
        e3.displayEmployee();

        System.out.println("Total employees created: " + Employee.getEmployeeCount());
    }
}
