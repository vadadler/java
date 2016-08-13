# PlanMart

For this homework we are creating the next great online shopping super store PlanMart! We need you to 
implement the order processing and validation system.  You are provided with a set of classes representing
an `Order` and are expected to create an implementation of the interface `IOrderProcessor` (C#) or 
`OrderProcessor` (Java, Python).  This interface simply defines one method:

**C#**

    bool ProcessOrder(Order order);

**Java**

	boolean processOrder(Order order);
	
**Python**

	process_order(self, order)
	
## Context
Imagine you are at the standard stage of an online ordering process where you click "checkout" and are taken to a confirmation 
screen that summarizes the products in your cart, shipping costs, taxes, etc.  This page would typically have a button, "Buy Now", 
which would execute the order.  This method represents the work needed to create this confirmation page.   
	
You are expected to perform two tasks in this method:
* Return `true` or `false` depending on whether the order is valid
* Add zero or more line items to the order representing details such as taxes, shipping costs, and reward points.

## What We're Looking For

Ideally when you're done you have something that works, and the code is designed in a fashion you'd be proud to show to others. Also, when contemplating your design, allow that there may be future implementations of the interface for different companies and that the requirements between those implementations may have a lot of similarities. 

Set aside about two hours to work on this. You may not have enough time to finish all of the requirements. We'd prefer having a few requriements implemented and tested really well rather than implementing all of the requirements with more warts. Code quality in tests should be as high as code quality in implementations.

## Specification

Here are the rules the implementation must enforce (feel free to implement any subset of these in the allocated time):

* All items are taxed at 8% unless exempt
* The following types of items are exempt from tax:
    * Food items shipped to CA, NY
* Orders to nonprofits are exempt from all tax and shipping
* Orders get 1 reward point per $2 spent
* Orders get double rewards points when:
    * Using PlanMart rewards credit card or
    * Three of these criteria met:
        * Multiple different products in the same order
        * Orders over $100
        * Orders on:
            * Black Friday (Day after Thanksgiving)
* Alcohol may not be shipped to VA, NC, SC, TN, AK, KY, AL
* Alcohol may only be shipped to customers age 21 or over in the US
* Shipping is $10 for orders under 20 pounds
* Shipping is $20 for orders 20 pounds or over 
* An `Order` should not be empty (the customer should be ordering *something*!)
* Sales tax should be rounded using the [round half up strategy](https://en.wikipedia.org/wiki/Rounding#Round_half_up)

## Data Model

We provide the following types:
* **Order** - The parameter to the processor and the top level object with which you interact.  Contains various details such
as the products ordered, the shipping address, line items, etc.
* **Customer** - Details about the customer who placed the order, including the date of birth, and whether they are a non-profit.
* **Product** - Describes a single product (such as a book, a TV, etc.) with details that describe the product such as its weight
and price.
* **ProductType** - An enum that specifies what sort of product it is (alcohol, clothing, etc.)
* **PaymentMethod** - An enum that specifies what payment method the customer used (Visa, PlanMart Rewards Card, etc.)
* **LineItem** - Added to an `Order` by the processor to indicate taxes, shipping costs, and awarded reward points.
* **LineItemType** - An enum that specifies whether the line item represents taxes, shipping costs, etc.
* **ProductOrder** - An `Order` contains one of these that describes what product is being ordered and how many..

## Example

    Order
		ShippingRegion: AZ
		PaymentMethod: Visa
		Placed: 2015-11-27
		Items: 
			ProductOrder
				Product
					Type: Alcohol
					Price: $20
					Weight: 2 lb
				Quantity: 3
			ProductOrder
				Product
					Type: Food
					Price: $25
					Weight: 3 lb
				Quantity: 3
		Customer
			BirthDate: 1988-03-04
			IsNonProfit: false
		
The processor should return `true`:
* While alcohol is involved, the customer is over the age of 21
* The order is not being shipped to any of VA, NC, SC, TN, AK, KY, or AL

The processor should add the following line items to the order:

    Order
		LineItems
			LineItem
				Type: Tax
				Amount: $10.80
			LineItem
				Type: Shipping
				Amount: $10.00
			LineItem
				Type: RewardsPoints
				Amount: 134
				
* A tax of $10.80 is 8% of the order total of $135
* The total weight of the order is less than 20 lb so shipping is $10
* $135 was spent, which represent 67 $2 chunks, giving us 67 reward points as a base.  But the amount is doubled to 134 because:
  * The order was greater than $100
  * More than one each of two different products were ordered
  * The order was placed on the day after Thanksgiving (a Black Friday)   

## Unit Tests

In addition to implementing the processor interface, you should also write unit tests that verify that your processor is 
producing the results expected of the specification.  Each unit test should instantiate and populate an `Order` and call
your implementation and validate the results.

## Design and implementation notes

1. Due to the requirement for implementation of OrderProcessor interface to be reused by other applications it would make sense to have OrderProcessorImplementor designed as an abstract class. However in this particular case there is only one method defined in OrderProcessor interface. The purpose of abstract classes is to provide some behavior implementation which could be used by all subclasses.
2. Based on the requirements for rules enforcement the following categories should be implemented: Tax, Reward, Shipping.
3. OrderProcessImplementor (or its subclasses if it is implemented as abstract class) should have a list of rules (tax, reward, shipping etc.) These rules should be validated one by one to determine if order is valid. As well as handle rewards and shipping.
4. There are 3 rules defined in the assignment. It makes sense to create an `interface Rule` with one method `boolean processRule(Order o)` There will be 3 different implementaions for each rule category type: Tax, Reward, Shipping.


## TODO
1. It would be a good idea to think about packaging. How to structure it. I would probably package by feature.
2. Figure out how to implement unit tests.
