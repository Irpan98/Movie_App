package id.itborneo.movieapp.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import id.itborneo.movieapp.R

object ViewUtils {
    fun setPoster(context: Context, poster: String?, image: ImageView) {
        if (poster == null) return

        val posterSize = "w185/"
        val urlImage = "https://image.tmdb.org/t/p/$posterSize${poster}"

        Glide.with(context)
            .load(urlImage)
            .apply(RequestOptions().override(100, 150))
            .apply(RequestOptions().placeholder(R.drawable.no_image))

            .into(image)

    }
}