package com.example.android.basicweather

data class Weather(
    val text: String,
    val date: String,
    val low: String,
    val high: String,
    val precipitation: String,
    val smallDescription: String,
    val bigDescription: String
)
