package com.microservices.spring.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginDto {
    @NotNull
    String username;
    @NotNull
    String password;
}
