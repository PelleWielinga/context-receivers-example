package com.pellewielinga.example.context.appointments

import com.pellewielinga.example.context.users.User
import java.time.ZonedDateTime
import java.util.*

class AppointmentService(private val repository: AppointmentRepository) {

    fun getAppointments(user: User): List<Appointment> {
        return repository.getAppointmentsByUserId(user.userId)
    }

    fun scheduleAppointment(user: User, appointment: Appointment) {
        repository.addAppointmentForUser(user.userId, appointment)
    }
}

data class Appointment(
    val id: UUID,
    val title: String,
    val from: ZonedDateTime,
    val until: ZonedDateTime
)