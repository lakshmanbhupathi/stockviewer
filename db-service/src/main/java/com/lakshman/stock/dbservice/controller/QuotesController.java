package com.lakshman.stock.dbservice.controller;

import com.lakshman.stock.dbservice.dto.QuoteAddRequest;
import com.lakshman.stock.dbservice.entity.Quote;
import com.lakshman.stock.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class QuotesController {

    private QuotesRepository quotesRepository;

    public QuotesController(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable final String username) {
        return getQuote(username);
    }

    private List<String> getQuote(String username) {
        return quotesRepository.findByUserName(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public List<String> addUser(@RequestBody final QuoteAddRequest request) {

        request.getQuotes()
                .stream()
                .map(quote -> new Quote(request.getUserName(), quote))
                .forEach(quote -> quotesRepository.save(quote));

        return getQuote(request.getUserName());
    }
}
