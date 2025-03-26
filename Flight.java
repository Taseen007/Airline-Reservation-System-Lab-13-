// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.ArrayList;
import java.util.List;

public class Flight {
   private String flightSchedule;
   private String flightNumber;
   private int numOfSeats;
   private String[][] destinations;
   private String[] distance;
   private String gate;
   private List<Customer> passengers;

   public Flight(String var1, String var2, int var3, String[][] var4, String[] var5, String var6) {
      this.flightSchedule = var1;
      this.flightNumber = var2;
      this.numOfSeats = var3;
      this.destinations = var4;
      this.distance = var5;
      this.gate = var6;
      this.passengers = new ArrayList();
   }

   public String getFlightNumber() {
      return this.flightNumber;
   }

   public int getNumOfSeats() {
      return this.numOfSeats;
   }

   public List<Customer> getPassengers() {
      return this.passengers;
   }

   public boolean addCustomer(Customer var1) {
      if (this.passengers.size() < this.numOfSeats) {
         this.passengers.add(var1);
         return true;
      } else {
         return false;
      }
   }

   public String getFlightSchedule() {
      return this.flightSchedule;
   }

   public String[][] getDestinations() {
      return this.destinations;
   }

   public String[] getDistance() {
      return this.distance;
   }

   public String getGate() {
      return this.gate;
   }

   public String getFromWhichCity() {
      return this.destinations[0][0];
   }

   public String getToWhichCity() {
      return this.destinations[1][0];
   }
}
