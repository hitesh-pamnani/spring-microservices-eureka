package com.example.spring.category.client;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.example.spring.category.domain.Journal;

@HttpExchange
public interface JournalClient {
    @GetExchange("/api/journals/categories/{categoryId}")
    public ResponseEntity<List<Journal>> readJournalByCategoryId(@PathVariable UUID categoryId);
}
