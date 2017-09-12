package com.archospark.moviedb.repository

import com.archospark.moviedb.entity.MovieEntity
import org.springframework.data.jpa.repository.JpaRepository

internal interface MovieRepository : JpaRepository<MovieEntity, Int> {
    fun findByName(movieName: String) : MovieEntity?
}