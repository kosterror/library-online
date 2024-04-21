package ru.kosterror.libraryonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kosterror.libraryonline.entity.PersonBookEntity;

import java.util.UUID;

public interface PersonBookRepository extends JpaRepository<PersonBookEntity, UUID> {
}
