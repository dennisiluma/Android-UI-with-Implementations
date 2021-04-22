package com.dennis.uiandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class CardViewAdapter(
    //pass a constructor which holds item values of the card item xml file
    private val context: Context, private val list: ArrayList<DataViewPager>
) : RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {

    //create an inner class which holds the view item row.
    // pass a parameter which is an instance of the row layout
    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemCardName = itemView.findViewById<TextView>(R.id.cv_name)
        val itemCardType = itemView.findViewById<TextView>(R.id.cv_card_type)
        val itemCardAmount = itemView.findViewById<TextView>(R.id.cv_amount)
        val itemCardPin = itemView.findViewById<TextView>(R.id.cv_pin)
        val itemCardVisa = itemView.findViewById<TextView>(R.id.cv_visa)
        val itemCardBackgroundColor =
            itemView.findViewById<CardView>(R.id.cv_card_view_boss)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        )
    }

    override fun getItemCount(): Int {
        //the no of items
        return list.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemCardName.text = list[position].name
        holder.itemCardType.text = list[position].type
        holder.itemCardAmount.text = list[position].amount
        holder.itemCardPin.text = list[position].number
        holder.itemCardVisa.text = list[position].visa
        holder.itemCardBackgroundColor.setBackgroundResource(list[position].color)

    }
}