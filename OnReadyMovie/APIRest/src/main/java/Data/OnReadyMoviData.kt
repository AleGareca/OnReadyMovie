package Data

import Model.Actor
import Model.OnReadyMovie
import Model.Pelicula
import java.util.*

object OnReadyMoviData {
    fun build():OnReadyMovie {
        val onReadyMovie = OnReadyMovie()
        createUsers().forEach {
          onReadyMovie.agregarPeliculas(it)
        }

        return onReadyMovie
    }

    private fun createUsers(): List<Pelicula> {
        val r = Random(9855)
        val actor1=Actor("fulano","fulano")
        val actor2=Actor("fulano","fulano")
        val ls= mutableListOf<Actor>(actor1,actor2)



        return listOf(
            Pelicula("","","","",ls)
        )
    }
}