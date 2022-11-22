package com.example.myvatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_saudia.*

class SaudiaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saudia)


        et_saudia_amount.setOnClickListener {
            tv_vat_saudia.visibility = View.GONE

        }
        btn_Calc_saudia.setOnClickListener {

            if (et_saudia_amount.text.length < 1) {
                tv_vat_saudia.text = "You Must Enter Amount first"
                tv_vat_saudia.visibility = View.VISIBLE

            } else {

                var amount: Double = et_saudia_amount.text.toString().toDouble()
                amount *= .05
                tv_vat_saudia.text = amount.toString()
                tv_vat_saudia.append(" SR")
                tv_vat_saudia.visibility = View.VISIBLE


            }
        }
    }
}
