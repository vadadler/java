package com.planmart;

/**
 * Interface defining a rule. There is one method to validate and process 
 * this rule.
 * 
 * @author vad
 */
public interface Rule {
   /**
    * Validate and process rule.
    * 
    * @param  order the order to validate and process.
    * @return       <code>true</code> if order was valid and processed.
    *               <code>false</code> otherwise.
    */
   boolean processRule(Order order);
}
