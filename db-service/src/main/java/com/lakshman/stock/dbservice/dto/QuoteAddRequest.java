package com.lakshman.stock.dbservice.dto;

import java.util.List;

public class QuoteAddRequest {
    private String userName;
    private List<String> quotes;

    public QuoteAddRequest() {
    }

    public QuoteAddRequest(String userName, List<String> quotes) {
        this.userName = userName;
        this.quotes = quotes;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }
}
