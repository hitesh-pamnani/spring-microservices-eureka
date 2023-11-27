package com.example.spring.category.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.category.entity.JpaCategory;

public interface JpaCategoryRepository extends JpaRepository<JpaCategory, UUID> {}
