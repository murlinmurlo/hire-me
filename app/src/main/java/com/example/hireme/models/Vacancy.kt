package com.example.hireme.models

data class Vacancy(
    val title: String,
    val address: Address,
    val company: String,
    val experience: Experience,
    val publishedDate: String,
    var isFavorite: Boolean
)

data class Address(val town: String)

data class Experience(val previewText: String)
