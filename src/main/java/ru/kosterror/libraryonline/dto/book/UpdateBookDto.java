package ru.kosterror.libraryonline.dto.book;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateBookDto {

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @NotBlank
    private String isbn;
}
