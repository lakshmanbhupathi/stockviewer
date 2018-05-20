package com.lakshman.stock.stockservice.controller;


import com.lakshman.stock.stockservice.dto.StockQuoteData;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/stock")
public class StockController {

    private RestTemplate restTemplate;

    public StockController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{username}")
    public List<StockQuoteData> getStocksFromUserName(@PathVariable("username") final String userName){

        ResponseEntity<List<String>> quoteResponse  = restTemplate.exchange("http://db-service/rest/db/quote/"+userName,
                HttpMethod.GET,null, new ParameterizedTypeReference<List<String>>(){});
        List<String> quotes = quoteResponse.getBody();

        return quotes.stream()
                .map(quote -> {
                    return getQuotePrices(quote);
                }).collect(Collectors.toList());
    }

    private StockQuoteData getQuotePrices(String quote) {
        return new StockQuoteData(quote,getStocks(quote).getQuote().getPrice());
    }

    private Stock getStocks(String quote) {
        try {
            return YahooFinance.get(quote);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
