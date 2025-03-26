import java.util.List;

public class FlightDisplay {
    public void displayFlightSchedule(List<Flight> flightList) {
        System.out.println();
        System.out.print("+------+-------------------------------------------+-----------+------------------+-----------------------+------------------------+---------------------------+-----------+----------------+\n");
        System.out.printf("| %-4s | %-41s | %-9s | %-16s | %-21s | %-22s | %-25s | %-9s | %-14s |\n",
                "Num", "FLIGHT SCHEDULE", "FLIGHT NO", "Available Seats", "FROM ====>>", "====>> TO", "ARRIVAL TIME", "GATE", "DISTANCE(Miles)");
        System.out.print("+------+-------------------------------------------+-----------+------------------+-----------------------+------------------------+---------------------------+-----------+----------------+\n");
        int i = 0;
        for (Flight flight : flightList) {
            i++;
            System.out.println(flightToString(flight, i));
            System.out.print("+------+-------------------------------------------+-----------+------------------+-----------------------+------------------------+---------------------------+-----------+----------------+\n");
        }
    }

    private String flightToString(Flight flight, int serialNum) {
        return String.format("| %-4d | %-41s | %-9s | %-16d | %-21s | %-22s | %-25s | %-9s | %-14.2f |",
                serialNum,
                flight.getFlightSchedule(),
                flight.getFlightNumber(),
                flight.getNumOfSeats(),
                flight.getFromWhichCity(),
                flight.getToWhichCity(),
                flight.getFlightSchedule(),    // Changed from getArrivalTime to getFlightTime
                flight.getGate(),
                flight.getDistance());
    }

    public void displayHeaderForUsers(Flight flight, List<Customer> customers) {
        System.out.printf("\n%65s Displaying Registered Customers for Flight No. \"%s\" \n\n", "+++++++++++++", flight.getFlightNumber());
        System.out.printf("%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+----------------+\n", "");
        System.out.printf("%10s| %-10s | %-10s | %-32s | %-7s | %-27s | %-35s | %-23s | %-14s |\n",
                "", "SerialNum", "UserID", "Passenger Names", "Age", "EmailID", "Home Address", "Phone Number", "Booked Tickets");
        System.out.printf("%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+----------------+\n", "");
        
        int size = customers.size();
        for (int i = 0; i < size; i++) {
            System.out.println(customerToString(customers.get(i), i, flightIndex(customers.get(i).getFlightsRegisteredByUser(), flight)));
            System.out.printf("%10s+------------+------------+----------------------------------+---------+-----------------------------+-------------------------------------+-------------------------+----------------+\n", "");
        }
    }

    private String customerToString(Customer customer, int serialNum, int index) {
        return String.format("%10s| %-10d | %-10s | %-32s | %-7d | %-27s | %-35s | %-23s | %-14d |",
                "",
                (serialNum + 1),
                customer.getUserID(),
                customer.getName(),
                customer.getAge(),
                customer.getEmail(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getNumOfTicketsBookedByUser().get(index));
    }

    private int flightIndex(List<Flight> flightList, Flight flight) {
        return flightList.indexOf(flight);  // Simplified as indexOf already does the equality check
    }
}