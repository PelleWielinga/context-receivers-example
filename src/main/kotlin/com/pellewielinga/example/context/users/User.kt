package com.pellewielinga.example.context.users

import io.ktor.server.application.*
import java.util.*

data class User(
    val userId: UUID,
    val username: String,
    val locale: Locale
)

fun ApplicationCall.authenticatedUser(): User {
    TODO("Not implemented")
}
