package id.itborneo.movieapp.ui.mainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import id.itborneo.movieapp.data.MovieRepository
import id.itborneo.movieapp.data.model.MovieItem

class MainViewModel : ViewModel() {


    fun getMovie(): LiveData<PagedList<MovieItem>> {
        return MovieRepository().getMovies()
    }

}