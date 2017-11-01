# Checkout Component 3.0

## Build
mvn clean install

## Tech stack 
- Java 8
- Spring 4, Spring Boot
- H2 database, Spring Data, Hibernate
- Mockito

## Design
- **Item**, **Cart**, **ItemGroupDiscount** - model class, with Repositories (Spring Data), and service layers. Cart contains Item.

- **CheckoutReceipt** and **ItemPriceWithDiscounts** are dto classes. An instance of the first one is returned when we go to checkout url. 
The second one is used by Calculator mechanism.

- **CheckoutService** is responsible for creation CheckoutReceipt object with calculated prices. It's used in **CheckoutController**. 

- Calculation logic is implemented in **checkoutCalculator** package

## API
GET api/items - return all items from db

POST api/cart/cartId/add/itemId/quantity - with given cartId, itemId and quantity, add an item with quantity to a cart, return cart

GET api/checkout/cartId - with give cartId, it gets summary of the cart with a final price

## TO-DO
- [ ] write more tests
