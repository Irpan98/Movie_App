package id.itborneo.movieapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.itborneo.movieapp.data.dataSource.MovieDataFactory
import id.itborneo.movieapp.data.model.MovieItem
import java.util.concurrent.Executors

object MovieRepository {

    private val movieDataFactory = MovieDataFactory()

    private val TAG = "MovieRepository"

    private var moviePagedList: LiveData<PagedList<MovieItem>>

    init {

        Log.e(TAG, "getMovies called")

        var pageListConfig = PagedList.Config.Builder()
            .setPageSize(15)
            .setInitialLoadSizeHint(10)
            .build()

        moviePagedList = LivePagedListBuilder(movieDataFactory, pageListConfig)
            .setFetchExecutor(Executors.newFixedThreadPool(5))
            .build()

    }


    fun getMovies(): LiveData<PagedList<MovieItem>> {


        return moviePagedList

    }


}