package cz.lunde.server.controller

import cz.lunde.server.dto.ResponseDto
import org.springframework.http.HttpStatus

import org.springframework.http.ResponseEntity

import org.springframework.web.bind.MethodArgumentNotValidException

import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class GlobalExceptionHandler {
        @ExceptionHandler(MethodArgumentNotValidException::class)
        fun customValidationErrorHanding(exception: MethodArgumentNotValidException): ResponseEntity<*> {
            val errorDetails = ResponseDto(
                exception.bindingResult.fieldError!!.defaultMessage!!
            )
            return ResponseEntity<Any>(errorDetails, HttpStatus.BAD_REQUEST)
        }
}