package Ecommerce;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ECommerceSystem {
    public static void main(String[] args) {
        User user = new User(1, "John Doe", "john@example.com");
        Product product = new Product(1, "Laptop", 1500.00, 50);
        Order order = new Order(1, user);
        order.addProduct(product);
        
        Payment payment = new Payment(1, order, 1500.00);
        payment.processPayment(new Date());
        
        System.out.println("Order for user " + user + " completed.");
    }
}

class User {
    private int userId;
    private String name;
    private String email;
    private List<Order> orders;

    public User(int userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public void createOrder(Order order) {
        this.orders.add(order);
    }
}

class Product {
    private int productId;
    private String name;
    private double price;
    private int stock;

    public Product(int productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class Order {
    private int orderId;
    private User user;
    private List<Product> products;
    private String status;
    private Payment payment;

    public Order(int orderId, User user) {
        this.orderId = orderId;
        this.user = user;
        this.products = new ArrayList<>();
        this.status = "pending";
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void completeOrder() {
        this.status = "completed";
    }
}

class Payment {
    private int paymentId;
    private Order order;
    private double amount;
    private Date paymentDate;
    private String status;

    public Payment(int paymentId, Order order, double amount) {
        this.paymentId = paymentId;
        this.order = order;
        this.amount = amount;
        this.status = "pending";
    }

    public void processPayment(Date paymentDate) {
        this.paymentDate = paymentDate;
        this.status = "completed";
        this.order.completeOrder();
    }
}
