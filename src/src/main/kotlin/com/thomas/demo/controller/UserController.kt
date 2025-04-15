package com.thomas.demo.controller

import com.thomas.demo.service.UserService
import com.thomas.demo.model.UserDto
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@RestController
@RequestMapping("/user")
class UserController(private var userService: UserService) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Long): ResponseEntity<UserDto> {
        return ResponseEntity.ok(userService.getUser(id))
    }

    @PostMapping
    fun saveUser(@Valid @RequestBody userDto: UserDto): ResponseEntity<UserDto> {
        return ResponseEntity.ok(userService.saveUser(userDto))
    }
}