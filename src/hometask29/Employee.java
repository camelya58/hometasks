package hometask29;
import java.util.ArrayList;
import java.util.function.*;

public class Employee {
    String name;
    String department;
    double salary;

    Employee(String name, String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

}
class TestEmployee{
    void printEmployee(Employee e){
        System.out.println("Employee " + e.name + " from "  + e.department  +" department has salary " + e.salary + " .");
    }
    void employeesFilter(ArrayList<Employee> aL, Predicate<Employee> t){
        for (Employee e: aL){
            if (t.test(e)){
                printEmployee(e);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee("Ivan", "IT", 300.00));
        list.add(new Employee("Olga", "sales", 250.00));
        list.add(new Employee("Igor", "sales", 200.00));
        list.add(new Employee("Maria", "HR", 300.00));
        list.add(new Employee("Elena", "IT", 400.00));

        TestEmployee test = new TestEmployee();
        test.employeesFilter(list, x -> x.department.equals("IT") && x.salary > 200.00);
        System.out.println("________________________________");
        test.employeesFilter(list, x-> x.name.startsWith("E") && x.salary != 450.00);
        System.out.println("________________________________");
        test.employeesFilter(list, x-> x.name.equals(x.department));
    }
}
