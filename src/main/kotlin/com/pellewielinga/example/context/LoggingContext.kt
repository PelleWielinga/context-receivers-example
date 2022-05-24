package com.pellewielinga.example.context

import mu.KotlinLogging
import org.slf4j.Logger
import java.nio.file.Path
import kotlin.io.path.readLines

fun main() {
    val log = KotlinLogging.logger { }

    val loggingContext = object : LoggingContext {
        override val log = log
    }

    with(loggingContext) {
        greetPeople("Hello Amsterdam!")
        readOutRandomFact()
    }
}

interface LoggingContext {
    val log: Logger
}

context(LoggingContext)
fun greetPeople(message: String) {
    log.info(message)
}

context(LoggingContext)
fun readOutRandomFact() {
    val interestingFact = Path.of("./facts.txt").readLines().random()
    log.info(interestingFact)
}
