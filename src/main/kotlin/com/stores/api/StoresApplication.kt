package com.stores.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
