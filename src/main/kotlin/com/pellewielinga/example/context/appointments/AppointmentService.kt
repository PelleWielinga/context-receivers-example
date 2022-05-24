package com.pellewielinga.example.context.appointments

import com.pellewielinga.example.context.users.UserContext
import java.time.ZonedDateTime
import java.util.*

class AppointmentService(private val repository: AppointmentRepository) {
    context(UserContext)
    fun getAppointments(): List<Appointment> {
        return repository.getAppointmentsByUserId()
    }

    context(UserContext)
    fun scheduleAppointment(appointment: Appointment) {
        repository.addAppointmentForUser(appointment)
    }
}

data class Appointment(
    val id: UUID,
    val title: String,
    val from: ZonedDateTime,
    val until: ZonedDateTime
)