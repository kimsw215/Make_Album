package com.example.make_album.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.make_album.DataVo.DataVo_Photo
import com.example.make_album.R

class Photo_GridLayoutAdapter :
    RecyclerView.Adapter<Photo_GridLayoutAdapter.ViewHolder>() {

    var dataList = mutableListOf<DataVo_Photo>()

    interface OnItemClickListener {
        fun onItemClick(v: View, data: DataVo_Photo, pos: Int)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.photo_listview,parent,false)
        )
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val photo = itemView.findViewById<ImageView>(R.id.rv_photo)

        fun bind(item: DataVo_Photo) {
            Glide.with(itemView).load(item.photo).into(photo)

            val pos = adapterPosition
            if( pos != RecyclerView.NO_POSITION){
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView, item, pos)
                }
            }
        }
    }
}