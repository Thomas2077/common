package com.thomas.common.exception

import com.thomas.common.log.logger
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpRequest
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
    fun handleRuntimeException(ex: RuntimeException, request: HttpServletRequest): ResponseEntity<String> {
        val url = request.requestURL.toString()
        logger().error(url + " : " + ex.message)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("")
    }

    @ExceptionHandler
    fun handleDataNotFoundException(ex: DataNotFoundException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("")
    }

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception, request: HttpServletRequest): ResponseEntity<String> {
        val url = request.requestURL.toString()
        logger().error(url + " : " + ex.message)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("")
    }
}