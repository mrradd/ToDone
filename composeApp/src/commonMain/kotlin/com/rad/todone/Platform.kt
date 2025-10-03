package com.rad.todone

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform