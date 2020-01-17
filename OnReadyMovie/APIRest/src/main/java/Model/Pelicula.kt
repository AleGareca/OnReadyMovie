package Model

class Pelicula(var nombre:String, var paisDeOrigen: String,
               var fecha:String, var director:String, var reparto:MutableIterable<Actor> )

class Actor(var nombre:String, var apellido:String)