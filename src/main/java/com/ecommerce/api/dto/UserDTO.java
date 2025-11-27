package com.ecommerce.api.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        Long id,
        @NotBlank
        String email,
        @NotBlank
        String password,
        String role
) {
}
