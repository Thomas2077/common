package com.thomas.demo.controller

import com.thomas.demo.service.UserService
import com.thomas.demo.model.Order
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

/**
 * @author yanzou
 * @date   2025/4/11
 * @version V1.0.0
 * @description
 **/
@RestController
@RequestMapping("/order")
class OrderController(private var userService: UserService) {

    @GetMapping("/{id}")
    fun getOrder(@PathVariable id: Long): Order {
        return Order(1L, LocalDateTime.now());
    }
}