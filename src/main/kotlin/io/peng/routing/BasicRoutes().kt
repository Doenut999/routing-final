package io.peng.routing
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//Basic request with root endpoint
fun Route.getNames(){
    val g = listOf("Alfred", "Seyram", "Kojo", "Lotsu")
    get("/") {
        call.respondText("$g")
    }
}


//Basic Request with route parameter
fun Route.getAges(){
    val hi = listOf(1,2,3,4,5)
    get("/hi/{number}") {
        val b = call.parameters["number"] ?: return@get call.respondText("Bad request", status = HttpStatusCode.BadRequest)
        call.respondText("${b.toInt() in hi}")
    }
}


//With wildcard: {correct: /safe/me}, {wrong: /safe/}
fun Route.getWildcard(){
    get("/safe/*"){
        val j = mutableListOf("ya", "ye", "yi", "yo", "y))", "y")
        call.respondText("$j")
    }
}


//With nullable route parameter: {correct: /want/yes and /want/}
fun Route.nullableParameter(){
    get("want/{superb?}"){
        val n = call.parameters["superb"] ?: "papa"
        call.respondText(n)
    }
}

//With TailCard {correct: /unsafe/ and /unsafe/sugar}
fun Route.getTailCard(){
    get("unsafe/{...}"){
        call.respondText("This has been a successful testing session, love.", status = HttpStatusCode.Accepted)
    }
}

//TailCard with route parameter {correct: /yes/one and /yes/one/me/you/him/her/they/them}
fun Route.lastOne(){
    get("yes/{one...}"){
        val k = call.parameters.getAll("one") // puts everything in *one* parameter in an array
        call.respondText("$k")
    }
}

fun Application.registerRoutes(){
    routing {
        getTailCard()
        nullableParameter()
        getAges()
        getNames()
        getWildcard()
        lastOne()
    }
}
