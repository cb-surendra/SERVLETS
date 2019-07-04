public class ResultGenerator {
    /*Takes the Student object as input parameter and prints the report card by calculating the  total and average marks.*/
    public static void generateResult(Student s){

        Subject s1;
        System.out.println("Student Id : " + s.getStudentId());
        System.out.println("Student Name : " + s.getStudentName());
        System.out.println("Student gender : " + (s.isGender() == true ? "Male" : "Female") );
        System.out.println("Report Card :");
        System.out.println("Subject and Marks");
        System.out.println(s.subjects.subject1 + "-" + s.subjects.marks1);
        System.out.println(s.subjects.subject2 + "-" + s.subjects.marks2);
        System.out.println(s.subjects.subject3 + "-" + s.subjects.marks3);

        System.out.println("Total Marks scored = " + (s.subjects.marks3 + s.subjects.marks2 + s.subjects.marks1));
        System.out.println("Average Marks scored = " + (s.subjects.marks3 + s.subjects.marks2 + s.subjects.marks1)/3);

    }
}
