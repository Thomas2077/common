package com.thomas.common.log

@Suppress("unused")
object LoggerRef {
    fun reference() {
        "force".logger().info("Logger referenced")
    }
}
