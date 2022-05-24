package com.pellewielinga.example.context.appointments

import com.pellewielinga.example.context.users.UserContext

class AppointmentRepository {
    context(UserContext)
    fun getAppointmentsByUserId(): List<Appointment> {
        val userId = authenticatedUser.userId
        TODO()
    }

    context(UserContext)
    fun addAppointmentForUser(appointment: Appointment) {
        TODO()
    }
}