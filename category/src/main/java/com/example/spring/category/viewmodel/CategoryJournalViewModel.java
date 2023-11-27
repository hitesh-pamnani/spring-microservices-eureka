package com.example.spring.category.viewmodel;

import java.util.List;
import java.util.UUID;

import com.example.spring.category.domain.Journal;

import lombok.Data;

@Data
public class CategoryJournalViewModel {
    private UUID id;
    private String name;
    private List<Journal> journals;
}
