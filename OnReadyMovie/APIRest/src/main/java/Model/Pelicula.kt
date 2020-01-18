package Model

class Pelicula(val nombre:String,val url:String, val sinopsis:String,val paisDeOrigen: String,
               val fecha:String, val director:String, val reparto:MutableIterable<Actor> )

class Actor(val nombre:String, val apellido:String)