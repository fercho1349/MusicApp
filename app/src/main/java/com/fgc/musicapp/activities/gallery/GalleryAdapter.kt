package com.fgc.musicapp.activities.gallery

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.fgc.musicapp.R
import com.fgc.musicapp.utils.PlaceData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_places.view.*

class GalleryAdapter(private var context: Context) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

  lateinit var itemClickListener: OnItemClickListener

  override fun getItemCount() = PlaceData.placeList().size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val itemView = LayoutInflater.from(parent.context).inflate(R.layout.row_places, parent, false)
    return ViewHolder(itemView)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val place = PlaceData.placeList()[position]
    holder.itemView.placeName.text = place.name
    Picasso.get().load(place.getImageResourceId(context)).into(holder.itemView.placeImage)

    val photo = BitmapFactory.decodeResource(context.resources, place.getImageResourceId(context))
    Palette.from(photo).generate { palette ->
      val bgColor = palette!!.getMutedColor(ContextCompat.getColor(context, android.R.color.black))
      holder.itemView.placeNameHolder.setBackgroundColor(bgColor)
    }
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    init {
      itemView.placeHolder.setOnClickListener(this)
    }

    override fun onClick(view: View) = itemClickListener.onItemClick(itemView, adapterPosition)
  }

  interface OnItemClickListener {
    fun onItemClick(view: View, position: Int)
  }

  fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
    this.itemClickListener = itemClickListener
  }
}