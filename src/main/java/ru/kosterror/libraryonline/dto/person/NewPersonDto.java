package ru.kosterror.libraryonline.dto.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class NewPersonDto {

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String patronymic;

    @Schema(example = "2001-12-31", type = "string")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;

}
