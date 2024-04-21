package ru.kosterror.libraryonline.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kosterror.libraryonline.dto.PaginationResponse;
import ru.kosterror.libraryonline.dto.person.NewPersonDto;
import ru.kosterror.libraryonline.dto.person.PersonDto;
import ru.kosterror.libraryonline.dto.person.ReadingPersonDto;
import ru.kosterror.libraryonline.dto.person.UpdatePersonDto;
import ru.kosterror.libraryonline.entity.PersonBookEntity;
import ru.kosterror.libraryonline.entity.PersonEntity;
import ru.kosterror.libraryonline.exception.NotFoundException;
import ru.kosterror.libraryonline.mapper.PersonMapper;
import ru.kosterror.libraryonline.repository.PersonBookRepository;
import ru.kosterror.libraryonline.repository.PersonRepository;
import ru.kosterror.libraryonline.service.PersonService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    public static final String SURNAME = "surname";
    public static final String NAME = "name";
    public static final String PATRONYMIC = "patronymic";

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final PersonBookRepository personBookRepository;

    @Override
    @Transactional
    public PersonDto createPerson(NewPersonDto newPersonDto) {

        PersonEntity personEntity = personMapper.dtoToEntity(newPersonDto);
        personEntity = personRepository.save(personEntity);

        return personMapper.entityToDto(personEntity);
    }

    @Override
    public PersonDto getById(UUID id) {
        PersonEntity personEntity = findPersonById(id);
        return personMapper.entityToDto(personEntity);
    }

    @Override
    public PersonDto updatePerson(UUID id, UpdatePersonDto updatePersonDto) {
        PersonEntity personEntity = findPersonById(id);

        personEntity.setName(updatePersonDto.getName());
        personEntity.setSurname(updatePersonDto.getSurname());
        personEntity.setPatronymic(updatePersonDto.getPatronymic());
        personEntity.setBirthdate(updatePersonDto.getBirthdate());
        personEntity = personRepository.save(personEntity);

        return personMapper.entityToDto(personEntity);
    }

    @Override
    public PaginationResponse<PersonDto> getPersonPage(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, SURNAME, NAME, PATRONYMIC);
        Page<PersonEntity> personPage = personRepository.findAll(pageRequest);

        List<PersonDto> persons = personPage.getContent()
                .stream()
                .map(personMapper::entityToDto)
                .collect(Collectors.toList());

        return new PaginationResponse<>(personPage.getNumber(), personPage.getSize(), persons);
    }

    @Override
    public PersonEntity findPersonById(UUID id) {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Person with id '%s' was not found", id)));
    }

    @Override
    public List<ReadingPersonDto> getReadingPersons() {
        List<PersonBookEntity> entities = personBookRepository.findAll();

        return entities.stream()
                .map(personMapper::personBookEntityToReadingPerson)
                .collect(Collectors.toList());
    }

}
