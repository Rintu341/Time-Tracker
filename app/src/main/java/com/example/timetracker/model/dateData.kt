package com.example.timetracker.model
import java.time.LocalDateTime

class DateList{
    val dataList: List<LocalDateTime> = emptyList()
}

fun getDateTime(): LocalDateTime {
    return LocalDateTime.now()
}