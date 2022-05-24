package com.pellewielinga.example.context

import mu.KotlinLogging
import org.slf4j.Logger
import java.nio.file.Path
import kotlin.io.path.readLines

fun main() {
    val log = KotlinLogging.logger { }

    greetPeople(log, "Hello Amsterdam!")
    readOutRandomFact(log)
}

fun greetPeople(log: Logger, message: String) {
    log.info(message)
}

fun readOutRandomFact(log: Logger) {
    val interestingFact = Path.of("./facts.txt").readLines().random()
    log.info(interestingFact)
}
