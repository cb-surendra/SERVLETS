import java.util.Scanner;

public class StudentDemo {
    /*Create an instance of the class Student. Pass the Student object to storeStudentData method to fill it with values.
    Call the generateResult method to print the report card.
     */

    /*Take the Student object as input parameter and fill it with the necessary data using set methods.*/

    public void storeStudentData(Student s){

        Scanner sc = new Scanner(System.in);
        //scan student Id
        System.out.println("Enter Sudent Id");
        int id;
        id = sc.nextInt();
        s.setStudentId(id);

        System.out.println("Enter Sudent Name");
        //scan student name
        String name;
        name = sc.next();
        s.setStudentName(name);

        System.out.println("Enter Sudent gender y->male | n -> female");
        //scan gender
        boolean gender;
        gender = sc.nextBoolean();
        s.setGender(gender);

        //scan the marks and subject name

        //scan subject1, subject2, subject3
        Subject s1 = new Subject();
        String sub1, sub2, sub3;
        float marks1, marks2, marks3;

        System.out.println("Enter subject1 name and marks");
        sub1 = sc.next();
        marks1 = sc.nextFloat();
        s1.setSubject1(sub1);
        s1.setMarks1(marks1);

        System.out.println("Enter subject2 name and marks");
        sub2 = sc.next();
        marks2 = sc.nextFloat();
        s1.setSubject2(sub2);
        s1.setMarks2(marks2);

        System.out.println("Enter subject3 name and marks");
        sub3 = sc.next();
        marks3 = sc.nextFloat();
        s1.setSubject3(sub3);
        s1.setMarks3(marks3);

        s.setSubjects(s1);

        ResultGenerator rg = new ResultGenerator();
        rg.generateResult(s);
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        StudentDemo s = new StudentDemo();
        Student s1 = new Student();
        s.storeStudentData(s1);
    }
}
