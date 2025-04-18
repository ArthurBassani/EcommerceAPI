package dev.arthur.EcommerceAPI.controllers.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestErrorMessage {
    private HttpStatus httpStatus;
    private String message;
}
