package Ecommerce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InventoryManagement {

    public Map<Integer, Integer> processOrders(Map<Integer, Integer> stockLevels, List<OrderItem> orders) throws Exception {
        for (OrderItem order : orders) {
            int productId = order.getProductId();
            int quantity = order.getQuantity();

            if (stockLevels.containsKey(productId)) {
                int currentStock = stockLevels.get(productId);

                if (currentStock >= quantity) {
                    stockLevels.put(productId, currentStock - quantity);

                    if (stockLevels.get(productId) < 10) {
                        System.out.println("Alert: Product " + productId + " is below the restock threshold.");
                    }
                } else {
                    throw new Exception("Error: Not enough stock for product " + productId);
                }
            } else {
                throw new Exception("Error: Product " + productId + " does not exist.");
            }
        }
        return stockLevels;
    }
}

class RestockingSystem {

    public Map<Integer, Integer> restockItems(Map<Integer, Integer> stockLevels, List<RestockItem> restockList) throws Exception {
        for (RestockItem item : restockList) {
            int productId = item.getProductId();
            int quantity = item.getQuantity();

            if (stockLevels.containsKey(productId)) {
                int currentStock = stockLevels.get(productId);
                stockLevels.put(productId, currentStock + quantity);
            } else {
                throw new Exception("Error: Product " + productId + " does not exist.");
            }
        }
        return stockLevels;
    }
}

class OrderItem {
    private int productId;
    private int quantity;

    public OrderItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

class RestockItem {
    private int productId;
    private int quantity;

    public RestockItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
