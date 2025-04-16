package com.thomas.demo.entity

import jakarta.persistence.*
import java.io.Serializable


/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/

@Entity
@Table(name = "users")
data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    val id: Long? = null,

    @Column(name = "NAME")
    var name: String = ""
) : Serializable