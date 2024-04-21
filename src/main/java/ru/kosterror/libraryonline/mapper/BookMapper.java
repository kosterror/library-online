package ru.kosterror.libraryonline.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.kosterror.libraryonline.dto.book.BookDto;
import ru.kosterror.libraryonline.dto.book.NewBookDto;
import ru.kosterror.libraryonline.entity.BookEntity;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookMapper {

    BookEntity dtoToEntity(NewBookDto dto);

    BookDto entityToDto(BookEntity entity);

}
