package com.example.concordiaq

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val meals = arrayOf("salmon", "Poutine", "Sushi", "Tacos")
    val salad= arrayOf("Chicken salad","Montreal","Green salad")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

btnMeal.setOnClickListener {
    // access the spinner
    if (spinner != null) {
        val myadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, meals)
        spinner.adapter = myadapter
        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View, position: Int, id: Long
            ) {

            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
}

            }
        }

        btnSalad.setOnClickListener {
            spinner.performClick();

            // access the spinner
            if (spinner != null) {
                val my2adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, salad)
                spinner.adapter = my2adapter
                spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {

                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // write code to perform some action
                    }
                }

            }

        }

    }


}
