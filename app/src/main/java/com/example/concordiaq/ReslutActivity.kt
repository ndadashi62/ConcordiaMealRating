package com.example.concordiaq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_reslut.*

class ReslutActivity : AppCompatActivity() {

    var ratingList = ArrayList<ReportListClass>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reslut)


        val bundle = intent.getBundleExtra("reportlistArray")

        val bundleContent = bundle!!.getSerializable("bundleContent")

        ratingList = bundleContent as ArrayList<ReportListClass>
        showListofAllAnswers()

    }
    fun showListofAllAnswers() {
        var showingMesage = ""
ratingList?.forEach { it->
    showingMesage+=it.customerOrderReport+"\n"
}

        when (radioGroup.checkedRadioButtonId) {
            R.id.radioButtonOneStar -> ratingList?.forEach { it ->
                if(it.rate==1f)
                { showingMesage += it.oneStar + "\n"}

            }
            R.id.radioButtoTwoStar -> ratingList?.forEach { it ->
                if (it.rate == 2f) {
                    showingMesage += it.twoStar + "\n"
                }

            }
            R.id.radioButtonThreeStar -> ratingList?.forEach { it ->
                if (it.rate==3f) {
                    showingMesage += it.threeStar + "\n"
                }

            }
        }
        textViewcostumerReport.setText(showingMesage)

    }
}