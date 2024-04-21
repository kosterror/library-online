package ru.kosterror.libraryonline.service;

import ru.kosterror.libraryonline.dto.PaginationResponse;
import ru.kosterror.libraryonline.dto.person.NewPersonDto;
import ru.kosterror.libraryonline.dto.person.PersonDto;
import ru.kosterror.libraryonline.dto.person.UpdatePersonDto;

import java.util.UUID;

public interface PersonService {
    PersonDto createPerson(NewPersonDto newPersonDto);

    PersonDto getById(UUID id);

    PersonDto updatePerson(UUID id, UpdatePersonDto updatePersonDto);

    PaginationResponse<PersonDto> getPersonPage(int page, int size);
}
