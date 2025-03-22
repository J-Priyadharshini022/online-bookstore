package com.bookstore.bookstore_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    private int quantity;

    // Default constructor
    public Cart() {}

    // Parameterized constructor
    public Cart(Long id, User user, Book book, int quantity) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.quantity = quantity;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString() method
    @Override
    public String toString() {
        return "Cart [id=" + id + ", user=" + (user != null ? user.getName() : "N/A") + 
               ", book=" + (book != null ? book.getTitle() : "N/A") + 
               ", quantity=" + quantity + "]";
    }
}
