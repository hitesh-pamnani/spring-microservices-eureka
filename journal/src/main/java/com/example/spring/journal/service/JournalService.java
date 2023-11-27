package com.example.spring.journal.service;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.journal.domain.Journal;
import com.example.spring.journal.entity.JpaJournal;
import com.example.spring.journal.repository.JpaJournalRepository;

@Service
public class JournalService {

    @Autowired
    private JpaJournalRepository jpaJournalRepository;

    private ModelMapper modelMapper;

    public JournalService() {
        modelMapper = new ModelMapper();
    }

    public Journal create(Journal journal){
        JpaJournal jpaJournal = jpaJournalRepository.save(modelMapper.map(journal, JpaJournal.class));
        return modelMapper.map(jpaJournal, Journal.class);
    }

    public Journal readJournalById(UUID journalId){
        JpaJournal jpaJournal = jpaJournalRepository.findById(journalId).orElse(null);
        return modelMapper.map(jpaJournal, Journal.class);
    }

    public List<Journal> readJournalByUserId(UUID userId){
        List<JpaJournal> jpaJournals = jpaJournalRepository.findByUserId(userId);
        return jpaJournals.stream()
                          .map((jpaJournal -> modelMapper.map(jpaJournal, Journal.class)))
                          .toList();
    }

    public List<Journal> readJournalByCategoryId(UUID categoryId){
        List<JpaJournal> jpaJournals = jpaJournalRepository.findByCategoryId(categoryId);
        return jpaJournals.stream()
                          .map((jpaJournal -> modelMapper.map(jpaJournal, Journal.class)))
                          .toList();
    }
}
