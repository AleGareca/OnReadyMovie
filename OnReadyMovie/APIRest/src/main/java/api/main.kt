package api

import io.javalin.Javalin
import io.javalin.core.util.RouteOverviewPlugin
import io.javalin.apibuilder.ApiBuilder.*


fun main(args: Array<String>) {

    ApiWallet(7000).init()
}
class ApiWallet(private val  port:Int){

    fun init():Javalin {
        val app = Javalin.create {
            it.enableCorsForAllOrigins()
            it.registerPlugin(RouteOverviewPlugin("/routes"))

        }.exception(Exception::class.java) { e, ctx ->
            e.printStackTrace()
            ctx.status(500)
            ctx.json("Error fatal")
        }
                .start(port)
        val onReadyMovieController=onReadyMoviController(onReadyMoviData.build())


        app.routes {
            path("movies") {
               get(onReadyMovieController::muvies)
            }
            path("delete") {
                post(onReadyMovieController::removeMovie)
            }
            path("createUser") {
                post(onReadyMovieController::addUser)
            }

            path("/users") {
                get(onReadyMovieController::getUsers)
            }

            path("/movies/name/:name") {
                get(onReadyMovieController::getUserByName)
            }

        }
        return app
    }
}
