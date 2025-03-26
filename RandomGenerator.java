import java.util.Random;

public class RandomGenerator {
   private String randomNumber;

   public RandomGenerator() {
   }

   public void randomIDGen() {
      Random var1 = new Random();
      this.randomNumber = String.format("%06d", var1.nextInt(999999));
   }

   public String getRandomNumber() {
      return this.randomNumber;
   }

   public String randomFlightNumbGen(int var1, int var2) {
      StringBuilder var3 = new StringBuilder();
      Random var4 = new Random();

      int var5;
      for(var5 = 0; var5 < var1; ++var5) {
         var3.append((char)(var4.nextInt(26) + 65));
      }

      for(var5 = 0; var5 < var2; ++var5) {
         var3.append(var4.nextInt(10));
      }

      return var3.toString();
   }

   public String[][] randomDestinations() {
      String[][] var1 = new String[][]{{"New York", "40.712776", "-74.005974"}, {"Los Angeles", "34.052235", "-118.243683"}};
      return var1;
   }

   public int randomNumOfSeats() {
      Random var1 = new Random();
      return var1.nextInt(50) + 50;
   }
}
