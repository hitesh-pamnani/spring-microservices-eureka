package com.example.spring.category.controller;

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

import com.example.spring.category.client.JournalClient;
import com.example.spring.category.domain.Category;
import com.example.spring.category.domain.Journal;
import com.example.spring.category.service.CategoryService;
import com.example.spring.category.viewmodel.CategoryJournalViewModel;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private JournalClient journalClient;

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid Category categoryBody){
        Category categoryResponse = categoryService.create(categoryBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponse);
    }

    @GetMapping
    public ResponseEntity<List<Category>> readAllCategories(){
        List<Category> categories = categoryService.readAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{categoryId}/journals")
    public ResponseEntity<CategoryJournalViewModel> readJournals(@PathVariable UUID categoryId){
        Category category = categoryService.readCategoryById(categoryId);
        List<Journal> journals = journalClient.readJournalByCategoryId(categoryId).getBody();
        CategoryJournalViewModel viewModel = new CategoryJournalViewModel();
        viewModel.setId(categoryId);
        viewModel.setName(category.getName());
        viewModel.setJournals(journals);
        return ResponseEntity.status(HttpStatus.OK).body(viewModel);
    }

}
