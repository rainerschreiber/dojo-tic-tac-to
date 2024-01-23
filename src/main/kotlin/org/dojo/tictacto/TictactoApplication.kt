package org.dojo.tictacto

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TictactoApplication

fun main(args: Array<String>) {
    runApplication<TictactoApplication>(*args)
}
