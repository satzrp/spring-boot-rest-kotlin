package com.archospark.moviedb.entity

import com.archospark.moviedb.model.Movie
import javax.persistence.*

@Entity
@Table(name = "movie")
internal class MovieEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id : Int? = null
    lateinit var name : String
    var length : Int? = null
    lateinit var description : String
    constructor(name : String, length: Int, description: String) : this() {
        this.name = name
        this.length = length
        this.description = description
    }
    fun toMovie() = Movie(this.id!!, this.name, this.length!!, this.description)
    companion object {
        fun fromMovie(movie: Movie) = MovieEntity(movie.name, movie.length, movie.description)
    }
}