package ru.kosterror.libraryonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kosterror.libraryonline.entity.PersonEntity;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
