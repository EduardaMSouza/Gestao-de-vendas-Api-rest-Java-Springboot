package com.souzamanagement.salesmanagement.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequestDto {
    @NotBlank(message = "The name must not be null/blank")
    @Size(min = 3, max = 50)
    private String name;
    @Email
    private String email;
    @NotBlank(message = "The password must not be null/blank")
    @Size(min = 8, max = 12, message = "The password must have between 8 and 12 characters")
    private String password;
}
