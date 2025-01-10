package org.tvd.excercise;


import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student> {

    private String fullName;
    private int age;
    private double GPA;

    @Override
    public int compareTo(Student other) {

        String thisFirstName = this.fullName.substring(this.fullName.lastIndexOf(" ") + 1);
        String otherFirstName = other.fullName.substring(other.fullName.lastIndexOf(" ") + 1);

        int compareByFirstName = thisFirstName.compareTo(otherFirstName);
        if (compareByFirstName != 0) {
            return compareByFirstName;
        }

        int compareByAge = -Integer.compare(other.age, this.age);
        if (compareByAge != 0) {
            return compareByAge;
        }

        return Double.compare(this.GPA, other.GPA);
    }

    public static void main(String[] args) {

        Student student1 = new Student("Nguyen Van A", 18, 7.2);
        Student student2 = new Student("Bui Van N", 20, 8.6);
        Student student3 = new Student("Tran Van A", 19, 8.0);
        Student student4 = new Student("Pham Thi G", 20, 9.0);

        Student[] students = {student1, student2, student3, student4};
        System.out.println("Trước khi sắp xếp");
        Arrays.stream(students).forEach(System.out::println);

        System.out.println("\nSau khi sắp xếp");
        Arrays.sort(students);
        Arrays.stream(students).forEach(System.out::println);
    }
}
