// package Assignments.Day4;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AssignmentProblem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<User> users = new ArrayList<>();

        employees.add(new Employee("Jonathan", "Dabre", LocalDate.of(2003, 8, 1), 51000, "IT"));
        employees.add(new Employee("Simona", "Rumao", LocalDate.of(2003, 12, 30), 53000, "IT"));
        employees.add(new Employee("Ayushi", "Mishra", LocalDate.of(2001, 5, 15), 100000, "IT"));
        employees.add(new Employee("Swapnil", "Mehta", LocalDate.of(1993, 5, 25), 120000, "IT"));
        employees.add(new Employee("Madhav", "Jha", LocalDate.of(2003, 5, 15), 25000, "IT"));
        employees.add(new Employee("Karan", "Rajput", LocalDate.of(2003, 3, 14), 30000, "IT"));

        Predicate<Employee> isSalaryAbove50k = emp -> emp.salary > 50000;
        Consumer<Employee> printEmployeeDetails = emp -> System.out.println("Employee: " + emp.firstName + " " + emp.lastName + "\nID: " + emp.id + "\nSalary: " + emp.salary + "\n");
        Consumer<User> printUserDetails = user-> System.out.println("\nUser: " +user.id +"\nUsername: " +user.userName +"\nPassword: " +user.password);

        List<Employee> filteredEmployees = employees.stream()
            .filter(isSalaryAbove50k)
            .toList();

        System.out.println("List of Filtered Employees");
        filteredEmployees.forEach(printEmployeeDetails);
        System.out.println("----------------------------");

        List<Employee> employeesSortByMonth = employees.stream()
            .sorted((e1, e2)-> Integer.compare(e1.dateOfBirth.getMonthValue(), e2.dateOfBirth.getMonthValue()))
            .toList();
        
        System.out.println("List of Sorted Employees by Birth Month");
        employeesSortByMonth.forEach(printEmployeeDetails);
        System.out.println("----------------------------");

        Supplier<String> passwordGenerator = () -> {
            String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:,.<>?";
            int length = characterSet.length();
            StringBuilder password = new StringBuilder();
            SecureRandom random = new SecureRandom();

            for (int i = 0; i < 16; i++) {
                int j = random.nextInt(length);
                password.append(characterSet.charAt(j));
            }
            return password.toString(); 
        };

        UserNameGenerator ug = (firstName, lastName, dateOfBirth, id) -> firstName + lastName + dateOfBirth.getYear() + id;

        for (Employee employee : employees) {
            users.add(generateUserFromEmployee(employee, ug, passwordGenerator));
        }

        Runnable printEmployList = ()->  employees.forEach(printEmployeeDetails);
        Runnable printUserList = () -> users.forEach(printUserDetails);

        Thread t1 = new Thread(printEmployList);
        Thread t2 = new Thread(printUserList);

        t1.run();
        t2.run(); 
    }

    
    public static User generateUserFromEmployee(Employee e, UserNameGenerator ug, Supplier<String> passwordGenerator) {
        String userName = ug.generate(e.firstName, e.lastName, e.dateOfBirth, e.id);
        String password = passwordGenerator.get();  
        return new User(userName, password);
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
        this.id = ++count;
        this.userName = userName;
        this.password = password;
    }
}

interface UserNameGenerator {
    public String generate(String firstName, String lastName, LocalDate dateOfBirth, int id);    
}