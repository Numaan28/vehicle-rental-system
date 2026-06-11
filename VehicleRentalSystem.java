
import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    private int id;
    private String brand;
    private String model;
    private double rentPerDay;
    private boolean available;

    public Vehicle(int id, String brand, String model, double rentPerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.rentPerDay = rentPerDay;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void rentVehicle() {
        available = false;
    }

    public void returnVehicle() {
        available = true;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Brand: " + brand +
                " | Model: " + model +
                " | Rent/Day: ₹" + rentPerDay +
                " | Status: " + (available ? "Available" : "Rented");
    }
}

class Customer {
    private String name;
    private String phone;

    public Customer(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}

class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int days;

    public Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    public double calculateBill() {
        return vehicle.getRentPerDay() * days;
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName()
                + " | Phone: " + customer.getPhone()
                + " | Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel()
                + " | Days: " + days
                + " | Bill: ₹" + calculateBill();
    }
}

public class VehicleRentalSystem {

    static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    static ArrayList<Rental> rentals = new ArrayList<Rental>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        vehicles.add(new Vehicle(1, "Honda", "City", 1500));
        vehicles.add(new Vehicle(2, "Hyundai", "Creta", 2000));
        vehicles.add(new Vehicle(3, "Royal Enfield", "Classic 350", 800));
        vehicles.add(new Vehicle(4, "Maruti", "Swift", 1200));
        vehicles.add(new Vehicle(5, "TVS", "Apache RTR", 700));

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     VEHICLE RENTAL SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Vehicles");
            System.out.println("2. Rent Vehicle");
            System.out.println("3. Return Vehicle");
            System.out.println("4. Rental History");
            System.out.println("5. Search Vehicle");
            System.out.println("6. Exit");
            System.out.println("=================================");

            int choice = getIntInput("Enter Choice: ");

            switch (choice) {

                case 1:
                    viewVehicles();
                    break;

                case 2:
                    rentVehicle();
                    break;

                case 3:
                    returnVehicle();
                    break;

                case 4:
                    showHistory();
                    break;

                case 5:
                    searchVehicle();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static int getIntInput(String message) {

        while (true) {

            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                return value;
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static void viewVehicles() {

        System.out.println("\n========== VEHICLES ==========");

        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    static void rentVehicle() {

        System.out.println("\n========== RENT VEHICLE ==========");

        System.out.print("Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Phone Number: ");
        String phone = sc.nextLine();

        System.out.println("\nAvailable Vehicles:");

        boolean found = false;

        for (Vehicle v : vehicles) {

            if (v.isAvailable()) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Vehicles Available.");
            return;
        }

        int id = getIntInput("\nEnter Vehicle ID: ");

        Vehicle selected = null;

        for (Vehicle v : vehicles) {

            if (v.getId() == id && v.isAvailable()) {
                selected = v;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Vehicle Not Available.");
            return;
        }

        int days = getIntInput("Number of Days: ");

        if (days <= 0) {
            System.out.println("Invalid Number of Days.");
            return;
        }

        double bill = selected.getRentPerDay() * days;

        System.out.println("\n========== RENTAL RECEIPT ==========");
        System.out.println("Customer : " + name);
        System.out.println("Phone    : " + phone);
        System.out.println("Vehicle  : " + selected.getBrand() + " " + selected.getModel());
        System.out.println("Days     : " + days);
        System.out.println("Bill     : ₹" + bill);
        System.out.println("====================================");

        System.out.print("Confirm Rental (Y/N): ");
        String confirm = sc.nextLine();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Rental Cancelled.");
            return;
        }

        Customer customer = new Customer(name, phone);

        selected.rentVehicle();

        rentals.add(new Rental(customer, selected, days));

        System.out.println("Vehicle Rented Successfully!");
    }

    static void returnVehicle() {

        System.out.println("\n========== RETURN VEHICLE ==========");

        int id = getIntInput("Enter Vehicle ID: ");

        for (Vehicle v : vehicles) {

            if (v.getId() == id) {

                if (v.isAvailable()) {
                    System.out.println("Vehicle Already Available.");
                    return;
                }

                v.returnVehicle();

                System.out.println("Vehicle Returned Successfully!");
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }

    static void showHistory() {

        System.out.println("\n========== RENTAL HISTORY ==========");

        if (rentals.isEmpty()) {
            System.out.println("No Rental Records Found.");
            return;
        }

        int count = 1;

        for (Rental r : rentals) {
            System.out.println(count + ". " + r);
            count++;
        }
    }

    static void searchVehicle() {

        System.out.println("\n========== SEARCH VEHICLE ==========");

        int id = getIntInput("Enter Vehicle ID: ");

        for (Vehicle v : vehicles) {

            if (v.getId() == id) {
                System.out.println(v);
                return;
            }
        }

        System.out.println("Vehicle Not Found.");
    }
}

