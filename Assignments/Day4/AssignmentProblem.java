// package Assignments.Day4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AssignmentProblem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Jonathan", "Dabre", LocalDate.of(2003, 8, 1), 51000, "IT"));
        employees.add(new Employee("Simona", "Rumao", LocalDate.of(2003, 12, 30), 53000, "IT"));
        employees.add(new Employee("Ayushi", "Mishra", LocalDate.of(2001, 5, 15), 100000, "IT"));
        employees.add(new Employee("Swapnil", "Mehta", LocalDate.of(1993, 5, 25), 120000, "IT"));
        employees.add(new Employee("Madhav", "Jha", LocalDate.of(2003, 5, 15), 25000, "IT"));
        employees.add(new Employee("Karan", "Rajput", LocalDate.of(2003, 3, 14), 30000, "IT"));

        Predicate<Employee> isSalaryAbove50k = emp -> emp.salary>50000;
        Consumer<Employee> printEmployeeDetails = emp -> System.out.println("Employ: " + emp.firstName +" " +emp.lastName +"\n" +"ID: " +emp.id+"\nSalary: " +emp.salary +"\n");

        List<Employee> filteredEmployees = employees.stream()
            .filter(isSalaryAbove50k)
            .toList();


        filteredEmployees.forEach(printEmployeeDetails);

        
    }
}

class Employee{
    String firstName;
    String lastName;
    int id;
    LocalDate dateOfBirth;
    int salary;
    String dept;

    static int count = 0;

    Employee(String firstName, String lastName, LocalDate dateOfBirth, int salary, String dept ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = ++count;
        this.salary = salary;
        this.dept = dept;
    }
}

class User{
    int id;
    String userName;
    String password;

    static int count = 0;


    User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}