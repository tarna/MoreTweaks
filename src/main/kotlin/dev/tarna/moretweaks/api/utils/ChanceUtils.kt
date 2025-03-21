package dev.tarna.moretweaks.api.utils

fun chance(percentage: Int) = percentage == 100 || (0..100).random() <= percentage
fun chance(percentage: Number) = chance(percentage.toInt())