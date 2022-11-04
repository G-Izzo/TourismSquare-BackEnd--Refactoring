package it.ibs.tourismsquare.model.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MessageResponse {

	@NotNull private final String message;
	
}
