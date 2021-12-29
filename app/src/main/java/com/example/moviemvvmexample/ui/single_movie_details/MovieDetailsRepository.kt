package com.example.moviemvvmexample.ui.single_movie_details

import androidx.lifecycle.LiveData
import com.example.moviemvvmexample.data.api.TheMovieDBInterface
import com.example.moviemvvmexample.data.repository.MovieDetailsNetworkDataSource
import com.example.moviemvvmexample.data.repository.NetworkState
import com.example.moviemvvmexample.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository (private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }



}