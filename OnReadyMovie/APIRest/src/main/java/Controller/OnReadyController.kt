package Controller

import Handler.Handler
import Model.OnReadyMovie
import Model.Pelicula
import io.javalin.http.Context
import io.javalin.http.NotFoundResponse
import java.lang.IllegalArgumentException


class OnReadyController(val onReadyMovie: OnReadyMovie) {

    fun peliculas()= onReadyMovie.peliculas

    fun agregarPeliculas(p:Pelicula)= onReadyMovie.agregarPeliculas(p)

    fun borrarPelicula(nombre:String)= onReadyMovie.removerPelicula(onReadyMovie.buscarPeliculaPorNombre(nombre))

    fun buscarPeliculaPorNombre(nombre:String) = onReadyMovie.buscarPeliculaPorNombre(nombre)
    fun editarNombreDePelicula(p:Pelicula,n: String)= onReadyMovie.editarNombreDePelicula(p,n)

    fun movies(ctx: Context) {
        ctx.status(200)
        ctx.json(onReadyMovie.peliculas)
    }

    fun removeMovie(ctx: Context){
        val nombre= ctx.pathParam("nombre")
        try {
            val movie = onReadyMovie.peliculas.firstOrNull { it.nombre == nombre }
                    ?: throw NotFoundResponse("The movie with name $nombre does not exist in the system")
            borrarPelicula(nombre)
            ctx.status(201)
            ctx.json(Handler(201,"ok","The Movie ${movie.nombre} was delete"))
        }catch (e:IllegalArgumentException){
            ctx.status(401)
            ctx.json(Handler(401, "Unable", e.message!!))

        }catch (e:NotFoundResponse){
            ctx.status(401)
            ctx.json(Handler(401, "Bad_Request", e.message!!))

        }

    }
    }



