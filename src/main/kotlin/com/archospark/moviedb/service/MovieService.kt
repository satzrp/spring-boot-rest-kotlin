package com.archospark.moviedb.service

import com.archospark.moviedb.entity.MovieEntity
import com.archospark.moviedb.model.Movie
import com.archospark.moviedb.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
internal class MovieService(private val movieRepository: MovieRepository) {
    internal fun getAllMovies(): List<Movie>? = movieRepository.findAll().map { it.toMovie() }
    internal fun getMovieById(movieId: Int): Movie? = movieRepository.findOne(movieId)?.toMovie()
    internal fun getMovieByName(movieName: String): Movie? = movieRepository.findByName(movieName)?.toMovie()
    internal fun addMovie(movie: Movie): Movie? = movieRepository.save(MovieEntity.fromMovie(movie)).toMovie()
    internal fun deleteMovie(movieId: Int) = movieRepository.delete(movieId)
    internal fun updateMovie(movieId: Int, movie: Movie): Movie? {
        val oldMovie = movieRepository.findOne(movieId)
        return if (oldMovie == null) null
        else {
            oldMovie.name = movie.name
            oldMovie.description = movie.description
            oldMovie.length = movie.length
            movieRepository.save(oldMovie).toMovie()
        }
    }
}