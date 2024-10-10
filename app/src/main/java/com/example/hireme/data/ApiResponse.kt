package com.example.hireme.data

data class ApiResponse(
    val offers: List<Offer>,
    val vacancies: List<Vacancy>
)
