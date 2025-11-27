package com.ecommerce.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        @NotBlank
        String name,
        String description,
        @NotNull
        @Positive
        BigDecimal price,
        @Min(value = 0)
        Integer stock
) {
}
