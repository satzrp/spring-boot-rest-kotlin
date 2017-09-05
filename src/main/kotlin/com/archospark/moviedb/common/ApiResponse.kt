package com.archospark.moviedb.common

data class ApiResponse<T> (val status : Int, val message : String, val data : T?)