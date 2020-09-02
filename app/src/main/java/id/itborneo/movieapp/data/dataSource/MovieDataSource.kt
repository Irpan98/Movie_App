package id.itborneo.movieapp.data.dataSource

import android.util.Log
import androidx.paging.PageKeyedDataSource
import id.itborneo.movieapp.data.model.MovieItem
import id.itborneo.movieapp.data.remote.ApiClient
import id.itborneo.movieapp.data.remote.ApiServices
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

object MovieDataSource : PageKeyedDataSource<Int, MovieItem>() {


    var service: ApiServices = ApiClient.create()

    private val TAG = "MovieDataSource"
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, MovieItem>
    ) {
        service.getMovie(1, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movieResponse ->
                movieResponse.results?.let {
                    callback.onResult(it, null, 2)
                    Log.d(TAG, it.toString())
                }

            }, {})
    }


    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieItem>) {
        service.getMovie(1, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movieResponse ->
                movieResponse.results?.let {
                    callback.onResult(it, params.key + 1)

                }

            }, {})
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieItem>) {

    }


}