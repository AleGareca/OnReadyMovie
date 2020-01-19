package Handler

import Model.Actor
import Model.Pelicula

open class Handler(val code: Int, val type: String, open val message: String)

data class MovieRegister(val nombre:String,val url:String, val sinopsis:String,val paisDeOrigen: String,
                         val fecha:String, val director:String){
    constructor(p: Pelicula) : this(p.nombre,p.url,p.sinopsis,p.paisDeOrigen,p.fecha, p.director)
}
