package ru.kosterror.libraryonline.dto.book;

import lombok.Data;

@Data
public class NewBookDto {
    private String name;
    private String author;
    private String isbn;
}
