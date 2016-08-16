package com.planmart;

public class OrderProcessorImplementor extends OrderProcessorBase {
   /** Constructor. */
   public OrderProcessorImplementor() {
      // Add rules.
      mRules.add(new ShippingRule());
   }
   
   @Override
   public boolean processOrder(Order order) {
      // Implementor does not have any rules specified.
      if(mRules.size() == 0) {
         return true;
      }
      
      // Walk through rules and process them.
      for(Rule rule : mRules) {
         if(rule.processRule(order) == false) {
            return false;
         }
      }
      
      return true;
   }
}
