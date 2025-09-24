package Sep_18_2025_Exam;
/*
 Author: Cody Johnson
 Assignment: Exam 3 - Object-Oriented Programming (Java) (31498)
 Date: 20250918
 */
public class SUV extends Vehicle {

    private int seats;

    public SUV(String make, String vin, double price, int seats) {
        super(make, vin, price);
        try {
            if (SUV.seatsAreValid(seats)) {
                this.seats = seats;
            } else {
                throw new  Exception("SUV seats are invalid");
            }
        } catch (Exception e) {
            System.out.println("Incorrect number of seats! Must be either 2 or 3.");
        }

    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {

        try {
            if (SUV.seatsAreValid(seats)) {
                this.seats = seats;
            } else {
                throw new  Exception("SUV seats are invalid");
            }
        } catch (Exception e) {
            System.out.println("Incorrect number of seats! Must be either 2 or 3.");
        }
    }

    public static boolean seatsAreValid(int seats) {
        return (seats >= 2) && (seats <= 3);
    }

    @Override
    public String toString() {
        return "SUV " + super.toString() + " " + seats;
    }
}