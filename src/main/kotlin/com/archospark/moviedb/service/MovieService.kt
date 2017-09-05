package com.archospark.moviedb.service

import com.archospark.moviedb.entity.Movie
import com.archospark.moviedb.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {
    fun getAllMovies(): List<Movie>? = movieRepository.findAll()
    fun getMovieById(movieId: Int): Movie? = movieRepository.findOne(movieId)
    fun getMovieByName(movieName: String): Movie? = movieRepository.findByName(movieName)
    fun addMovie(movie: Movie): Movie? = movieRepository.save(movie)
    fun deleteMovie(movieId: Int) = movieRepository.delete(movieId)
    fun updateMovie(movieId: Int, movie: Movie): Movie? {
        val oldMovie = getMovieById(movieId)
        return if (oldMovie == null) null
        else {
            oldMovie.name = movie.name
            oldMovie.description = movie.description
            oldMovie.length = movie.length
            movieRepository.save(oldMovie)
        }
    }
}