package com.lakshman.stock.stockservice.dto;

import java.math.BigDecimal;

public class StockQuoteData {
    private String quote;
    private BigDecimal price;

    public StockQuoteData(String quote, BigDecimal price) {
        this.price = price;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
