package com.example.contriesflagapi

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest

import com.example.contriesflagapi.network.CountryModel
import java.util.*


@SuppressLint("UseCompatLoadingForDrawables")
@BindingAdapter("photoUrl")
fun ImageView.bind(photoUrl: String?){
    photoUrl?.let {

       val imageLoader = ImageLoader.Builder(this.context)
           .componentRegistry { add(SvgDecoder(context)) }
           .build()

       val request = ImageRequest.Builder(this.context)
           .crossfade(true)
           .crossfade(500)
           .data(photoUrl)
           .placeholder(R.drawable.loading_animation)
           .error(R.drawable.ic_broken_image)
           .target(this)
           .build()

       imageLoader.enqueue(request)
       }
//        Glide.with(this.context)
//            .load(photoUri)
//            .placeholder(R.drawable.loading_animation)
//            .error(R.drawable.ic_broken_image)
//            .into(this)
    }



@BindingAdapter("listData")
fun RecyclerView.bindRecyclerView(data: List<CountryModel>?
) {
    if (this.adapter == null) {
        this.adapter = PhotoGridAdapter()
    }

    val adapter = this.adapter as PhotoGridAdapter
    adapter.submitList(data)
}