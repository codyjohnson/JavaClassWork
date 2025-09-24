package Sep_11_2025;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // ------------------------------------------- Writing to file ------------------------------------------- //

        try {
            FileWriter myWriter = new FileWriter("/Users/c2473383/ACC/ACCIntelliJProjects/JavaClassPractice/JavaClassWork/src/main/java/Sep_11_2025/filename.txt");
            myWriter.write("Writing text to my file, and then saving it to the file.\n\n\n");
            myWriter.write("Another line.");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        File myObj = new File("/Users/c2473383/ACC/ACCIntelliJProjects/JavaClassPractice/JavaClassWork/src/main/java/Sep_11_2025/filename.txt");

        // ------------------------------------------- Reading file ------------------------------------------- //

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        Company company = new Company("ACC");
        Main.employeeAdder(company.getEmployees());
        company.incrementNumOfEmployees();
        company.incrementNumOfEmployees();
        company.incrementNumOfEmployees();
        company.incrementNumOfEmployees();


        System.out.println("Entire Company");
        System.out.println(company);
        System.out.println("\n\n");

        company.addEmployee(new FullTime("John","00213",65465465L,5445545,42));

        System.out.println("Entire Company with john added");
        System.out.println(company);
        System.out.println("\n\n");

        company.removeEmployee("John");

        System.out.println("Entire Company with john removed");
        System.out.println(company);
        System.out.println("\n\n");

        System.out.println("Report of all Hourly Employees");
        System.out.println(company.getEmployeesByType("Hourly"));
        System.out.println("\n\n");

        System.out.println("Report of all Employees earning over 1000 dollars");
        System.out.println(company.getEmployeesByEarnings(1000));
        System.out.println("\n\n");

        System.out.println("John added back to the company");
        company.addEmployee(new FullTime("John","00213",65465465L,5445545,42));
        System.out.println("\n\n");

        System.out.println("Find Johns by ID: 65465465L");
        System.out.println(company.findEmployeeById(65465465L));
        System.out.println("\n\n");

        System.out.println("Return list of employees between ages 30 and 50.");
        System.out.println(company.getEmployeesByAgeRange(30,50));
        System.out.println("\n\n");

        System.out.println("Report of all hourly Employees earning over 100 dollars an hour");
        System.out.println(company.getEmployeesAboveHourlyRate(100));
        System.out.println("\n\n");

        System.out.println("Number of employees in the company.");
        System.out.println(company.getNumberOfEmployees());
        System.out.println("\n\n");

        System.out.println("Writing Company to file");
        company.writeCompanyToFile();
        System.out.println("\n\n");

        System.out.println("Reading company from file");
        System.out.println(company.readCompanyFromFile());
        System.out.println("\n\n");

        System.out.println("Creating new company from file");
        company.importCompany(company.readCompanyFromFile());
        System.out.println(company);
        System.out.println("\n\n");

        System.out.println("Number of employees in the company.");
        System.out.println(company.getNumberOfEmployees());
        System.out.println("\n\n");



    }

    public static void employeeAdder(ArrayList<Employee> employees) {

        Employee employee01 = new FullTime("Jack", "1223",102948L,4544,32);
        Employee employee02 = new Salaried("Jill", "1223",102948L,454,56465,52);
        Employee employee03 = new Hourly("Mark","454",5554654L,4654654,45,46644,41);
        Employee employee04 = new PartTime("Bob", "2312", 213123123L, 213123, 32,47);

        employees.add(employee01);
        employees.add(employee02);
        employees.add(employee03);
        employees.add(employee04);
    };
}
