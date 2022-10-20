package ru.thstdio.firstapp2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform