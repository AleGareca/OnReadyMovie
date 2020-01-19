package Model


class OnReadyMovie(){

    val peliculas:MutableList<Pelicula> = mutableListOf()


   fun agregarPeliculas(p:Pelicula){
       peliculas.add(p)
    }

    fun removerPelicula(p:Pelicula){
        requireExistsMovie(p)
        peliculas.remove(p)
    }

    private fun requireExistsMovie(p: Pelicula) =
            require(peliculas.any { it.nombre == p.nombre }) {
                "The movie ${p.nombre}  is not register"
            }

    fun buscarPeliculaPorNombre(nombre:String):Pelicula{
        return peliculas.first { it.nombre == nombre }
    }

    fun editarNombreDePelicula(p: Pelicula, n: String) {

    }


}