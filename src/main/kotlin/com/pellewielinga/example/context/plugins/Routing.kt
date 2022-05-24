package com.pellewielinga.example.context.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.pellewielinga.example.context.appointments.Appointment
import com.pellewielinga.example.context.appointments.AppointmentService
import com.pellewielinga.example.context.users.authenticatedUser

fun Application.configureRouting(
    appointmentService: AppointmentService
) {
    routing {
        authenticate("auth-jwt") {
            get("/appointments") {
                val user = call.authenticatedUser()

                val appointments = appointmentService.getAppointments(user)

                call.respond(appointments)
            }

            post("/appointments") {
                val user = call.authenticatedUser()
                val appointment = call.receive<Appointment>()

                appointmentService.scheduleAppointment(user, appointment)
            }
        }
    }
}
