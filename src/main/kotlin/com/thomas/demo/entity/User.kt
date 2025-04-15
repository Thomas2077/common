package com.thomas.demo.entity

import jakarta.persistence.*
import org.springframework.boot.autoconfigure.domain.EntityScan

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@Table(name = "users")
@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq")
    @Column(name = "ID", nullable = false)
    var id: Long? = null

    @Column(name = "NAME", nullable = true)
    var name: String = ""
}