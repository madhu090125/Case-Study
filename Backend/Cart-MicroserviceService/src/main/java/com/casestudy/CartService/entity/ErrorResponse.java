package com.casestudy.CartService.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

	private HttpStatus statusmessage;
	private String message;
	private LocalDateTime datetime;


}
