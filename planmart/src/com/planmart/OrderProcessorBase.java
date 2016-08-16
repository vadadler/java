package com.planmart;

import java.util.ArrayList;

public abstract class OrderProcessorBase implements OrderProcessor {
   /** List of rules applied to an order.  */
   ArrayList<Rule> mRules = new ArrayList<Rule>();
   
   @Override
   public boolean processOrder(Order order) {
      return true; 
   }
}
