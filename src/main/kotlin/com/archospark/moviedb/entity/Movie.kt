package com.archospark.moviedb.entity

import javax.persistence.*

@Entity
@Table(name = "movie")
class Movie() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Int? = null
    lateinit var name : String
    var length : Int? = null
    lateinit var description : String
    constructor(name : String, length: Int, description: String) : this() {
        this.name = name
        this.length = length
        this.description = description
    }
    override fun toString(): String {
        return "Movie(id=$id, name='$name', length=$length, description='$description')"
    }
}