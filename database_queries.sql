-- Query 1: Retrieve the top 5 customers who purchased the most books in the last year
SELECT Customers.customer_id, Customers.name, SUM(OrderDetails.quantity) AS total_books
FROM Customers
JOIN Orders ON Customers.customer_id = Orders.customer_id
JOIN OrderDetails ON Orders.order_id = OrderDetails.order_id
WHERE Orders.order_date >= DATE_SUB(CURDATE(), INTERVAL 1 YEAR)
GROUP BY Customers.customer_id, Customers.name
ORDER BY total_books DESC
LIMIT 5;

-- Query 2: Calculate total revenue generated from book sales by each author
SELECT Books.author, SUM(Books.price * OrderDetails.quantity) AS total_revenue
FROM Books
JOIN OrderDetails ON Books.book_id = OrderDetails.book_id
GROUP BY Books.author
ORDER BY total_revenue DESC;

-- Query 3: Retrieve all books ordered more than 10 times, with total quantity ordered
SELECT Books.book_id, Books.title, SUM(OrderDetails.quantity) AS total_quantity
FROM Books
JOIN OrderDetails ON Books.book_id = OrderDetails.book_id
GROUP BY Books.book_id, Books.title
HAVING total_quantity > 10
ORDER BY total_quantity DESC;
