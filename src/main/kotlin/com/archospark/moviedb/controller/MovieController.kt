package com.archospark.moviedb.controller

import com.archospark.moviedb.common.ApiResponse
import com.archospark.moviedb.model.Movie
import com.archospark.moviedb.service.MovieService
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
@RequestMapping("/moviedb/api")
@Suppress("unused")
internal class MovieController(private val movieService: MovieService) {

    @GetMapping(value = "/movie/all")
    fun getAllMovies(): ApiResponse<List<Movie>> {
        val movies = movieService.getAllMovies()
        val returnMessage = if (movies == null) "No data available" else "Success"
        return ApiResponse(200, returnMessage, movies)
    }

    @GetMapping(value = "/movie/{movieId}")
    fun getMovieById(@PathVariable movieId: Int): ApiResponse<Movie> {
        val movie = movieService.getMovieById(movieId)
        val returnMessage = if (movie == null) "No data available" else "Success"
        return ApiResponse(200, returnMessage, movie)
    }

    @GetMapping(value = "/movie/name/{movieName}")
    fun getMovieByName(@PathVariable movieName: String): ApiResponse<Movie> {
        val movie = movieService.getMovieByName(movieName)
        val returnMessage = if (movie == null) "No data available" else "Success"
        return ApiResponse(200, returnMessage, movie)
    }

    @PutMapping(value = "/movie")
    fun addMovie(@RequestBody movie: Movie): ApiResponse<Movie> {
        val savedMovie = movieService.addMovie(movie)
        val returnMessage = if (savedMovie == null) "Error in adding movie" else "Success"
        return ApiResponse(200, returnMessage, savedMovie)
    }

    @PostMapping(value = "/movie/{movieId}")
    fun updateMovie(@PathVariable movieId: Int, @RequestBody movie: Movie): ApiResponse<Movie> {
        val savedMovie = movieService.updateMovie(movieId, movie)
        val returnMessage = if (savedMovie == null) "Invalid movie id" else "Success"
        return ApiResponse(200, returnMessage, savedMovie)
    }

    @DeleteMapping(value = "/movie/{movieId}")
    fun deleteMovie(@PathVariable movieId: Int) = movieService.deleteMovie(movieId)

    @PostConstruct
    fun loadMovies() {
        val movies = listOf(Movie(name ="Roja", length = 120, description = "A movie by Mani Ratnam"),
                Movie(name = "Boys", length = 180, description = "A film by Shankar"),
                Movie(name ="Thalapathy", length = 150, description = "One of the best in Indian Cinema"))
        movies.forEach { movieDTO -> movieService.addMovie(movieDTO) }
    }
}