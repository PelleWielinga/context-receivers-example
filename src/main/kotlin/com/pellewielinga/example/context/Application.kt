package com.pellewielinga.example.context

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import com.pellewielinga.example.context.appointments.AppointmentRepository
import com.pellewielinga.example.context.appointments.AppointmentService
import com.pellewielinga.example.context.plugins.configureRouting

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") { module() }
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    install(Authentication) {
        jwt {
            // Configure jwt authentication
        }
    }

    val appointmentRepository = AppointmentRepository()
    val appointmentService = AppointmentService(appointmentRepository)

    configureRouting(appointmentService)
}