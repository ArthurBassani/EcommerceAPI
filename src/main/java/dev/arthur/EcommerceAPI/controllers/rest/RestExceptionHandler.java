package dev.arthur.EcommerceAPI.controllers.rest;

import dev.arthur.EcommerceAPI.exceptions.cart.CartNotFoundException;
import dev.arthur.EcommerceAPI.exceptions.product.ProductNotFoundException;
import dev.arthur.EcommerceAPI.exceptions.product.ProductUpdateException;
import dev.arthur.EcommerceAPI.exceptions.role.RoleAlmostExistsException;
import dev.arthur.EcommerceAPI.exceptions.role.RoleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RoleNotFoundException.class)
    private ResponseEntity<RestErrorMessage> roleNotFoundHandler(RoleNotFoundException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage()
        );
        return ResponseEntity.status(errorMessage.getHttpStatus()).body(errorMessage);
    }

    @ExceptionHandler(RoleAlmostExistsException.class)
    private ResponseEntity<RestErrorMessage> roleAlmostExistsHandler(RoleAlmostExistsException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage()
        );
        return ResponseEntity.status(errorMessage.getHttpStatus()).body(errorMessage);
    }

    @ExceptionHandler(ProductUpdateException.class)
    private ResponseEntity<RestErrorMessage> productUpdateException(ProductUpdateException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(
                HttpStatus.BAD_REQUEST, exception.getMessage()
        );
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<RestErrorMessage> productNotFoundException(ProductNotFoundException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage()
        );
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(CartNotFoundException.class)
    private ResponseEntity<RestErrorMessage> cartNotFoundException(CartNotFoundException exception){
        RestErrorMessage errorMessage = new RestErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage()
        );
        return ResponseEntity.badRequest().body(errorMessage);
    }

}
