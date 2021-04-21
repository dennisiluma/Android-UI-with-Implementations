package com.dennis.uiandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3
//create a layout manager object

class MainActivity : AppCompatActivity() {

    //create a layout  and adapter object
    private var layoutManager:RecyclerView.LayoutManager? = null
    private var adapter:RecyclerView.Adapter<PartnerSectionRecycler.ItemsHolder>? = null


    //create a variable to store data that will be passed to the card
    private val cardName = mutableListOf<String>()
    private val cardType = mutableListOf<String>()
    private val cardAmount = mutableListOf<String>()
    private val cardNumber = mutableListOf<String>()
    private val cardVisa = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /* For Recycler View */

        var recyclerview = findViewById<RecyclerView>(R.id.home_recycler_view)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerview.layoutManager = layoutManager
        //initialize our adaptor
        adapter = PartnerSectionRecycler()
        recyclerview.adapter = adapter
        postToAddToList()

        /*for Viewpager2*/

        val viewpager = findViewById<ViewPager2>(R.id.view_pager2)
        // fill data into the viewpager class
        viewpager.adapter = CardViewAdapter(cardName, cardType, cardAmount, cardNumber, cardVisa)
        viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //connect it to the Circularindicator view
        val indicator = findViewById<CircleIndicator3>(R.id.indicator3)
        indicator.setViewPager(viewpager)

    }
    //create a logic to populate the empty data
    private fun addToList(name:String, type: String, amount: String, number: String, visa:String){
        cardName.add(name)
        cardType.add(type)
        cardAmount.add(amount)
        cardNumber.add(number)
        cardVisa.add(visa)
    }
    private fun postToAddToList(){
        val names = arrayOf("Dennis", "Ola", "Hope", "Ezekiel","Wilson")
        val types = arrayOf("Debit", "Credit","Debit","credit","Debit")
        val amount = arrayOf("$23,000", "$56,000","$65,342","$23000","$78,357")
        val number = arrayOf("2354","3424","4532","4512","4567")
        val visa = "Visa"

        for (x in names.indices){
            addToList(names[x], types[x],amount[x], number[x], visa)
        }

    }
}