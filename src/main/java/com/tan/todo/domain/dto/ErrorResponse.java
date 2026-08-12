package com.tan.todo.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
