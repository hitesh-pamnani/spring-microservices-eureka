package com.example.spring.journal.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.journal.entity.JpaJournal;

public interface JpaJournalRepository extends JpaRepository<JpaJournal, UUID> {
    List<JpaJournal> findByUserId(UUID userId);

    List<JpaJournal> findByCategoryId(UUID categoryId);
}
