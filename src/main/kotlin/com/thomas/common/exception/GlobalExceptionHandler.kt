package com.thomas.common.exception

import com.thomas.common.log.logger
import com.thomas.common.response.ErrorResponse
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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


    @ExceptionHandler
    fun handleDataNotFoundException(
        ex: DataNotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {
        val url = request.requestURL.toString()
        logger().error(url + " : " + ex.message)
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ErrorResponse(400004, ex.message, null, url))
    }


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val url = request.requestURL.toString()
        val errors = ex.bindingResult.fieldErrors.associate {
            it.field to (it.defaultMessage ?: "validtion error")
        }
        return ResponseEntity
            .badRequest()
            .body(ErrorResponse(500001, ex.message, errors, url))
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(ex: RuntimeException, request: HttpServletRequest): ResponseEntity<ErrorResponse> {
        val url = request.requestURL.toString()
        logger().error(url + " : " + ex.message)
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse(500001, ex.message, null, url))
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: HttpServletRequest): ResponseEntity<ErrorResponse> {

        val url = request.requestURL.toString()
        logger().error(url + " : " + ex.message)
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse(500000, ex.message, null, url))
    }
}