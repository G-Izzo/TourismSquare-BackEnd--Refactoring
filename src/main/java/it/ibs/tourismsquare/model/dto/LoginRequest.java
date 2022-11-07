package it.ibs.tourismsquare.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginRequest {
	
	@NotNull @NotBlank @Email private final String email;
	@NotNull @NotBlank private final String password;
}
