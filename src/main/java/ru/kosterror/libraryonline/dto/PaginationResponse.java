package ru.kosterror.libraryonline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PaginationResponse<T> {
    private int page;
    private int size;
    private List<T> content;
}
