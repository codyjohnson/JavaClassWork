package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Dealership {

    private ArrayList<Vehicle> vehicles;
    private int numOfVehicles;
    private final int CAPACITY = 50;

    public Dealership() {
        this.vehicles = new ArrayList<>();
        this.numOfVehicles = 0;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (numOfVehicles < CAPACITY) {
            vehicles.add(vehicle);
            numOfVehicles++;
            return true;
        } else {
            return false;
        }
    }

    public boolean removeVehicle(String vin) {
        for (int i = 0; i < numOfVehicles; i++) {
            if (vehicles.get(i).getVin().equals(vin)) {
                vehicles.remove(i);
                numOfVehicles--;
                return true;
            }
        }
        return false;
    }

    public String getVehicleDetailsByVin(String vin) {
        for (int i = 0; i < numOfVehicles; i++) {
            if (vehicles.get(i).getVin().equals(vin)) {
                return vehicles.get(i).toString();
            }
        }
        return "Vehicle Not Found";
    }

    public ArrayList<Vehicle> sortVehiclesByPrice() {
        vehicles.sort(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return vehicles;
    }

    public ArrayList<Vehicle> displayVehiclesLesserThanPrice(double price) {
        ArrayList<Vehicle> cheaperVehicles = new ArrayList<>();
        for (int i = 0; i < numOfVehicles; i++) {
            if (vehicles.get(i).getPrice() < price) {
                cheaperVehicles.add(vehicles.get(i));
            }
        }
        return cheaperVehicles;
    }

    public ArrayList<ElectricCar> displayElectricCarsAboveBatteryRange(double batteryRange) {
        ArrayList<ElectricCar> carsOverGivenRange = new ArrayList<>();
        for (int i = 0; i < numOfVehicles; i++) {
            if (vehicles.get(i) instanceof ElectricCar) {
                carsOverGivenRange.add((ElectricCar) vehicles.get(i));
            }
        }

        for (int i = 0; i < carsOverGivenRange.size(); i++) {
            if (carsOverGivenRange.get(i).getBatteryRange() < batteryRange) {
                carsOverGivenRange.remove(i);
            }
        }
        return carsOverGivenRange;
    }

    public boolean exportDealershipToFile() {
        try (FileWriter myWriter = new FileWriter("/Users/c2473383/ACC/ACCIntelliJProjects/JavaClassPractice/JavaClassWork/src/main/java/Sep_18_2025_Exam/dealership.txt")) {
            myWriter.write(this.toString());
            return true;
        } catch (Exception e) {
            System.out.println("Failed to export dealership to file");
            return false;
        }
    }

    public boolean importDealershipFromFile() {
        vehicles.clear();
        numOfVehicles = 0;
        File myObj = new File("/Users/c2473383/ACC/ACCIntelliJProjects/JavaClassPractice/JavaClassWork/src/main/java/Sep_18_2025_Exam/dealership.txt");
        String fileOutputStr = "";

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                fileOutputStr += myReader.nextLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while importing dealership from file.");
            return false;
        }

        fileOutputStr = fileOutputStr.substring(fileOutputStr.lastIndexOf("[") + 1, fileOutputStr.lastIndexOf("]"));

        String[] entries = fileOutputStr.split(",\\s*");

        for (String entry : entries) {
            String[] strArr = entry.trim().split(" ");

            switch (strArr[0]) {

                case "MC":
                    Motorcycle motorcycle = new Motorcycle
                            (strArr[1],
                             strArr[2],
                             Double.parseDouble(strArr[3]),
                             Double.parseDouble(strArr[4]));
                    vehicles.add(motorcycle);
                    numOfVehicles++;
                    break;

                case "TR":
                    Truck truck = new Truck
                            (strArr[1],
                             strArr[2],
                             Double.parseDouble(strArr[3]),
                             Double.parseDouble(strArr[4]));
                    vehicles.add(truck);
                    numOfVehicles++;
                    break;

                case "SUV":
                    SUV suv = new SUV
                            (strArr[1],
                             strArr[2],
                             Double.parseDouble(strArr[3]),
                             Integer.parseInt(strArr[4]));
                    vehicles.add(suv);
                    numOfVehicles++;
                    break;

                case "EC":
                    ElectricCar electricCar = new ElectricCar
                            (strArr[1],
                             strArr[2],
                             Double.parseDouble(strArr[3]),
                             Double.parseDouble(strArr[4]));
                    vehicles.add(electricCar);
                    numOfVehicles++;
                    break;

                case "GC":
                    GasCar gasCar = new GasCar
                            (strArr[1],
                             strArr[2],
                             Double.parseDouble(strArr[3]),
                             Double.parseDouble(strArr[4]));
                    vehicles.add(gasCar);
                    numOfVehicles++;
                    numOfVehicles++;
                    break;

                case "HB":
                    HybridCar hybridCar = new HybridCar
                            (strArr[1],
                             strArr[2],
                             Double.parseDouble(strArr[3]),
                             Double.parseDouble(strArr[4]));
                    vehicles.add(hybridCar);
                    numOfVehicles++;
                    break;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return vehicles + " ";
    }
}