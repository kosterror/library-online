package ru.kosterror.libraryonline.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.libraryonline.dto.PaginationResponse;
import ru.kosterror.libraryonline.dto.book.BookDto;
import ru.kosterror.libraryonline.dto.book.NewBookDto;
import ru.kosterror.libraryonline.dto.book.UpdateBookDto;
import ru.kosterror.libraryonline.service.BookService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Operation(summary = "Create new book")
    @PostMapping
    public BookDto createBook(@RequestBody @Valid NewBookDto newBookDto) {
        return bookService.createBook(newBookDto);
    }

    @Operation(summary = "Get book by id")
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable UUID id) {
        return bookService.getById(id);
    }

    @Operation(summary = "Update book")
    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable UUID id,
                              @RequestBody @Valid UpdateBookDto updateBookDto
    ) {
        return bookService.updateBook(id, updateBookDto);
    }

    @Operation(summary = "Get page of books")
    @GetMapping
    public PaginationResponse<BookDto> getBookPage(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size
    ) {
        return bookService.getBookPage(page, size);
    }

}
