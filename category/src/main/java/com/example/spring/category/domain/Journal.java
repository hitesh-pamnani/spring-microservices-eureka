package com.example.spring.category.domain;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class Journal {
    private UUID id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    private UUID categoryId;

    @NotNull
    private UUID userId;
}
