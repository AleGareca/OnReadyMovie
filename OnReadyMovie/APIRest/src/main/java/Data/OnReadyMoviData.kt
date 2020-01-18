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
        val actor1=Actor("Angelina","Jolie")
        val actor2=Actor("Elle ","Fanning")
        val actor3=Actor("Elle ","Fanning")
        val actor4=Actor("Michelle "," Pfeiffer")
        val actor5=Actor("Harris "," Dickinson")

        val actor6=Actor("Daisy"," Ridley")
        val actor7=Actor("Adam "," Driver")
        val actor8=Actor("Mark ","Hamill")
        val actor9=Actor("John ","  Boyega")


        val ls= mutableListOf<Actor>(actor1,actor2,actor3,actor4,actor5)
        val ls2= mutableListOf<Actor>(actor6,actor7,actor8,actor9)



        return listOf(
            Pelicula("Malefica","https://static.pelisplus.me/movie/cover/original/9be31cf3f4c77ff9184cd68facad719e.jpg",
                    "La hada cornuda (Angelina Jolie) y la que pronto será la reina (Elle Fanning), ya que forman nuevas alianzas y se enfrentan a nuevos adversarios en su lucha por proteger a las criaturas mágicas que residen en su interior.","EEUU","01/05/2019","Robert Stromberg",ls),

            Pelicula("Star Wars","https://static.pelisplus.me/movie/cover/original/d87b4d230bafe7886a52e2f2eb0eb7d2.jpg","Novena y última entrega de la saga 'Star Wars', y cierre de la nueva trilogía iniciada con El despertar de la Fuerza. Rey, Finn, Poe y el resto de los héroes tendrán que encarar nuevos retos al tiempo que se enfrentan a una nueva amenaza",
                    "EEUU","01/02/2019","J. J. Abrams",ls2)

        )
    }
}