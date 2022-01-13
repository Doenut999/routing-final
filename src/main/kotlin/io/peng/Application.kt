package io.peng

import io.ktor.server.application.*
import io.peng.plugins.*
import io.peng.routing.registerRoutes

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureRouting()
    configureSerialization()
    registerRoutes()
}
