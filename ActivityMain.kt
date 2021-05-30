package com.dennis.basicandroidui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //xml file to interact with
        setContentView(R.layout.activity_main)

        //import the button via it's id and save it in a variable
        var fragmentOne = findViewById<Button>(R.id.btnFragment1)
        var fragmenttwo = findViewById<Button>(R.id.btnFragment2)

        //create an instance of our two fragments
        val firstFragment = FragmentA()
        val secondFragment = FragmentB()

        //the default fragment on our home screen upon start is fragment A
        supportFragmentManager.beginTransaction().apply {
            //replace the contaier view id of our container Layour with the intending fragment i.e the fragment to be passed
            replace(R.id.frameLayoutFragmentId, firstFragment)
            commit()
        }

        //replace the content of out layout with either fragmentAby using fragment transaction
        fragmentOne.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                //replace the contaier view id of our container Layour with the intending fragment i.e the fragment to be passed
                replace(R.id.frameLayoutFragmentId, firstFragment)

                //add to back stack
                addToBackStack(null)
                commit()
            }
        }

        //replace the content of out layout with either fragment B by using fragment transaction
        fragmenttwo.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                //replace the contaier view id of our container Layour with the intending fragment i.e the fragment to be passed
                replace(R.id.frameLayoutFragmentId, secondFragment)

                // add to backstack so that when user go back it will not call the destroy()
                addToBackStack(null)
                commit()
            }
        }
    }
}
















