package com.example.proyectouniuno

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(private val mList: List<Products>):RecyclerView.Adapter<ProductAdapter.ViewHolden>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolden {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_card,parent, false)
        return ViewHolden(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolden, position: Int) {
        val product = mList[position]
        holder.textView.setText(product.title)
        Picasso.get().load(product.images.get(0)).into(holder.imageView)
    }


    class ViewHolden(ItemView: View): RecyclerView.ViewHolder(ItemView) {

        val imageView: ImageView = ItemView.findViewById(R.id.imageview)
        val textView: TextView = ItemView.findViewById(R.id.textView)


    }


}