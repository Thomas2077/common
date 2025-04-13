package com.thomas.common.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * @author yanzou
 * @date   2025/4/13
 * @version V1.0.0
 * @description
 **/
@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("")
    }

    @ExceptionHandler
    fun handleDataNotFoundException(ex: DataNotFoundException) : ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("")
    }
}