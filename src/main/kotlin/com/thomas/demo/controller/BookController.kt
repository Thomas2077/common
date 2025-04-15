package com.thomas.demo.controller

import com.thomas.demo.model.Book
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author thomas
 * @date   2024/02/24
 * @version V1.0.0
 * @description
 **/
@RequestMapping("/books")
@RestController
class BookController {

    private var books = mutableListOf<Book>()

    @GetMapping
    fun getAllBooks(): List<Book> {

        return books
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): Book? = books.find { it.id == id }


}