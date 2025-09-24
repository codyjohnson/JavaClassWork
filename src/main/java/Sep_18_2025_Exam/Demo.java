package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
import java.util.Scanner;

public class Demo {

    public static void displayMenu() {

        Scanner sc = new Scanner(System.in);
        Dealership dealership = new Dealership();
        int choice;

        do {
            System.out.println("*----------* Menu *----------*");
            System.out.println("1-- \tAdd a vehicle");
            System.out.println("2-- \tRemove a vehicle by vin");
            System.out.println("3-- \tDisplay all vehicles");
            System.out.println("4-- \tSearch for a vehicle by vin");
            System.out.println("5-- \tDisplay vehicles, lowest price first");
            System.out.println("6-- \tDisplay vehicles, price lower than provided amount");
            System.out.println("7-- \tDisplay electric cars with range over provided amount");
            System.out.println("8-- \tExport car inventory to a file");
            System.out.println("9-- \tImport car inventory from a file");
            System.out.println("0-- \tQuit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1: System.out.println("Add a vehicle");
                    System.out.println("Legend: MC, TR, SUV, EC, GC, or HB");
                    System.out.print("Which type of vehicle would you like to add? ");
                    String vicType = sc.nextLine();

                    switch (vicType) {
                        case "MC":
                            System.out.print("Enter the make: ");
                            String make = sc.nextLine();
                            System.out.print("\nEnter the VIN: ");
                            String vin = sc.nextLine();
                            System.out.print("\nEnter the price: ");
                            double price = Double.parseDouble(sc.nextLine());
                            System.out.print("Enter the top speed: ");
                            double topSpeed = Double.parseDouble(sc.nextLine());
                            dealership.addVehicle(new Motorcycle(make,vin,price,topSpeed));
                            System.out.println("Vehicle added");
                            break;

                        case "TR":
                            System.out.print("Enter the make: ");
                            String make1 = sc.nextLine();
                            System.out.print("\nEnter the VIN: ");
                            String vin1 = sc.nextLine();
                            System.out.print("\nEnter the price: ");
                            double price1 = Double.parseDouble(sc.nextLine());
                            System.out.print("Enter the towing capacity: ");
                            double towingCapacity = Double.parseDouble(sc.nextLine());
                            dealership.addVehicle(new Truck(make1,vin1,price1,towingCapacity));
                            System.out.println("Vehicle added");
                            break;

                        case "SUV":
                            System.out.print("Enter the make: ");
                            String make2 = sc.nextLine();
                            System.out.print("\nEnter the VIN: ");
                            String vin2 = sc.nextLine();
                            System.out.print("\nEnter the price: ");
                            double price2 = Double.parseDouble(sc.nextLine());
                            System.out.print("Enter the number of seats: ");
                            int seats = Integer.parseInt(sc.nextLine());
                            dealership.addVehicle(new SUV(make2,vin2,price2,seats));
                            System.out.println("Vehicle added");
                            break;

                        case "EC":
                            System.out.print("Enter the make: ");
                            String make3 = sc.nextLine();
                            System.out.print("\nEnter the VIN: ");
                            String vin3 = sc.nextLine();
                            System.out.print("\nEnter the price: ");
                            double price3 = Double.parseDouble(sc.nextLine());
                            System.out.print("Enter the battery capacity: ");
                            double batteryRange = Double.parseDouble(sc.nextLine());
                            dealership.addVehicle(new ElectricCar(make3,vin3,price3,batteryRange));
                            System.out.println("Vehicle added");
                            break;

                        case "GC":
                            System.out.print("Enter the make: ");
                            String make4 = sc.nextLine();
                            System.out.print("\nEnter the VIN: ");
                            String vin4 = sc.nextLine();
                            System.out.print("\nEnter the price: ");
                            double price4 = Double.parseDouble(sc.nextLine());
                            System.out.print("Enter the horse power: ");
                            double horsePower = Double.parseDouble(sc.nextLine());
                            dealership.addVehicle(new GasCar(make4,vin4,price4,horsePower));
                            System.out.println("Vehicle added");
                            break;

                        case "HB":
                            System.out.print("Enter the make: ");
                            String make5 = sc.nextLine();
                            System.out.print("\nEnter the VIN: ");
                            String vin5 = sc.nextLine();
                            System.out.print("\nEnter the price: ");
                            double price5 = Double.parseDouble(sc.nextLine());
                            System.out.print("Enter the miles per gallon: ");
                            double mpg = Double.parseDouble(sc.nextLine());
                            dealership.addVehicle(new HybridCar(make5,vin5,price5,mpg));
                            System.out.println("Vehicle added");
                            break;

                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                    break;

                case 2: System.out.println("Remove a vehicle by vin");
                    System.out.print("Enter the VIN: ");
                    if (dealership.removeVehicle(sc.nextLine())) {
                        System.out.println("Vehicle has been removed");
                    } else {
                        System.out.println("Vehicle was not removed");
                    }
                    break;

                case 3: System.out.println("Display all vehicles");
                    System.out.println(dealership);
                    break;

                case 4: System.out.println("Search for a vehicle by vin ");
                    System.out.print("Enter the VIN: ");
                    String enteredVin = sc.nextLine();
                    if (!dealership.getVehicleDetailsByVin(enteredVin).isEmpty()) {
                        System.out.println(dealership.getVehicleDetailsByVin(enteredVin));
                    } else {
                        System.out.println("No vehicle found");
                    }
                    break;

                case 5: System.out.println("Display vehicles lowest price first");
                    System.out.println(dealership.sortVehiclesByPrice());
                    break;

                case 6: System.out.println("Display vehicles price lower than provided amount");
                    System.out.print("Enter a dollar amount: ");
                    System.out.println(dealership.displayVehiclesLesserThanPrice(sc.nextDouble()));
                    sc.nextLine();
                    break;

                case 7: System.out.println("Display electric cars with range over provided amount");
                    System.out.print("Enter a range amount: ");
                    System.out.println(dealership.displayElectricCarsAboveBatteryRange(sc.nextDouble()));
                    sc.nextLine();
                    break;

                case 8: System.out.println("Export car inventory to a file");
                    if (dealership.exportDealershipToFile()) {
                        System.out.println("Dealership has been exported to file");
                    } else {
                        System.out.println("Dealership has NOT been exported to file");
                    }
                    break;

                case 9: System.out.println("Import car inventory from a file");
                    if (dealership.importDealershipFromFile()) {
                        System.out.println("Dealership has been imported from a file");
                    } else {
                        System.out.println("Dealership has NOT been imported from a file");
                    }
                    break;

                case 0: System.out.println("Quitting...");
                    break;

                default: System.out.println("Invalid choice.");
                    break;
            }
        } while(choice != 0);
    }

    public static void runDemo() {
        //Setup
        Dealership dealership = new Dealership();
        dealership.addVehicle(new Motorcycle("Honda", "123498123", 100000, 170));
        dealership.addVehicle(new Truck("Ford", "234892379", 10000, 2000));
        dealership.addVehicle(new SUV("Toyota","9908412412", 15000, 3));
        dealership.addVehicle(new ElectricCar("Tesla", "83636372983",30000,5000));
        dealership.addVehicle(new ElectricCar("BMW", "832342342345622",40000,8000));
        dealership.addVehicle(new GasCar("Dodge","0009219128",25000,9001));
        dealership.addVehicle(new HybridCar("Toyota","2727272719",7000,150));
        System.out.println("Starting Dealership");
        System.out.println(dealership);
        System.out.println("\n");

        //Add a new vehicle to the inventory.
        System.out.println("Adding a new vehicle");
        dealership.addVehicle(new GasCar("Chevy","001111111228",27000,5002));
        System.out.println(dealership);
        System.out.println("\n");

        //Remove a vehicle based on its VIN number
        System.out.println("Removing Chevy vehicle based on VIN:001111111228");
        dealership.removeVehicle("001111111228");
        System.out.println(dealership);
        System.out.println("\n");

        //Display the full details of any vehicle based on the VIN number
        System.out.println("Finding and displaying Tesla car's details based on VIN: 83636372983");
        System.out.println(dealership.getVehicleDetailsByVin("83636372983"));
        System.out.println("\n");

        //Display the vehicles based on lowest price first
        System.out.println("Displaying vehicle based on lowest price first");
        dealership.sortVehiclesByPrice();
        System.out.println(dealership);
        System.out.println("\n");

        //Display vehicles with a price lower than certain amount
        System.out.println("Displaying vehicles with a price below 11000");
        System.out.println(dealership.displayVehiclesLesserThanPrice(11000));
        System.out.println("\n");

        //Display electric cars based on certain range (above certain range)
        System.out.println("Displaying electric cars above provided range: 6000");
        System.out.println(dealership.displayElectricCarsAboveBatteryRange(6000));
        System.out.println("\n");

        //Export the inventory into a text-based file
        System.out.println("Exporting dealership to file");
        System.out.println(dealership.exportDealershipToFile());
        System.out.println("\n");

        //Import the inventory from that file
        System.out.println("Importing dealership from file");
        System.out.println(dealership.importDealershipFromFile());
        System.out.println(dealership);
        System.out.println("\n");
    }
}
