package ru.kosterror.libraryonline.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kosterror.libraryonline.dto.PaginationResponse;
import ru.kosterror.libraryonline.dto.person.NewPersonDto;
import ru.kosterror.libraryonline.dto.person.PersonDto;
import ru.kosterror.libraryonline.dto.person.ReadingPersonDto;
import ru.kosterror.libraryonline.dto.person.UpdatePersonDto;
import ru.kosterror.libraryonline.service.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @Operation(summary = "Create new person")
    @PostMapping("/persons")
    public PersonDto createPerson(@RequestBody @Valid NewPersonDto newPersonDto) {
        return personService.createPerson(newPersonDto);
    }

    @Operation(summary = "Get person by id")
    @GetMapping("/persons/{id}")
    public PersonDto getPersonById(@PathVariable UUID id) {
        return personService.getById(id);
    }

    @Operation(summary = "Update person")
    @PutMapping("/persons/{id}")
    public PersonDto updatePerson(@PathVariable UUID id,
                                  @RequestBody @Valid UpdatePersonDto updatePersonDto
    ) {
        return personService.updatePerson(id, updatePersonDto);
    }

    @Operation(summary = "Get page of persons")
    @GetMapping("/persons")
    public PaginationResponse<PersonDto> getPersonPage(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size
    ) {
        return personService.getPersonPage(page, size);
    }

    @Operation(summary = "Get all reading persons")
    @GetMapping("/reading-persons")
    public List<ReadingPersonDto> getReadingPersons() {
        return personService.getReadingPersons();
    }

}
