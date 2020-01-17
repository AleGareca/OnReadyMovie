package Model


class Netflix(peliculas: MutableList<Pelicula>){

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


}