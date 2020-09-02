package id.itborneo.movieapp.data.dataSource

import androidx.paging.DataSource
import id.itborneo.movieapp.data.model.MovieItem


class MovieDataFactory : DataSource.Factory<Int,MovieItem>(){


    private val movieDataSource = MovieDataSource

    override fun create(): DataSource<Int, MovieItem> {



        return movieDataSource
    }

}