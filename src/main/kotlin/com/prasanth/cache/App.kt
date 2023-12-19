package com.prasanth.cache


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class App {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            runApplication<App>(*args)
        }
    }
}
