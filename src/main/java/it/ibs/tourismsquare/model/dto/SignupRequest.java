package it.ibs.tourismsquare.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class SignupRequest {

    @NotBlank
    private String username;
 
    @NotBlank
    @Email
    private String email;
    
    @NotBlank
    private String password;
}
