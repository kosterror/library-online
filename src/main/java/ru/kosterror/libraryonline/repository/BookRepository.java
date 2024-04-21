package ru.kosterror.libraryonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kosterror.libraryonline.entity.BookEntity;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    boolean existsByIsbn(String isbn);

}
