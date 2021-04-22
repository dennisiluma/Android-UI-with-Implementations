package com.dennis.uiandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PartnerSectionRecycler : RecyclerView.Adapter<PartnerSectionRecycler.ItemsHolder>() {
    private val shipping_route = arrayOf("AliExpress", "AviaSales", "Booking", "UPSExpress", "JumiaSales")
    private  val percentage = arrayOf("4.4%","98%","54%","21%","1%")
    private  val product_category = arrayOf("Cloths and Shoes", "Tickets and Travel", "Tickets and Travel", "Cloths and Shoes", "Cloths and Shoes")
    private val  shopping_icon = intArrayOf(R.drawable.ic_bag, R.drawable.ic_bag, R.drawable.ic_bag, R.drawable.ic_bag, R.drawable.ic_bag)


    inner class ItemsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        declear the variables
        var shoppingRoute: TextView
        var percentage: TextView
        var productCategory: TextView
        var shoppingicon: ImageView

        //                initialize them
        init {
            shoppingRoute = itemView.findViewById(R.id.shipping_route)
            percentage = itemView.findViewById(R.id.percentage)
            productCategory = itemView.findViewById(R.id.product_category)
            shoppingicon = itemView.findViewById(R.id.shopping_icon)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsHolder {
//        inflate our card layout
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_card, parent, false)
        return ItemsHolder(v)
    }

    override fun getItemCount(): Int {
        //identify how many items we are passing to our view holder
        return  shipping_route.size
    }

    override fun onBindViewHolder(holder: ItemsHolder, position: Int) {
        //populate our data to our card view.  here, we collect and item and assign it to the array via its position
        holder.shoppingRoute.text = shipping_route[position]
        holder.percentage.text = percentage[position]
        holder.productCategory.text = product_category[position]
        holder.shoppingicon.setImageResource(shopping_icon[position])

    }

}