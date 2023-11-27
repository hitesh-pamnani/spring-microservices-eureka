package com.example.spring.category.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.category.domain.Category;
import com.example.spring.category.entity.JpaCategory;
import com.example.spring.category.repository.JpaCategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private JpaCategoryRepository jpaCategoryRepository;

    private ModelMapper modelMapper;

    public CategoryService() {
        modelMapper = new ModelMapper();
    }

    public Category create(Category category){
        JpaCategory jpaCategory = jpaCategoryRepository.save(modelMapper.map(category, JpaCategory.class));
        return modelMapper.map(jpaCategory, Category.class);
    }

    public Category readCategoryById(UUID id){
        JpaCategory jpaCategory = jpaCategoryRepository.findById(id).orElse(null);
        return modelMapper.map(jpaCategory, Category.class);
    }

    public List<Category> readAllCategories(){
        List<JpaCategory> jpaCategories = jpaCategoryRepository.findAll();
        return jpaCategories.stream()
                            .map(jpaCategory -> modelMapper.map(jpaCategory, Category.class))
                            .toList();
    }
}
