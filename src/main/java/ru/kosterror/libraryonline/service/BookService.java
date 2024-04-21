package ru.kosterror.libraryonline.service;

import ru.kosterror.libraryonline.dto.PaginationResponse;
import ru.kosterror.libraryonline.dto.book.BookDto;
import ru.kosterror.libraryonline.dto.book.NewBookDto;
import ru.kosterror.libraryonline.dto.book.UpdateBookDto;

import java.util.UUID;

public interface BookService {
    BookDto createBook(NewBookDto newBookDto);

    BookDto getById(UUID id);

    BookDto updateBook(UUID id, UpdateBookDto updateBookDto);

    PaginationResponse<BookDto> getBookPage(int page, int size);
}
