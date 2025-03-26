public class FlightReservation {
   private Customer customer;
   private Flight flight;
   private String reservationNumber;
   private int numOfTickets;

   public FlightReservation(Customer var1, Flight var2, String var3) {
      this.customer = var1;
      this.flight = var2;
      this.reservationNumber = var3;
      this.numOfTickets = 1;
   }

   public Customer getCustomer() {
      return this.customer;
   }

   public Flight getFlight() {
      return this.flight;
   }

   public String getReservationID() {
      return this.reservationNumber;
   }

   public String getReservationNumber() {
      return this.reservationNumber;
   }

   public int getNumOfTickets() {
      return this.numOfTickets;
   }
}
