package ru.kosterror.libraryonline.dto.book;

import lombok.Data;

@Data
public class UpdateBookDto {
    private String name;
    private String author;
    private String isbn;
}
