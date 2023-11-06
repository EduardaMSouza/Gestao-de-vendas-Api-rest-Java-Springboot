package com.souzamanagement.salesmanagement.dto.category;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDto {
    @NotBlank(message = "The name must not be null/blank")
    private String name;
}
