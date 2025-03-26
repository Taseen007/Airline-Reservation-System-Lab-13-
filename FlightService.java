import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FlightService {
   private RandomGenerator randomGenerator;
   private List<Flight> flightList;

   public FlightService(RandomGenerator var1) {
      this.randomGenerator = var1;
      this.flightList = new ArrayList();
   }

   public void scheduleFlights(int var1) {
      for(int var2 = 0; var2 < var1; ++var2) {
         String[][] var3 = this.randomGenerator.randomDestinations();
         String[] var4 = new String[]{this.calculateDistance(Double.parseDouble(var3[0][1]), Double.parseDouble(var3[0][2]), Double.parseDouble(var3[1][1]), Double.parseDouble(var3[1][2])), this.calculateDistance(Double.parseDouble(var3[0][1]), Double.parseDouble(var3[0][2]), Double.parseDouble(var3[1][1]), Double.parseDouble(var3[1][2]))};
         String var5 = this.createNewFlightsAndTime();
         String var6 = this.randomGenerator.randomFlightNumbGen(2, 1).toUpperCase();
         int var7 = this.randomGenerator.randomNumOfSeats();
         String var8 = this.randomGenerator.randomFlightNumbGen(1, 1);
         this.flightList.add(new Flight(var5, var6, var7, var3, var4, var8.toUpperCase()));
      }

   }

   public List<Flight> getFlightList() {
      return this.flightList;
   }

   public FlightReservation addCustomerToFlight(Customer var1, String var2) {
      Iterator var3 = this.flightList.iterator();

      while(var3.hasNext()) {
         Flight var4 = (Flight)var3.next();
         if (var4.getFlightNumber().equalsIgnoreCase(var2)) {
            if (var4.getNumOfSeats() > var4.getPassengers().size()) {
               var4.addCustomer(var1);
               return new FlightReservation(var1, var4, var4.getFlightNumber());
            }

            System.out.println("No available seats on this flight.");
            break;
         }
      }

      return null;
   }

   public void deleteFlight(String var1) {
      this.flightList.removeIf((var1x) -> {
         return var1x.getFlightNumber().equalsIgnoreCase(var1);
      });
   }

   private String calculateDistance(double var1, double var3, double var5, double var7) {
      double var9 = var3 - var7;
      double var11 = Math.sin(this.degreeToRadian(var1)) * Math.sin(this.degreeToRadian(var5)) + Math.cos(this.degreeToRadian(var1)) * Math.cos(this.degreeToRadian(var5)) * Math.cos(this.degreeToRadian(var9));
      var11 = Math.acos(var11);
      var11 = this.radianToDegree(var11);
      var11 = var11 * 60.0 * 1.1515;
      return String.format("%.2f", var11 * 0.8684);
   }

   private double degreeToRadian(double var1) {
      return var1 * Math.PI / 180.0;
   }

   private double radianToDegree(double var1) {
      return var1 * 180.0 / Math.PI;
   }

   private String createNewFlightsAndTime() {
      Calendar var1 = Calendar.getInstance();
      var1.add(5, (int)(Math.random() * 7.0));
      var1.add(10, (int)(Math.random() * 24.0));
      var1.set(12, var1.get(12) * 3 - (int)(Math.random() * 45.0));
      Date var2 = var1.getTime();
      LocalDateTime var3 = Instant.ofEpochMilli(var2.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
      var3 = this.getNearestHourQuarter(var3);
      return var3.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, HH:mm a"));
   }

   private LocalDateTime getNearestHourQuarter(LocalDateTime var1) {
      int var2 = var1.getMinute();
      int var3 = var2 % 15;
      if (var3 < 8) {
         var1 = var1.minusMinutes((long)var3);
      } else {
         var1 = var1.plusMinutes((long)(15 - var3));
      }

      return var1.truncatedTo(ChronoUnit.MINUTES);
   }
}
