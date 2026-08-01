package com.tan.todo.domain.dto;

import java.util.List;
import java.util.UUID;

public record TasListDto(
        UUID id,
        String title,
        String description,
        Integer count,
        Double progress,
        List<TaskDto> tasks
) {
}
