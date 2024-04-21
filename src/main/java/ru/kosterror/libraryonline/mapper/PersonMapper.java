package ru.kosterror.libraryonline.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.kosterror.libraryonline.dto.person.NewPersonDto;
import ru.kosterror.libraryonline.dto.person.PersonDto;
import ru.kosterror.libraryonline.dto.person.ReadingPersonDto;
import ru.kosterror.libraryonline.entity.PersonBookEntity;
import ru.kosterror.libraryonline.entity.PersonEntity;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface PersonMapper {

    PersonEntity dtoToEntity(NewPersonDto dto);

    PersonDto entityToDto(PersonEntity entity);

    ReadingPersonDto personBookEntityToReadingPerson(PersonBookEntity entity);

}
