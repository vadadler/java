package com.planmart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ShippingRule implements Rule {
   public static final String[] STATES = new String[] { "VA", "NC", "SC", "TN", "AK", "KY", "AL" };
   public static final Set<String> NO_SHIPPING_ALCOHOL_STATES = new HashSet<String>(Arrays.asList(STATES));

   /**
    * Shipping rules:
    * 1. Non profits - free shipping.
    * 2. Alcohol may not be shipped to VA, NC, SC, TN, AK, KY, AL
    * 3. Alcohol may only be shipped to customers age 21 or over in the US
    * 4. Shipping is $10 for orders under 20 pounds
    * 5. Shipping is $20 for orders 20 pounds or over 
    */
   @Override
   public boolean processRule(Order order) {
      // Rule #1: free shipping to non profits.
      if(order.getCustomer().getIsNonProfit() == true) {
         // TODO: add code.
      }
      
      // Find out if alcohol product is in the order.
      boolean isAlcoholInOrder = false;
      for(ProductOrder product : order.getItems()) {
         if(product.getProduct().getType() == ProductType.ALCOHOL) {
            isAlcoholInOrder = true;
            break;
         }
      }
      
      // Rule #2: no shipping of alcohol to select states.
      if(isAlcoholInOrder == true &&
            NO_SHIPPING_ALCOHOL_STATES.contains(order.getShippingRegion().toUpperCase()) == true) {
         return false;
      }
      
      // Rule #3: if US ship alcohol only to 21+ year old customer.
      //if(order.)
      //int age = order.getCustomer().getBirthDate()
      return false;
   }

}
