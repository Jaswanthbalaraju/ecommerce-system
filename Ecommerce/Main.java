package Ecommerce;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        // Initializing stock levels
        Map<Integer, Integer> stockLevels = new HashMap<>();
        stockLevels.put(1, 20);
        stockLevels.put(2, 15);
        stockLevels.put(3, 5);

        // Creating some orders
        List<OrderItem> orders = Arrays.asList(
            new OrderItem(1, 5),
            new OrderItem(3, 3)
        );

        // Processing the orders
        InventoryManagement inventory = new InventoryManagement();
        stockLevels = inventory.processOrders(stockLevels, orders);

        // Restocking items
        List<RestockItem> restockList = Arrays.asList(
            new RestockItem(3, 20)
        );

        RestockingSystem restockSystem = new RestockingSystem();
        stockLevels = restockSystem.restockItems(stockLevels, restockList);

        // Output the updated stock levels
        System.out.println(stockLevels);
    }
}
