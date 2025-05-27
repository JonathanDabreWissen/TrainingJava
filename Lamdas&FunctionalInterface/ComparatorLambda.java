// package Lamdas&FunctionalInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class ComparatorLambda {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(6);
        list.add(0);
        list.add(99);
        list.add(6);
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, (a, b)->(b-a));

        Set<Integer> s = new TreeSet<>();
        s.add(22);
        s.add(1);
        s.add(13);
        System.out.println("Before manual sorting: " +s);


        Set<Integer> ss = new TreeSet<>((a, b)->(b-a));
        ss.add(22);
        ss.add(1);
        ss.add(13);
        System.out.println("After manual sorting: " +ss);
        

        Student s1 = new Student(1, "Vipul");
        Student s2 = new Student(2, "Rohit");
        Student s3 = new Student(33, "Virat");

        List<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Collections.sort(studentList, (a, b)->(b.id - a.id));


        Consumer<Student> printStudentDetails = (student)-> System.out.println(student.id +" -> " +student.name);
        studentList.forEach(printStudentDetails);
    }
}

class Student{
    int id;
    String name;

    Student(int id, String name){
        this.id = id;
        this.name = name;
    }
}
