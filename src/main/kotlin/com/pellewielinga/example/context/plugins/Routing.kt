package com.pellewielinga.example.context.plugins

import com.pellewielinga.example.context.appointments.Appointment
import com.pellewielinga.example.context.appointments.AppointmentService
import com.pellewielinga.example.context.users.withAuthenticatedUser
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(
    appointmentService: AppointmentService
) {
    routing {
        authenticate("auth-jwt") {
            get("/appointments") {
                call.withAuthenticatedUser {
                    val appointments = appointmentService.getAppointments()
                    call.respond(appointments)
                }
            }

            post("/appointments") {
                call.withAuthenticatedUser {
                    val appointment = call.receive<Appointment>()
                    appointmentService.scheduleAppointment(appointment)
                }
            }
        }
    }
}
