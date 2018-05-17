package com.lakshman.stock.dbservice.entity;

import javax.persistence.*;

@Entity
@Table(name= "Quotes" , catalog = "stockviewer")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "quote")
    private String quote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
