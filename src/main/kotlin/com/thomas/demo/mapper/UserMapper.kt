package com.thomas.demo.mapper

import com.thomas.demo.entity.User
import com.thomas.demo.model.UserDto
import org.mapstruct.Mapper

/**
 * @author yanzou
 * @date   2025/4/14
 * @version V1.0.0
 * @description
 **/
@Mapper(componentModel = "spring")
interface UserMapper {

    fun toDto(entity: User): UserDto

    fun toEntity(dto: UserDto): User
}