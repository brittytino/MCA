package WorkSheet_7;

class Employee{
    int id;
    String name;
    double basic;

    Employee(int i, String n , double b){
        this.id = i;
        this.name = n;
        this.basic = b;
    }

    private double CalculateSalary(){
        return (this.basic * 0.10) + this.basic;
    }

    void displayDetails(){
        System.out.println("ID: "+ this.id + " Name: " + this.name + " Salary: " + CalculateSalary());
    }
}
public class EmployeeSalary {
    public static void main(String[] args) {
        Employee e1 = new Employee(101,"Tino",123000);
        Employee e2 = new Employee(102,"Allan",250462);
        Employee e3 = new Employee(103,"Johhnny",458752);

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
