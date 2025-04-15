package com.thomas.demo.service

import com.thomas.common.exception.DataNotFoundException
import com.thomas.demo.mapper.UserMapper
import com.thomas.demo.model.UserDto
import com.thomas.demo.repository.UserRepository
import org.springframework.stereotype.Service

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@Service
class UserService(
    private var userRepository: UserRepository,
    private var userMapper: UserMapper
) {
    fun getUser(id: Long): UserDto {

        val user = userRepository
            .findById(id)
            .orElseThrow { DataNotFoundException("user not found") }
        return userMapper.toDto(user)
    }

    fun saveUser(userDto: UserDto): UserDto{
        val user = userRepository.save(userMapper.toEntity(userDto))
        return userMapper.toDto(user)
    }
}