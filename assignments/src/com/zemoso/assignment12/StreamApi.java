package com.zemoso.assignment12;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class StreamApi {

    public static void main(String[] args) {
        List<Student> list = studentListInit();
        getDistinctDepartments(list);
        getStudentsEnrolledAfter2018(list);
        getMaleStudentsInCSDept(list);
        getNumberOfMalesAndFemales(list);
        getAverageAgeOfMaleAndFemale(list);
        getStudentWithHighestPercentage(list);
        getNumberOfStudentsInEachDept(list);
        getAveragePercentageEachDepartment(list);
        getYoungestMaleInElectronicDept(list);
        getMaleAndFemaleCountInCSDepartment(list);
    }

    private static List<Student> studentListInit() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        list.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        list.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        list.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        list.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        list.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        list.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        list.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        list.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        list.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        list.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        list.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        list.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        list.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        list.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        list.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        list.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));
        return list;
    }

    private static void getDistinctDepartments(List<Student> list) {
        System.out.println("\n1. Get all distinct Departments");
        List<String> distinctDepartments = list.stream()
                .map(dept -> dept.engDepartment)
                .distinct()
                .collect(toList());
        distinctDepartments.forEach(System.out::println);
    }

    private static void getStudentsEnrolledAfter2018(List<Student> list) {
        System.out.println("\n2. Students who enrolled after 2018");
        List<Student> enrolledAfter2018 = list.stream()
                .filter(student -> student.year_of_enrollment > 2018)
                .collect(toList());
        enrolledAfter2018.forEach(System.out::println);
    }

    private static void getMaleStudentsInCSDept(List<Student> list) {
        System.out.println("\n3. All Male Students in CS Department");
        List<Student> maleStudentsInCSDept = list.stream()
                .filter(student -> student.engDepartment.equals("Computer Science"))
                .filter(student -> student.gender.equals("Male"))
                .collect(toList());
        maleStudentsInCSDept.forEach(System.out::println);
    }

    private static void getNumberOfMalesAndFemales(List<Student> list) {
        System.out.println("\n4. Number of male and female student");
        Map<Object, Long> numberOfMaleAndFemaleStudents = list
                .stream()
                .collect(Collectors.groupingBy(student -> student.gender,
                        Collectors.counting()));
        numberOfMaleAndFemaleStudents.forEach((gender, count) -> System.out.println(gender + "\t" + count));
    }

    private static void getAverageAgeOfMaleAndFemale(List<Student> list) {
        System.out.println("\n5. Average age of male and female students");
        Map<Object, Double> averageAgeOfMaleAndFemale = list
                .stream()
                .collect(Collectors.groupingBy(student -> student.gender,
                        Collectors.averagingInt(student->student.age)));

        averageAgeOfMaleAndFemale.forEach((gender, average) -> System.out.println(gender + "\t" + average));
    }

    private static void getStudentWithHighestPercentage(List<Student> list) {
        System.out.println("\n6. Student with highest percentage");
        list.stream()
                .max(Comparator.comparing(student -> student.perTillDate))
                .ifPresent(System.out::println);
    }

    private static void getNumberOfStudentsInEachDept(List<Student> list) {
        System.out.println("\n7. Number of students in each department");
        Map<String, Long> numberOfStudentsInEachDept = list.stream()
                .collect(Collectors.groupingBy(student -> student.engDepartment,
                        Collectors.counting()));
        numberOfStudentsInEachDept.forEach((dept, count) -> System.out.println(dept + "\t" + count));
    }

    private static void getAveragePercentageEachDepartment(List<Student> list) {
        System.out.println("\n8. Average percentage in each department");
        Map<Object, Double> averagePercentageEachDepartment = list
                .stream()
                .collect(Collectors.groupingBy(student -> student.engDepartment,
                        Collectors.averagingDouble(student->student.perTillDate)));

        averagePercentageEachDepartment.forEach(
                (department, average) -> System.out.println(department + "\t" + average)
        );
    }

    private static void getYoungestMaleInElectronicDept(List<Student> list) {
        System.out.println("\n9. Youngest male in Electronics department");
        list.stream()
                .filter(student -> student.engDepartment.equals("Electronic"))
                .filter(student -> student.gender.equals("Male"))
                .min(Comparator.comparing(student -> student.age))
                .ifPresent(System.out::println);
    }

    private static void getMaleAndFemaleCountInCSDepartment(List<Student> list) {
        System.out.println("\n10. Number of male and female students in CSE");
        Map<Object, Long> numberOfMaleAndFemaleStudents = list
                .stream()
                .filter(student ->student.engDepartment.equals("Computer Science"))
                .collect(Collectors.groupingBy(student -> student.gender,
                        Collectors.counting()));
        numberOfMaleAndFemaleStudents.forEach((gender, count) -> System.out.println(gender + "\t" + count));
    }

}