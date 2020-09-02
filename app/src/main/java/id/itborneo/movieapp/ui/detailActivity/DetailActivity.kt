package id.itborneo.movieapp.ui.detailActivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import id.itborneo.movieapp.R
import id.itborneo.movieapp.data.model.MovieItem
import id.itborneo.movieapp.utils.ViewUtils.setPoster
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object {
        val MOVIE = " EXTRA_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Movie"
        val movieIntent: MovieItem? = intent.getParcelableExtra(MOVIE)


        attachView(movieIntent)
    }

    private fun attachView(movieItem: MovieItem?) {
        tvTitle.text = movieItem?.name
        Log.d("DetailActivity"," link ${movieItem?.posterPath}")
        setPoster(this, movieItem?.posterPath, ivPoster)

        val description = movieItem?.description
        if (description != null) if (description.isNotEmpty()) {
            tvOverview.text = movieItem.description

        } else {
            tvOverview.text = getString(R.string.tidak_ada_deskripsi)
        }


    }

}