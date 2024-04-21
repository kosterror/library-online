package ru.kosterror.libraryonline.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kosterror.libraryonline.dto.PaginationResponse;
import ru.kosterror.libraryonline.dto.book.BookDto;
import ru.kosterror.libraryonline.dto.book.NewBookDto;
import ru.kosterror.libraryonline.dto.book.UpdateBookDto;
import ru.kosterror.libraryonline.entity.BookEntity;
import ru.kosterror.libraryonline.exception.ConflictException;
import ru.kosterror.libraryonline.exception.NotFoundException;
import ru.kosterror.libraryonline.mapper.BookMapper;
import ru.kosterror.libraryonline.repository.BookRepository;
import ru.kosterror.libraryonline.service.BookService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private static final String NAME = "name";
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public BookDto createBook(NewBookDto newBookDto) {
        checkIsbnForExist(newBookDto.getIsbn());

        BookEntity bookEntity = bookMapper.dtoToEntity(newBookDto);
        bookEntity = bookRepository.save(bookEntity);

        return bookMapper.entityToDto(bookEntity);
    }

    @Override
    public BookDto getById(UUID id) {
        BookEntity bookEntity = findBookById(id);
        return bookMapper.entityToDto(bookEntity);
    }

    @Override
    @Transactional
    public BookDto updateBook(UUID id, UpdateBookDto updateBookDto) {
        BookEntity bookEntity = findBookById(id);

        if (!Objects.equals(bookEntity.getIsbn(), updateBookDto.getIsbn())) {
            checkIsbnForExist(updateBookDto.getIsbn());
        }

        bookEntity.setName(updateBookDto.getName());
        bookEntity.setAuthor(updateBookDto.getAuthor());
        bookEntity.setIsbn(updateBookDto.getIsbn());
        bookEntity = bookRepository.save(bookEntity);

        return bookMapper.entityToDto(bookEntity);
    }

    @Override
    public PaginationResponse<BookDto> getBookPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, NAME);
        Page<BookEntity> bookPage = bookRepository.findAll(pageRequest);

        List<BookDto> books = bookPage.getContent()
                .stream()
                .map(bookMapper::entityToDto)
                .collect(Collectors.toList());

        return new PaginationResponse<>(bookPage.getNumber(), bookPage.getSize(), books);
    }

    private BookEntity findBookById(UUID id) {
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Book with id '%s' was not found", id)));
    }

    private void checkIsbnForExist(String isbn) {
        if (bookRepository.existsByIsbn(isbn)) {
            throw new ConflictException(
                    String.format("The book with isbn '%s' already exists", isbn)
            );
        }
    }

}
