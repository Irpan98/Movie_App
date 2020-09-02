package id.itborneo.movieapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import id.itborneo.movieapp.data.dataSource.MovieDataFactory
import id.itborneo.movieapp.data.dataSource.MovieDataSource
import id.itborneo.movieapp.data.model.MovieItem
import java.util.concurrent.Executors

class MovieRepository {

    private val movieDataFactory = MovieDataFactory()

    private val TAG = "MovieRepository"

    fun getMovies(): LiveData<PagedList<MovieItem>> {


        Log.e(TAG, "getMovies called")

//        val movies = MutableLiveData<PagedList<MovieItem>>()

        val moviePagedList = LivePagedListBuilder(movieDataFactory, pageListConfig)
            .setFetchExecutor(Executors.newFixedThreadPool(5))
            .build()




        return moviePagedList

    }

    var pageListConfig = PagedList.Config.Builder()
        .setPageSize(15)
        .setInitialLoadSizeHint(10)
        .build()
}