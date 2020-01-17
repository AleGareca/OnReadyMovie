package Model


class OnReadyMovie(){

    val peliculas:MutableList<Pelicula> = mutableListOf()


   fun agregarPeliculas(p:Pelicula){
       peliculas.add(p)
    }

    fun removerPelicula(p:Pelicula){
        peliculas.remove(p)
    }

    fun buscarPeliculaPorNombre(nombre:String):Pelicula{
        return peliculas.first { it.nombre == nombre }
    }

    fun editarNombreDePelicula(p: Pelicula, n: String) {

    }


}