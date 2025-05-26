// package Assignments.Day5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class AssignmentProblem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Jonathan", "Dabre", LocalDate.of(2003, 8, 1), 51000, "IT", LocalDate.of(2023, 5, 1)));
        employees.add(new Employee("Simona", "Rumao", LocalDate.of(2003, 12, 30), 53000, "IT", LocalDate.of(2023, 11, 15)));
        employees.add(new Employee("Ayushi", "Mishra", LocalDate.of(2001, 5, 15), 100000, "IT", LocalDate.of(2022, 6, 10)));
        employees.add(new Employee("Swapnil", "Mehta", LocalDate.of(1993, 5, 25), 120000, "IT", LocalDate.of(2024, 1, 20)));
        employees.add(new Employee("Madhav", "Jha", LocalDate.of(2003, 5, 15), 25000, "IT", LocalDate.of(2025, 3, 12)));
        employees.add(new Employee("Karan", "Rajput", LocalDate.of(2003, 3, 14), 30000, "IT", LocalDate.of(2022, 9, 5)));
        employees.add(new Employee("Ananya", "Sharma", LocalDate.of(2000, 2, 18), 55000, "Finance", LocalDate.of(2023, 7, 1)));
        employees.add(new Employee("Ankit", "Sharma", LocalDate.of(1998, 10, 5), 75000, "HR", LocalDate.of(2022, 4, 18)));
        employees.add(new Employee("Rohit", "Verma", LocalDate.of(1996, 5, 5), 80000, "HR", LocalDate.of(2022, 6, 18)));
        employees.add(new Employee("Priya", "Singh", LocalDate.of(2002, 6, 22), 62000, "Finance", LocalDate.of(2024, 2, 9)));
        employees.add(new Employee("Arjun", "Yadav", LocalDate.of(1995, 11, 3), 80000, "Finance", LocalDate.of(2025, 1, 1)));
        employees.add(new Employee("Meera", "Patel", LocalDate.of(1999, 9, 30), 70000, "IT", LocalDate.of(2023, 8, 21)));
        employees.add(new Employee("Axar", "Patel", LocalDate.of(1999, 3, 20), 70000, "HR", LocalDate.of(2023, 3, 21)));


        // First Name of employees which joined in year 2023
        List<String> joinedIn2023 = employees.stream()
            .filter(e-> e.dateOfJoining.getYear() == 2023)
            .map(e->e.firstName)
            .toList();
        System.out.println("Employees Joined in 2023" + joinedIn2023);

        Long countOfIT = employees.stream()
            .filter(e -> e.dept == "IT")
            .count();
        System.out.println("Number of employees in IT Department: " +countOfIT);

        Integer minSalary = employees.stream()
            .filter(e -> e.dept == "IT")
            .map(e->e.salary)
            .min((a,b)->(a-b))
            .get();
        System.out.println("Minimum Salary: " +minSalary);

        Integer maxSalary = employees.stream()
            .filter(e -> e.dept == "IT")
            .map(e->e.salary)
            .min((a,b)->(b-a))
            .get();
        System.out.println("Max Salary: " +maxSalary);

        Double avgSalary = employees.stream()
            .filter(e->e.dept.equals("IT"))
            .mapToInt(e->e.salary)
            .average()
            .orElse(0);
        System.out.println("Average Salary: " + avgSalary);

        List<Employee> sortedExceptHRs = employees.stream()
            .filter(e -> !e.dept.equals("HR"))
            .sorted((a, b)->(a.firstName.compareTo(b.firstName)))
            .toList();
        System.out.println(sortedExceptHRs);

        List<String> fNameSortByDOB = employees.stream()
            .sorted((a, b)->(a.dateOfBirth.compareTo(b.dateOfBirth)))
            .map(e->e.firstName)
            .toList();
        System.out.println("First Name ordered by DOB: " +fNameSortByDOB);

        Stream<Integer> oddNumbers = Stream.iterate(100, n->n+1 ).limit(100)
            .filter(n->n%2==1);
        
        oddNumbers.forEach(System.out::println);

        Consumer<Employee> printEmployeeDetails = emp -> System.out.println("Employee: " + emp.firstName + " " + emp.lastName + "\nID: " + emp.id + "\nSalary: " + emp.salary + "\nDepartment: " +emp.dept);
        employees.forEach(printEmployeeDetails);

        Consumer<Employee> incrementSalary = emp -> emp.salary=(int) (emp.salary*0.1)+emp.salary;
        employees.stream()
            .filter(e->e.dept.equals("IT"))
            .forEach(incrementSalary);

        employees.forEach(printEmployeeDetails);
        
    }   
}


class Employee{
    String firstName;
    String lastName;
    int id;
    LocalDate dateOfBirth;
    int salary;
    String dept;
    LocalDate dateOfJoining;

    static int count = 0;

    Employee(String firstName, String lastName, LocalDate dateOfBirth, int salary, String dept, LocalDate dateOfJoining ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.id = ++count;
        this.salary = salary;
        this.dept = dept;
        this.dateOfJoining = dateOfJoining;
    }
}