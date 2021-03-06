package com.changs.carddemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter(val context : Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("Chapter One", "Chapter Two", "Chapter Three", "Chapter Four","Chapter Five","Chapter Six",
        "Chapter Seven","Chapter Eight")
    private val details = arrayOf("Item one details", "Item two details", "Item three details"
    , "Item four details", "Item five details", "Item six details", "Item seven details"
    , "Item eight details")

    private val images = intArrayOf(R.drawable.profile_image, R.drawable.profile_image,R.drawable.profile_image,R.drawable.profile_image
    ,R.drawable.profile_image,R.drawable.profile_image,R.drawable.profile_image,R.drawable.profile_image)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemImage.setImageResource(images[position])
        holder.itemDetail.text = details[position]

        val animation = AnimationUtils.loadAnimation(context, R.anim.slide_in_to_left)
        holder.itemView.animation = animation


    }

    override fun getItemCount(): Int {
       return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage : ImageView
        var itemTitle : TextView
        var itemDetail : TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemlTitle)
            itemDetail = itemView.findViewById(R.id.itemlDetail)

            itemView.setOnClickListener{ v: View ->
                val position : Int = adapterPosition

                Snackbar.make(v, "Click detected on item $position",
                Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }

    }
}