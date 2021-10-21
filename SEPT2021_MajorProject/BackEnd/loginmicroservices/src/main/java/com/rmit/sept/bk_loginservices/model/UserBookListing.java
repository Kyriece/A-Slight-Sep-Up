package com.rmit.sept.bk_loginservices.model;

import javax.persistence.*;


@Entity
@Table(name = "userbooklisting")
public class UserBookListing {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long userID;

    @Column(nullable = false)
    private Long bookID;

    @Column(nullable = false)
    private Double bookPrice;

    public UserBookListing() {}

    public UserBookListing(Long userID, Long bookID, Double bookPrice) {
        this.userID = userID;
        this.bookID = bookID;
        this.bookPrice = bookPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
