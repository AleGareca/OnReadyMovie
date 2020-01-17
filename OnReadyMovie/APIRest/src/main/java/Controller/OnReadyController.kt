package Controller

import Handler.Handler
import Model.OnReadyMovie
import Model.Pelicula
import Validator.Validator
import io.javalin.http.Context
import io.javalin.http.NotFoundResponse
import java.lang.IllegalArgumentException


class OnReadyController(val onReadyMovie: OnReadyMovie) {


    fun agregarPeliculas(p:Pelicula)= onReadyMovie.agregarPeliculas(p)

    fun borrarPelicula(id:String)= onReadyMovie.removerPelicula(onReadyMovie.buscarPeliculaPorId(id))

    fun buscarPeliculaPorId(id:String) = onReadyMovie.buscarPeliculaPorId(id)


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

    fun addMovie(ctx: Context) {
        val authentication = Validator(ctx)
        val newMovie =authentication.validationMovie()
        try {
            val movie = Pelicula(newMovie.nombre, newMovie.url,
                    newMovie.sinopsis,newMovie.paisDeOrigen, newMovie.fecha,newMovie.director)

            agregarPeliculas(movie)

            ctx.status(201)
            ctx.json(Handler(201,"Ok","The movie ${movie.nombre} was created"))


        } catch (e: IllegalArgumentException) {
            ctx.status(400)
            ctx.json(Handler(400,"Bad_Request","Movie is already created"))
        }
    }


    fun editMovie(ctx:Context){
        val id= ctx.pathParam("id")
        val authentication = Validator(ctx)
        val newMovie =authentication.validationMovie()
        try{
            val pelicula= buscarPeliculaPorId(id)


            pelicula.director== newMovie.director
            pelicula.nombre== newMovie.nombre
            pelicula.fecha== newMovie.fecha
            pelicula.paisDeOrigen== newMovie.paisDeOrigen
            pelicula.sinopsis== newMovie.sinopsis


            ctx.status(201)
            ctx.json(Handler(201, "Ok", " la pelicula ${pelicula.nombre} fue modificado "))

        }
        catch(exception: NoSuchElementException ){

            ctx.status(400)
            ctx.json(Handler(400, "Bad Request", "No se puede modificar la pelicula"))

        }

    }



    }




