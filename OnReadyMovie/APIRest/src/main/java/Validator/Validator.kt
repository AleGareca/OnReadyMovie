package Validator

import Handler.MovieRegister

import io.javalin.http.Context

class Validator(ctx: Context) {
    val context = ctx


    fun validationMovie(): MovieRegister {


        val newUser = context.bodyValidator(MovieRegister::class.java)
                .check({ it.nombre!!.isNotBlank() }, "Name can't be empty")
                .check({ it.nombre!!.matches(Regex("^[a-zA-Z*]*$")) }, "The name can only be composed of latters")
                .check({ it.url!!.isNotBlank() }, "Url can't be empty ")
                .check({ it.sinopsis!!.isNotBlank() }, "Sinopsis can't be empty ")
                .check({ it.paisDeOrigen!!.isNotBlank() }, "The country of origen  can't be empty")
                .check({ it.paisDeOrigen!!.matches(Regex("^[a-zA-Z*]*$")) }, "The country of origen can only be composed of latters")
                .check({ it.director!!.isNotBlank() }, "director can't be empty")
                .check({ it.fecha!!.isNotBlank() }, "date is empty")
                .get()

        return newUser
    }
}