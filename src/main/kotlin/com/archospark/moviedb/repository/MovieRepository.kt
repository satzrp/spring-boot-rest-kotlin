package com.archospark.moviedb.repository

import com.archospark.moviedb.entity.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Int> {
    fun findByName(movieName: String) : Movie?
}