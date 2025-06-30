package org.batuhanerdem.todoappcmp.ui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform