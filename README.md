# ecommerce-system
File Structure
/src
  /ecommerce
    ├── ECommerceSystem.java
    ├── InventoryManagement.java
    ├── Main.java
README.md
Files:
1.ECommerceSystem.java: Handles users, products, orders, and payments.
2.InventoryManagement.java: Manages stock levels and processes incoming orders/restocks.
3.Main.java: The entry point of the application, demonstrating how the system works.
4.README.md: Documentation and instructions for running the project.

How to Run
Prerequisites:
Java Development Kit (JDK) 8 or higher must be installed.
An IDE such as IntelliJ IDEA, Eclipse, or command-line tools.
Running the Program

**Using an IDE:**

Clone the repository or download the files.
Import the project into your Java IDE.
Ensure all files are in the ecommerce package.
Run the Main.java class.

Expected Output:
The system processes sample orders and restocking requests. After execution, the following sample output is displayed:

Alert: Product 3 is below the restock threshold.
{1=15, 2=15, 3=22}

**Assumptions**
1.E-Commerce System:

Users can create orders containing multiple products.
Each order is linked to a user and can have statuses like "pending" and "completed."
Payments are processed and linked to orders, changing their status to "completed."

2.Inventory Management:

Stock levels are updated after orders are processed.
If stock levels fall below 10 units for any product, an alert is generated.
Restocking is supported, and stock levels are updated accordingly.

3.Error Handling:

Exceptions are thrown if orders or restocking attempts are made for non-existent products or if stock is insufficient.
Classes and Methods

**ECommerceSystem.java**

User: Represents a user with attributes such as userId, name, and email.
Product: Represents a product with attributes like productId, name, price, and stock.
Order: Manages orders, including adding products and processing payments.
Payment: Manages payments for orders and processes them.

**InventoryManagement.java**

InventoryManagement: Contains the method processOrders() to handle stock level updates after orders.
RestockingSystem: Contains the method restockItems() to manage restocking.
OrderItem: Represents an item in an order (product and quantity).
RestockItem: Represents an item for restocking (product and quantity).

**Conclusion**

This project demonstrates a simplified yet functional e-commerce system with inventory management capabilities. The code follows clean, modular design principles, making it easy to extend and maintain.


