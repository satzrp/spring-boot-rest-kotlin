package com.archospark.moviedb.common

data class ApiResponse<out T> (val status : Int, val message : String, val data : T?)