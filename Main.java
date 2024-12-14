import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private List<Vehicle> listVehicle = new ArrayList<>();
    private List<Transaction> listTransaction = new ArrayList<>();
    private List<Customer> listCustomer = new ArrayList<>();
    private List<Admin> listAdmin = new ArrayList<>();

    public static void main(String[] args) {
        Main rentalSystem = new Main();
        rentalSystem.initializeData();
        rentalSystem.run();
    }

    
    private void initializeData() {
        listAdmin.add(new Admin("admin1", "password123"));
        listAdmin.add(new Admin("admin2", "password456"));

        listVehicle.add(new Car("V001", "Toyota Camry", 500.0f));
        listVehicle.add(new Motorcycle("V002", "Yamaha R15", 200.0f));

        listCustomer.add(new Customer("C001", "John Doe"));
        listCustomer.add(new Customer("C002", "Jane Smith"));
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== RentalWemen System ===");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Customer");
            System.out.println("3. Register Customer");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    loginAdmin(scanner);
                    break;
                case 2:
                    loginCustomer(scanner);
                    break;
                case 3:
                    registerCustomer(scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }


    private void loginAdmin(Scanner scanner) {
        System.out.print("Enter admin ID: ");
        String adminID = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

       
        for (Admin admin : listAdmin) {
            if (admin.getAdminID().equals(adminID) && admin.getPassword().equals(password)) {
                adminMenu(scanner);
                return;
            }
        }
        System.out.println("Invalid admin credentials.");
    }


    private void adminMenu(Scanner scanner) {
        boolean adminRunning = true;
        while (adminRunning) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Remove Vehicle");
            System.out.println("3. View All Vehicles");
            System.out.println("4. View All Customers");
            System.out.println("5. View All Transactions");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addVehicle(scanner);
                    break;
                case 2:
                    removeVehicle(scanner);
                    break;
                case 3:
                    viewAllVehicles();
                    break;
                case 4:
                    viewAllCustomers();
                    break;
                case 5:
                    viewAllTransactions();
                    break;
                case 6:
                    adminRunning = false;
                    System.out.println("Admin logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  
    private void loginCustomer(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        String customerID = scanner.nextLine();

   
        for (Customer customer : listCustomer) {
            if (customer.getCustID().equals(customerID)) {
                customerMenu(scanner, customer);
                return;
            }
        }
        System.out.println("Customer not found.");
    }


    private void customerMenu(Scanner scanner, Customer customer) {
        boolean customerRunning = true;
        while (customerRunning) {
            System.out.println("\n=== Customer Menu ===");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. View My Transactions");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    rentVehicle(scanner, customer);
                    break;
                case 2:
                    viewCustomerTransactions(customer);
                    break;
                case 3:
                    customerRunning = false;
                    System.out.println("Customer logged out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  
    private void registerCustomer(Scanner scanner) {
        System.out.print("Enter customer ID: ");
        String custID = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String custName = scanner.nextLine();

        Customer newCustomer = new Customer(custID, custName);
        listCustomer.add(newCustomer);
        System.out.println("Customer registered successfully.");
    }

   
    private void addVehicle(Scanner scanner) {
        System.out.print("Enter vehicle ID: ");
        String vehicleID = scanner.nextLine();
        System.out.print("Enter vehicle name: ");
        String vehicleName = scanner.nextLine();
        System.out.print("Enter rental price per day: ");
        float rentalPrice = scanner.nextFloat();
        scanner.nextLine(); 

        System.out.print("Is this a car or motorcycle (c/m)? ");
        String type = scanner.nextLine();

        if (type.equalsIgnoreCase("c")) {
            listVehicle.add(new Car(vehicleID, vehicleName, rentalPrice));
        } else if (type.equalsIgnoreCase("m")) {
            listVehicle.add(new Motorcycle(vehicleID, vehicleName, rentalPrice));
        } else {
            System.out.println("Invalid vehicle type.");
            return;
        }
        System.out.println("Vehicle added successfully.");
    }

   
    private void removeVehicle(Scanner scanner) {
        System.out.print("Enter vehicle ID to remove: ");
        String vehicleID = scanner.nextLine();

        for (Vehicle vehicle : listVehicle) {
            if (vehicle.getVehicleID().equals(vehicleID)) {
                listVehicle.remove(vehicle);
                System.out.println("Vehicle removed successfully.");
                return;
            }
        }
        System.out.println("Vehicle not found.");
    }

  
    private void viewAllVehicles() {
        System.out.println("\n=== All Vehicles ===");
        for (Vehicle vehicle : listVehicle) {
            System.out.println(vehicle);
        }
    }

  
    private void viewAllCustomers() {
        System.out.println("\n=== All Customers ===");
        for (Customer customer : listCustomer) {
            System.out.println(customer);
        }
    }

  
    private void viewAllTransactions() {
        System.out.println("\n=== All Transactions ===");
        for (Transaction transaction : listTransaction) {
            System.out.println(transaction);
        }
    }

  
    private void rentVehicle(Scanner scanner, Customer customer) {
        System.out.print("Enter vehicle ID to rent: ");
        String vehicleID = scanner.nextLine();

        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : listVehicle) {
            if (vehicle.getVehicleID().equals(vehicleID)) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        System.out.print("Enter rental duration (days): ");
        int days = scanner.nextInt();
        scanner.nextLine(); 

        float totalPrice = selectedVehicle.getRentalPrice() * days;
        Transaction transaction = new Transaction("T" + (listTransaction.size() + 1), new java.util.Date(), totalPrice, customer, selectedVehicle);
        listTransaction.add(transaction);

        System.out.println("Transaction recorded successfully.");
        System.out.println("Total Price: " + totalPrice);
    }


    private void viewCustomerTransactions(Customer customer) {
        System.out.println("\n=== Transactions for " + customer.getCustName() + " ===");
        for (Transaction transaction : listTransaction) {
            if (transaction.getCustomer().equals(customer)) {
                System.out.println(transaction);
            }
        }
    }
}
