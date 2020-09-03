package id.itborneo.movieapp.ui.mainActivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.itborneo.movieapp.R
import id.itborneo.movieapp.data.model.MovieItem
import id.itborneo.movieapp.utils.ViewUtils
import kotlinx.android.synthetic.main.item_movie.view.*


class MainAdapter(private val context: Context, private val clickListener: (MovieItem) -> Unit) :
    PagedListAdapter<MovieItem, MainAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieItem>() {
            override fun areItemsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
                return oldItem.id == newItem.id

            }

            override fun areContentsTheSame(oldItem: MovieItem, newItem: MovieItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieItem) {

            itemView.tvTitle.text = movie.name

            val description = movie.description
            if (description != null) if (description.isNotEmpty()) {
                itemView.tvOverview.text = movie.description

            } else {
                itemView.tvOverview.text = context.getString(R.string.tidak_ada_deskripsi)
            }


            ViewUtils.setPoster(context, movie.posterPath, itemView.ivPoster)

            itemView.setOnClickListener {
                clickListener(movie)
            }

        }


    }
}