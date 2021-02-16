package com.example.concordiaq

import android.content.Intent
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

        btnBack.setOnClickListener {
            back()
        }
        btnShow.setOnClickListener {
            showListofAllAnswers()
        }

    }

    fun showListofAllAnswers() {

      var showingMesage=""

        when (radioGroup.checkedRadioButtonId) {
            R.id.radioButtonAll->ratingList?.forEach{it ->
                showingMesage += it.toString() + "\n"
            }
            R.id.radioButtonOneStar -> ratingList?.forEach { it ->
                if(it.rate == 1f)
                    showingMesage += it.toString() + "\n"
            }
            R.id.radioButtoTwoStar -> ratingList?.forEach { it ->
                if(it.rate == 2f)
                    showingMesage += it.toString() + "\n"
            }
            R.id.radioButtonThreeStar -> ratingList?.forEach { it ->
                if (it.rate == 3f)
                    showingMesage += it.toString() + "\n"
            }
        }
        textViewcostumerReport.setText(showingMesage)

    }

    fun back() {

        val intent = Intent(this@ReslutActivity, MainActivity::class.java)
        val username: String = editTextRegister.text.toString()
        intent.putExtra("nameandscore", "Thank you ,$username")

        startActivity(intent)

    }
}