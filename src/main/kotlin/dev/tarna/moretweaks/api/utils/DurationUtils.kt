package dev.tarna.moretweaks.api.utils

import java.time.Duration

fun String.parseDuration(): Duration {
    val duration = this
    val time = duration.substring(0, duration.length - 1).toLong()
    return when (val unit = duration[duration.length - 1]) {
        's' -> Duration.ofSeconds(time)
        'm' -> Duration.ofMinutes(time)
        'h' -> Duration.ofHours(time)
        'd' -> Duration.ofDays(time)
        't' -> Duration.ofMillis(time * 50)
        else -> throw IllegalArgumentException("Invalid duration unit: $unit")
    }
}

fun Duration.toDurationString(): String {
    return when {
        this.toDaysPart() > 0 -> "${this.toDaysPart()}d"
        this.toHoursPart() > 0 -> "${this.toHoursPart()}h"
        this.toMinutesPart() > 0 -> "${this.toMinutesPart()}m"
        this.toSecondsPart() > 0 -> "${this.toSecondsPart()}s"
        else -> "${this.toMillis()}t"
    }
}

fun Duration.toTicks(): Long {
    return this.toMillis() / 50
}