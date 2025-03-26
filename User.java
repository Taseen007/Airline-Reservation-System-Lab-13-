import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Remove java.io.* import as it's no longer needed

public class User {
    private static List<Customer> customersCollection = new ArrayList<>();
    private static List<Flight> flightList = new ArrayList<>();
    private static List<FlightReservation> reservationsList = new ArrayList<>();

    public static void main(String[] args) {
        RolesAndPermissions rolesAndPermissions = new RolesAndPermissions();
        RandomGenerator randomGenerator = new RandomGenerator();
        CustomerService customerService = new CustomerService(randomGenerator);
        CustomerDisplay customerDisplay = new CustomerDisplay();
        FlightService flightService = new FlightService(randomGenerator);
        FlightDisplay flightDisplay = new FlightDisplay();
        FlightReservationService reservationService = new FlightReservationService();
        FlightReservationDisplay reservationDisplay = new FlightReservationDisplay();

        flightService.scheduleFlights(15);
        flightList = flightService.getFlightList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t\t\t\t\t+++++++++++++ Welcome to BAV AirLines +++++++++++++\n\nTo Further Proceed, Please enter a value.");
        System.out.println("\n***** Default Username && Password is root-root ***** Using Default Credentials will restrict you to just view the list of Passengers....\n");

        while (true) {
            displayMainMenu();
            int desiredOption = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (desiredOption) {
                case 1:
                    System.out.print("\nEnter the UserName to login to the Management System :     ");
                    String username = scanner.nextLine();
                    System.out.print("Enter the Password to login to the Management System :    ");
                    String password = scanner.nextLine();
                    System.out.println();

                    int privilege = rolesAndPermissions.isPrivilegedUserOrNot(username, password);
                    if (privilege == -1) {
                        System.out.printf("\n%20sERROR!!! Unable to login. Cannot find user with the entered credentials.... Try Creating New Credentials or get yourself registered by pressing 4....\n", "");
                    } else if (privilege == 0) {
                        System.out.println("You've standard/default privileges to access the data... You can just view customers data... Can't perform any actions on them....");
                        customerDisplay.displayCustomersData(customersCollection, true);
                    } else {
                        System.out.printf("%-20sLogged in Successfully as \"%s\"..... For further Proceedings, enter a value from below....", "", username);
                        handleUserActions(scanner, customerService, customerDisplay, flightService, flightDisplay, reservationService, reservationDisplay);
                    }
                    break;
                case 2:
                    customerService.addNewCustomer(customersCollection);
                    break;
                case 3:
                    handleCustomerSearch(scanner, customerDisplay);
                    break;
                case 4:
                    handleCustomerEdit(scanner, customerService);
                    break;
                case 5:
                    handleCustomerDeletion(scanner, customerService);
                    break;
                case 6:
                    flightDisplay.displayFlightSchedule(flightList);
                    break;
                case 7:
                    handleFlightRegistration(scanner, customerService, flightService);
                    break;
                case 8:
                    handleReservationDetails(scanner, reservationDisplay);
                    break;
                default:
                    System.out.println("Invalid Option. Please try again.");
                    break;
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Login as Admin");
        System.out.println("2. Register New Customer");
        System.out.println("3. Search Customer");
        System.out.println("4. Edit Customer Info");
        System.out.println("5. Delete Customer");
        System.out.println("6. View Flight Schedule");
        System.out.println("7. Register for a Flight");
        System.out.println("8. View Reservation Details");
        System.out.print("Enter your choice: ");
    }

    private static void handleUserActions(Scanner scanner, CustomerService customerService, CustomerDisplay customerDisplay, FlightService flightService, FlightDisplay flightDisplay, FlightReservationService reservationService, FlightReservationDisplay reservationDisplay) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add New Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Edit Customer Info");
            System.out.println("4. Delete Customer");
            System.out.println("5. View Flight Schedule");
            System.out.println("6. Register for a Flight");
            System.out.println("7. View Reservation Details");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");
            int adminOption = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (adminOption) {
                case 1:
                    customerService.addNewCustomer(customersCollection);
                    break;
                case 2:
                    handleCustomerSearch(scanner, customerDisplay);
                    break;
                case 3:
                    handleCustomerEdit(scanner, customerService);
                    break;
                case 4:
                    handleCustomerEdit(scanner, customerService);
                    break;
                case 5:
                    handleCustomerDeletion(scanner, customerService);
                    break;
                case 6:
                    handleFlightRegistration(scanner, customerService, flightService);
                    break;
                case 7:
                    handleReservationDetails(scanner, reservationDisplay);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Invalid Option. Please try again.");
                    break;
            }
        }
    }

    private static void handleFlightRegistration(Scanner var0, CustomerService var1, FlightService var2) {
        System.out.print("\nEnter Customer ID: ");
        String var3 = var0.nextLine();
        System.out.print("Enter Flight Number: ");
        String var4 = var0.nextLine();
        Customer var5 = null;
        java.util.Iterator var6 = customersCollection.iterator();

        while(var6.hasNext()) {
           Customer var7 = (Customer)var6.next();
           if (var7.getUserID().equals(var3)) {
              var5 = var7;
              break;
           }
        }

        if (var5 != null) {
           FlightReservation reservation = var2.addCustomerToFlight(var5, var4);
           if (reservation != null) {
               reservationsList.add(reservation);
               System.out.println("Flight registration successful!");
           } else {
               System.out.println("Failed to register for the flight. The flight might be full or not found.");
           }
        } else {
           System.out.println("Customer not found.");
        }
    }

    private static void handleReservationDetails(Scanner scanner, FlightReservationDisplay reservationDisplay) {
        System.out.println("Displaying all reservations:");
        reservationDisplay.displayReservations(reservationsList);
    }

    private static void handleCustomerSearch(Scanner scanner, CustomerDisplay customerDisplay) {
        System.out.print("\nEnter Customer ID to search: ");
        String customerID = scanner.nextLine();
        customerDisplay.searchUser(customerID, customersCollection);
    }

    private static void handleCustomerEdit(Scanner scanner, CustomerService customerService) {
        System.out.print("\nEnter Customer ID to edit: ");
        String customerID = scanner.nextLine();
        customerService.editUserInfo(customerID, customersCollection);
    }

    private static void handleCustomerDeletion(Scanner scanner, CustomerService customerService) {
        System.out.print("\nEnter Customer ID to delete: ");
        String customerID = scanner.nextLine();
        customerService.deleteUser(customerID, customersCollection);
    }
}