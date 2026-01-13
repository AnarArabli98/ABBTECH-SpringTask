package com.anararabli.abbtech.exception;

public record BaseErrorResponseDTO(String code, String message, String path, String timestamp,
                                   Integer status, Object... data) {
}
