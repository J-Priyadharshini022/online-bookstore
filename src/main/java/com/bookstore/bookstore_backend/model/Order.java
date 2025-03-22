package com.bookstore.bookstore_backend.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection  // Stores list of book IDs directly in the Order table
    private List<Long> bookIds;

    @ElementCollection  // Stores quantities of books ordered
    private List<Integer> quantities;

    private double totalPrice;
    
    @Column(nullable = false)
    private String address;  // Shipping address

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    
    private LocalDateTime orderDate;
    
    @Enumerated(EnumType.STRING) 
    private PaymentMethod paymentMethod;

    // Constructors
    public Order() {
    }

    public Order(Long id, User user, List<Long> bookIds, List<Integer> quantities, double totalPrice,
                 String address, OrderStatus status, LocalDateTime orderDate, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.bookIds = bookIds;
        this.quantities = quantities;
        this.totalPrice = totalPrice;
        this.address = address;
        this.status = status;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order {" +
                "id=" + id +
                ", user=" + user +
                ", bookIds=" + bookIds +
                ", quantities=" + quantities +
                ", totalPrice=" + totalPrice +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}