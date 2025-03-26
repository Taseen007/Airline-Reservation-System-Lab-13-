import java.util.List;
import java.util.Scanner;
public class CustomerService {
    private RandomGenerator randomGenerator;

    public CustomerService(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public void addNewCustomer(List<Customer> customerCollection) {
        System.out.printf("\n\n\n%60s ++++++++++++++ Welcome to the Customer Registration Portal ++++++++++++++", "");
        Scanner read = new Scanner(System.in);
        System.out.print("\nEnter your name :\t");
        String name = read.nextLine();
        System.out.print("Enter your email address :\t");
        String email = read.nextLine();
        while (isUniqueData(email, customerCollection)) {
            System.out.println(
                    "ERROR!!! User with the same email already exists... Use new email or login using the previous credentials....");
            System.out.print("Enter your email address :\t");
            email = read.nextLine();
        }
        System.out.print("Enter your Password :\t");
        String password = read.nextLine();
        System.out.print("Enter your Phone number :\t");
        String phone = read.nextLine();
        System.out.print("Enter your address :\t");
        String address = read.nextLine();
        System.out.print("Enter your age :\t");
        int age = read.nextInt();
        randomGenerator.randomIDGen();
        String userID = randomGenerator.getRandomNumber();
        Customer newCustomer = new Customer(name, email, password, phone, address, age, userID);
        customerCollection.add(newCustomer);
    }

    public boolean isUniqueData(String emailID, List<Customer> customerCollection) {
        for (Customer c : customerCollection) {
            if (emailID.equals(c.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public void editUserInfo(String ID, List<Customer> customerCollection) {
        boolean isFound = false;
        Scanner read = new Scanner(System.in);
        for (Customer c : customerCollection) {
            if (ID.equals(c.getUserID())) {
                isFound = true;
                System.out.print("\nEnter the new name of the Passenger:\t");
                String name = read.nextLine();
                c.setName(name);
                System.out.print("Enter the new email address of Passenger " + name + ":\t");
                c.setEmail(read.nextLine());
                System.out.print("Enter the new Phone number of Passenger " + name + ":\t");
                c.setPhone(read.nextLine());
                System.out.print("Enter the new address of Passenger " + name + ":\t");
                c.setAddress(read.nextLine());
                System.out.print("Enter the new age of Passenger " + name + ":\t");
                c.setAge(read.nextInt());
                break;
            }
        }
        if (!isFound) {
            System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", ID);
        }
    }

    public void deleteUser(String ID, List<Customer> customerCollection) {
        boolean isFound = false;
        for (Customer customer : customerCollection) {
            if (ID.equals(customer.getUserID())) {
                isFound = true;
                customerCollection.remove(customer);
                break;
            }
        }
        if (isFound) {
            System.out.printf("\n%-50sPrinting all Customer's Data after deleting Customer with the ID %s.....!!!!\n", "", ID);
        } else {
            System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", ID);
        }
    }
}