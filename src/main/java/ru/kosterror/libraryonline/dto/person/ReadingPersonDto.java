package ru.kosterror.libraryonline.dto.person;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.kosterror.libraryonline.dto.book.BookDto;

import java.util.Date;

@Data
public class ReadingPersonDto {

    private PersonDto person;

    private BookDto book;

    @Schema(example = "2001-12-31", type = "string")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date takenDate;

}
