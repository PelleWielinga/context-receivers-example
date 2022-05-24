package com.pellewielinga.example.context.users

interface PatientProfile

class ProfileService {
    fun getProfile(user: User): PatientProfile {
        TODO()
    }

    context(UserContext)
    fun getProfile(): PatientProfile {
        TODO()
    }
}