package com.example.concordiaq

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.RatingBar.OnRatingBarChangeListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val meals = arrayOf("salmon", "Poutine", "Sushi", "Tacos")
    private val salad = arrayOf("Chicken salad", "Montreal", "Green salad")
    var reportList = ArrayList<ReportListClass>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewTitle.setText(intent.getStringExtra("nameandscore"))



        myRatingBar.setOnRatingBarChangeListener(object : OnRatingBarChangeListener {

            override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
                textveiwRate.text = p1.toString()

                var reportListClass = ReportListClass(selectedItem = textviewspinner.text.toString(), rate = p1)
                reportList.add(reportListClass)
            }
        })

        btnMeal.setOnClickListener {
            mealSpinner()


        }

        btnSalad.setOnClickListener {
            saladSpinner()

        }
        btnShowall.setOnClickListener {
            gotoResultPageAndShowList()
        }

    }

    fun gotoResultPageAndShowList() {
        val resultIntent = Intent(this@MainActivity, ReslutActivity::class.java)
        startActivity(resultIntent)

        var bundle = Bundle()
        bundle.putSerializable("bundleContent", reportList)
        resultIntent.putExtra("reportlistArray", bundle)

        startActivity(resultIntent)

    }

    fun mealSpinner() {
        imageview.setImageResource(R.drawable.salmon);
        spinner.performClick();
        // access the spinner
        if (spinner != null) {
            val myadapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, meals)
            spinner.adapter = myadapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    // Notify the selected item text
                    val selectedmealtext = parent.getItemAtPosition(position) as String
                    textviewspinner.text = selectedmealtext



                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

        }

    }

    fun saladSpinner() {
        imageview.setImageResource(R.drawable.chickensalad);
        spinner.performClick();
        // access the spinner
        if (spinner != null) {
            val my2adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, salad)
            spinner.adapter = my2adapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    // Notify the selected item text
                    val selectedSaladText = parent.getItemAtPosition(position) as String
                    textviewspinner.text = selectedSaladText


                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

        }

    }

    fun ratingCustomer() {


    }


}
