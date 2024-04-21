package ru.kosterror.libraryonline.dto.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PersonDto {

    private UUID id;

    private String name;

    private String surname;

    private String patronymic;

    @Schema(example = "2001-12-31", type = "string")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

}
