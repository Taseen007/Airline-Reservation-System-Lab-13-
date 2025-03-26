import java.util.ArrayList;
import java.util.List;

public class FlightReservationService {
   private List<FlightReservation> reservations = new ArrayList();

   public FlightReservationService() {
   }

   public void addReservation(FlightReservation var1) {
      this.reservations.add(var1);
   }

   public void cancelReservation(String var1) {
      this.reservations.removeIf((var1x) -> {
         return var1x.getReservationID().equalsIgnoreCase(var1);
      });
   }

   public List<FlightReservation> getReservations() {
      return this.reservations;
   }
}
