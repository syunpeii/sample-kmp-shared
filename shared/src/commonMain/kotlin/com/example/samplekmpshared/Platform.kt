package com.example.samplekmpshared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform