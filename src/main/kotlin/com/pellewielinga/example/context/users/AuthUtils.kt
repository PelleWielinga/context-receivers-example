package com.pellewielinga.example.context.users

import io.ktor.server.application.*


interface UserContext {
    val authenticatedUser: User
}

suspend fun <T> ApplicationCall.withAuthenticatedUser(fn: suspend context(UserContext) () -> T): T {
    val user = authenticatedUser()

    val context = object : UserContext {
        override val authenticatedUser: User = user
    }

    return fn(context)
}
