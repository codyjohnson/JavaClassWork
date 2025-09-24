package Sep_11_2025;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Company {

    private String name;
    private ArrayList<Employee> employees;
    private int numberOfEmployees = 0;

    public Company importCompany(String companyString) {

        this.employees.clear();
        numberOfEmployees = 0;
        String target = "";
        String theRest = companyString;

        target = theRest.substring(theRest.indexOf("'") + 1, theRest.lastIndexOf("[") - 1);
        this.setName(target);
        theRest = theRest.substring(theRest.lastIndexOf("[") + 1, theRest.lastIndexOf("]") - 1);

        String[] entries = theRest.split(",\\s*");

        for (String entry : entries) {
            String[] strArr = entry.trim().split(" ");

            switch (strArr[0]) {

                case "FT":
                    FullTime fullTimeEmp = new FullTime();
                    fullTimeEmp.setBenefit_amount(Double.parseDouble(strArr[1]));
                    fullTimeEmp.setName(strArr[3]);
                    fullTimeEmp.setAge(Integer.parseInt(strArr[4]));
                    fullTimeEmp.setAddress(strArr[5]);
                    fullTimeEmp.setId(Long.parseLong(strArr[6]));
                    this.employees.add(fullTimeEmp);
                    numberOfEmployees++;
                    break;

                case "SAL":
                    Salaried salEmp = new Salaried();
                    salEmp.setSalary(Double.parseDouble(strArr[1]));
                    salEmp.setBenefit_amount(Double.parseDouble(strArr[3]));
                    salEmp.setName(strArr[5]);
                    salEmp.setAge(Integer.parseInt(strArr[6]));
                    salEmp.setAddress(strArr[7]);
                    salEmp.setId(Long.parseLong(strArr[8]));
                    this.employees.add(salEmp);
                    numberOfEmployees++;
                    break;

                case "HRLY":
                    Hourly hourEmp = new Hourly();
                    hourEmp.setHours(Double.parseDouble(strArr[1]));
                    hourEmp.setHourlyRate(Double.parseDouble(strArr[2]));
                    hourEmp.setBenefit_amount(Double.parseDouble(strArr[4]));
                    hourEmp.setName(strArr[6]);
                    hourEmp.setAge(Integer.parseInt(strArr[7]));
                    hourEmp.setAddress(strArr[8]);
                    hourEmp.setId(Long.parseLong(strArr[9]));
                    this.employees.add(hourEmp);
                    numberOfEmployees++;
                    break;

                case "PT":
                    PartTime partTimeEmp = new PartTime();
                    partTimeEmp.setHours(Double.parseDouble(strArr[1]));
                    partTimeEmp.setHourlyRate(Double.parseDouble(strArr[2]));
                    partTimeEmp.setName(strArr[4]);
                    partTimeEmp.setAge(Integer.parseInt(strArr[5]));
                    partTimeEmp.setAddress(strArr[6]);
                    partTimeEmp.setId(Long.parseLong(strArr[7]));
                    this.employees.add(partTimeEmp);
                    numberOfEmployees++;
                    break;
            }
        }
        return this;
    }

    public Company(String name) {
        this.employees = new ArrayList<Employee>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
        for (int i = 0; i < employees.size(); i++) {
            numberOfEmployees++;
        }
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
        numberOfEmployees++;
    }

    public void removeEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                employees.remove(i);
                numberOfEmployees--;
            }
        }
    }

    public ArrayList<Employee> getEmployeesByType(String type) {

        ArrayList<Employee> result = new ArrayList<>();

        switch (type) {
            case "Employee" -> {
                for (Employee employee : employees) {
                    if (employee.getClass().equals(Employee.class)) {
                        result.add(employee);
                    }
                }
            }
            case "FullTime" -> {
                for (Employee employee : employees) {
                    if (employee.getClass().equals(FullTime.class)) {
                        result.add(employee);
                    }
                }
            }
            case "Salaried" -> {
                for (Employee employee : employees) {
                    if (employee.getClass().equals(Salaried.class)) {
                        result.add(employee);
                    }
                }
            }
            case "Hourly" -> {
                for (Employee employee : employees) {
                    if (employee.getClass().equals(Hourly.class)) {
                        result.add(employee);
                    }
                }
            }
            case "PartTime" -> {
                for (Employee employee : employees) {
                    if (employee.getClass().equals(PartTime.class)) {
                        result.add(employee);
                    }
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
        ;

        return result;
    }

    public ArrayList<Employee> getEmployeesByEarnings(double money) {

        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getClass().equals(Salaried.class)) {
                if (((Salaried) employee).getSalary() >= money) {
                    result.add(employee);
                }
            } else if (employee.getClass().equals(Hourly.class)) {
                if (((Hourly) employee).getHourlyRate() * ((Hourly) employee).getHours() >= money) {
                    result.add(employee);
                }
            } else if (employee.getClass().equals(PartTime.class)) {
                if (((PartTime) employee).getHourlyRate() * ((PartTime) employee).getHours() >= money) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    public ArrayList<Employee> getEmployeesAboveHourlyRate(double money) {

        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getClass().equals(Hourly.class)) {
                if (((Hourly) employee).getHourlyRate() >= money) {
                    result.add(employee);
                }
            } else if (employee.getClass().equals(PartTime.class)) {
                if (((PartTime) employee).getHourlyRate() >= money) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    public Employee findEmployeeById(Long id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployeesByAgeRange(int min, int max) {
        ArrayList<Employee> result = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getAge() >= min && employee.getAge() <= max) {
                result.add(employee);
            }
        }
        return result;
    }

    public void incrementNumOfEmployees() {
        numberOfEmployees++;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + "'\n" + employees;
    }

    public void writeCompanyToFile() {
        try (FileWriter myWriter = new FileWriter("/Users/c2473383/ACC/ACCIntelliJProjects/JavaClassPractice/JavaClassWork/src/main/java/Sep_11_2025/filename.txt")) {
            myWriter.write(this.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String readCompanyFromFile() {

        File myObj = new File("/Users/c2473383/ACC/ACCIntelliJProjects/JavaClassPractice/JavaClassWork/src/main/java/Sep_11_2025/filename.txt");
        String data = "";

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                data += myReader.nextLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}

