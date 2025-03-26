import java.util.List;
import java.util.ArrayList;

public class Customer {
    private final String userID;
    private String email;
    private String name;
    private String phone;
    private final String password;
    private String address;
    private int age;
    private List<Flight> flightsRegisteredByUser;
    private List<Integer> numOfTicketsBookedByUser;

    public Customer(String name, String email, String password, String phone, String address, int age, String userID) {
        this.name = name;
        this.userID = userID;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.age = age;
        this.flightsRegisteredByUser = new ArrayList<>();
        this.numOfTicketsBookedByUser = new ArrayList<>();
    }

    // Getters and Setters
    public String getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public List<Flight> getFlightsRegisteredByUser() {
        return flightsRegisteredByUser;
    }

    public List<Integer> getNumOfTicketsBookedByUser() {
        return numOfTicketsBookedByUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addNewFlight(Flight flight) {
        this.flightsRegisteredByUser.add(flight);
    }

    public void updateNumOfTicketsBookedByUser(int index, int numOfTickets) {
        this.numOfTicketsBookedByUser.set(index, numOfTickets);
    }
}