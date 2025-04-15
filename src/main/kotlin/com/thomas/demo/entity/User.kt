package com.thomas.demo.entity

import jakarta.persistence.*


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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ 推荐使用 IDENTITY 或 AUTO
    @Column(name = "ID")
    var id: Long? = null

    @Column(name = "NAME", nullable = true)
    var name: String = ""
}