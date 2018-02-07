package puzzles;

import java.util.Random;
import java.util.UUID;

/**
 * Generate password.
 */

public class PasswordGenerator {
   static final String capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   static final String lower_chars = "abcdefghijklmnopqrstuvwxyz";
   static final String numbers = "0123456789";
   static final String special_chars = "\"!@#$%^&*_=+-/.?<>)";

   public static void main(String[] args) {
      int length = 7;
      System.out.println("Password with UUID: " + generateUuid(length));

      System.out.println("Password with Random: " + generateRandom(length));

   }

   /**
    * Use GUID as starting point. Replace dashes with empty string. Substring
    * 32 char GUID with {@code length}
    *
    * @param length
    * @return password
    */
   private static String generateUuid(int length) {
      String pwd = UUID.randomUUID().toString().replaceAll("-", "").substring(0, length);
      return pwd;
   }

   /**
    * Combine all specified character strings and use {@link Random#nextInt(int)} to get random index into that
    * string.
    *
    * @param length
    * @return password
    */
   private static String generateRandom(int length) {
      Random random = new Random();
      String chars = capital_chars + lower_chars + numbers + special_chars;

      char[] pwd = new char[length];

      for(int i = 0; i < length; i++) {
         pwd[i] = chars.charAt(random.nextInt(chars.length()));
      }

      return String.valueOf(pwd);
   }
}
