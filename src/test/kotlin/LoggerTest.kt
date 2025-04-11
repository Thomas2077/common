import com.thomas.common.log.logger
import org.junit.jupiter.api.Test

/**
 * @author yanzou
 * @date   2025/4/11
 * @version V1.0.0
 * @description 
 **/class LoggerTest {
     @Test
     fun logTest() {
         logger().info("test log")
     }
}