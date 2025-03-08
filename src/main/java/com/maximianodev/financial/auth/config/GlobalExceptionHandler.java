package com.maximianodev.financial.auth.config;

import static com.maximianodev.financial.auth.utils.Constants.ErrorMessages.ERROR_GENERIC;

import com.maximianodev.financial.auth.dto.GenericResponse;
import com.maximianodev.financial.auth.exception.BadRequestException;
import com.maximianodev.financial.auth.exception.InternalServerErrorException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<GenericResponse> handleBadRequestException(BadRequestException exception) {
    GenericResponse errorResponse = new GenericResponse(exception.getMessage());

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
  }

  @ExceptionHandler(ExpiredJwtException.class)
  public ResponseEntity<GenericResponse> handleExpiredJwtException(ExpiredJwtException exception) {
    GenericResponse errorResponse = new GenericResponse(exception.getMessage());

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
  }

  @ExceptionHandler(JwtException.class)
  public ResponseEntity<GenericResponse> handleJwtException(JwtException exception) {
    GenericResponse errorResponse = new GenericResponse(exception.getMessage());

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
  }

  @ExceptionHandler(InternalServerErrorException.class)
  public ResponseEntity<GenericResponse> handleInternalServerErrorException(
      InternalServerErrorException exception) {
    GenericResponse errorResponse = new GenericResponse(exception.getMessage());

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }

  @ExceptionHandler
  public ResponseEntity<GenericResponse> handleInternalServerErrorException(Exception exception) {
    GenericResponse errorResponse = new GenericResponse(ERROR_GENERIC);

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
  }
}
