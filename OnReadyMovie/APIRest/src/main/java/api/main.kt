package api

import Controller.OnReadyController
import Data.OnReadyMoviData
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
        val onReadyMovieController= OnReadyController(OnReadyMoviData.build())


        app.routes {
            path("movies") {
               get(onReadyMovieController::movies)
            }
            path("delete") {
                post(onReadyMovieController::removeMovie)
            }

        }
        return app
    }
}
