package com.app.App.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Debt {
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    private Long sum;
    private LocalDate expiryDate;
    @ManyToOne(optional = false)
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
