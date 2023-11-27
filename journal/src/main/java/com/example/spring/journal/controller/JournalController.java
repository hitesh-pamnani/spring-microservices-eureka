package com.example.spring.journal.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.journal.domain.Journal;
import com.example.spring.journal.service.JournalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/journals")
@Validated
public class JournalController {

    @Autowired
    private JournalService journalService;

    @PostMapping
    public ResponseEntity<Journal> create(@RequestBody @Valid Journal journalBody){
        Journal journalResponse = journalService.create(journalBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(journalResponse);
    }

    @GetMapping("/{journalId}")
    public ResponseEntity<Journal> readJournalById(@PathVariable UUID journalId){
        Journal journalResponse = journalService.readJournalById(journalId);
        return ResponseEntity.status(HttpStatus.OK).body(journalResponse);
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<List<Journal>> readJournalByCategoryId(@PathVariable UUID categoryId){
        List<Journal> journals = journalService.readJournalByCategoryId(categoryId);
        return ResponseEntity.status(HttpStatus.OK).body(journals);
    }
}
