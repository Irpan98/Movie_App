package id.itborneo.movieapp.ui.mainActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.recyclerview.widget.LinearLayoutManager
import id.itborneo.movieapp.R
import id.itborneo.movieapp.data.model.MovieItem
import id.itborneo.movieapp.ui.detailActivity.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val TAG = "MainActivity"

    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachRecycler()

        val viewModel = ViewModelProvider(this, NewInstanceFactory())[MainViewModel::class.java]
        viewModel.getMovie().observe(this, {


            adapter.submitList(it)
            adapter.notifyDataSetChanged()


        })
    }

    private fun attachRecycler() {
        rvMovies.layoutManager = LinearLayoutManager(baseContext)

        adapter = MainAdapter(baseContext) {
            moveActivty(it)

        }

        rvMovies.adapter = adapter


    }

    private fun moveActivty(movie: MovieItem) {
        val intent = Intent(baseContext, DetailActivity::class.java)
        intent.putExtra(DetailActivity.MOVIE, movie)
        startActivity(intent)
    }
}