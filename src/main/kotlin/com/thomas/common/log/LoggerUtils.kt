package com.thomas.common.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author yanzou
 * @date   2025/4/11
 * @version V1.0.0
 * @description
 **/
inline fun <reified T> T.logger(): Logger = LoggerFactory.getLogger(T::class.java)