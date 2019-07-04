import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        System.out.println("Enter Name");
        Scanner sc = new Scanner(System.in);
        String name;
        name = sc.next();

        System.out.println("Enter gender");
        String gender;
        gender = sc.next();

        System.out.println("Eneter Taxable Income : ");
        float taxableIncome;
        taxableIncome = sc.nextFloat();

        IncomeTax i = new IncomeTax(taxableIncome);

        Employee e = new Employee(name, gender, i);

        System.out.print("Employee Name : " + e.name + " " + ", Gender : " + e.gender+ ", TaxableIncome : " + e.i.taxableIncome + "lacs, taxAmount ");
        if( gender.equals("Male")){
            System.out.println(e.i.taxForMaleEmployee() + "lacs");
        }
        else{
            System.out.println(e.i.taxForFemaleEmplpyee() + "lacs");
        }
    }
}
