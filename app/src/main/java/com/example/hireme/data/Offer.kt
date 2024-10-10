package com.example.hireme.data

import android.widget.Button

data class Offer(
    val id: String,
    val title: String,
    val link: String,
    val button: Button? = null // Если кнопка есть, но не у всех предложений
)