package com.dennis.uiandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardViewAdapter(
    //pass a constructor which holds item values of the card item xml file
    private val card_name:List<String>,
    private val card_type:List<String>,
    private val card_amount:List<String>,
    private val card_number:List<String>,
    private val card_visa:List<String>): RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {

    //create an inner class which holds the view item row.
    // pass a parameter which is an instance of the row layout
    inner class CardViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemCardName = itemView.findViewById<TextView>(R.id.cv_name)
        val itemCardType = itemView.findViewById<TextView>(R.id.cv_card_type)
        val itemCardAmount = itemView.findViewById<TextView>(R.id.cv_amount)
        val itemCardPin = itemView.findViewById<TextView>(R.id.cv_pin)
        val itemCardVisa = itemView.findViewById<TextView>(R.id.cv_visa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false))

    }

    override fun getItemCount(): Int {
        //the no of items
        return card_name.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.itemCardName.text=card_name[position]
        holder.itemCardType.text = card_type[position]
        holder.itemCardAmount.text = card_amount[position]
        holder.itemCardPin.text = card_number[position]
        holder.itemCardVisa.text = card_visa[position]

    }
}