import java.util.Iterator;
import java.util.List;

public class FlightReservationDisplay {
   public FlightReservationDisplay() {
   }

   public void displayReservations(List<FlightReservation> var1) {
      System.out.println();
      System.out.print("+------+-------------------------------------------+-----------+-----------+------------------+\n");
      System.out.printf("| Num  | Reservation ID\t\t\t   | Customer Name | Flight No | Tickets Count |\n");
      System.out.print("+------+-------------------------------------------+-----------+-----------+------------------+\n");
      int var2 = 0;
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         FlightReservation var4 = (FlightReservation)var3.next();
         ++var2;
         System.out.println(this.reservationToString(var4, var2));
         System.out.print("+------+-------------------------------------------+-----------+-----------+------------------+\n");
      }

   }

   private String reservationToString(FlightReservation var1, int var2) {
      return String.format("%10s| %-10d | %-10s | %-32s | %-7s | %-27s |", "", var2, var1.getReservationID(), var1.getCustomer().getName(), var1.getFlight().getFlightNumber(), var1.getNumOfTickets());
   }
}