package io.peng.plugins

import io.ktor.server.plugins.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
    }

}
