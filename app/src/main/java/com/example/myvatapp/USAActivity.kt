package com.example.myvatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_usa.*

class USAActivity : AppCompatActivity() {
    var value: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usa)
        et_age.visibility = View.GONE
        et_usa_gift_value.visibility = View.GONE
        et_usa_income.visibility = View.GONE
        et_usa_property_value.visibility = View.GONE
        tv_usa_msg.visibility = View.GONE

    }

    override fun onStart() {
        super.onStart()
        val taxesArray: ArrayList<String>
        taxesArray = arrayListOf("Income Tax", "Property tax", "Gift tax")
        // context  , resource   , list
        val myAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taxesArray)
        gv_usa_taxes.adapter = myAdapter

        gv_usa_taxes.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

                //       var tax = getString(position)

                when (position) {
                    0 -> {
                        value = "Income"
                        et_age.visibility = View.VISIBLE
                        et_usa_property_value.visibility = View.GONE
                        et_usa_gift_value.visibility = View.GONE

                        et_age.setOnClickListener {
                            if (et_age.text.length > 0) {
                                et_usa_income.visibility = View.VISIBLE

                            } else {
                                et_usa_income.visibility = View.GONE
                            }
                        }
                    }
                    1 -> {
                        value = "Property"
                        et_age.visibility = View.GONE
                        et_usa_income.visibility = View.GONE
                        et_usa_property_value.visibility = View.VISIBLE
                    }

                    2 -> {
                        value = "Gift"
                        et_usa_income.visibility = View.GONE
                        et_age.visibility = View.GONE
                        et_usa_property_value.visibility = View.GONE

                        et_usa_gift_value.visibility = View.VISIBLE
                    }
                }
            }

        btn_usa_calc.setOnClickListener {

            try {
                if (et_age.isVisible) {
                    if (et_age.text.toString().toDouble() > 65) {
                        tv_usa_msg.text = "your tax is 0.0 becouse your Age is more than 65"
                        tv_usa_msg.visibility = View.VISIBLE
                    } else if (et_age.text.toString().toDouble() > 0 && et_age.text.toString().toDouble() < 66) {
                        tv_usa_msg.text =
                            "your Tax is ${et_usa_income.text.toString().toDouble() * .23} $"
                        tv_usa_msg.visibility = View.VISIBLE
                    }
                }

                if (et_usa_property_value.isVisible && et_usa_property_value.text.length > 0) {
                    tv_usa_msg.text =
                        "your tax is ${et_usa_property_value.text.toString().toDouble() * .18} $ "
                    tv_usa_msg.visibility = View.VISIBLE
                }

                if (et_usa_gift_value.isVisible && et_usa_gift_value.text.length > 0) {
                    tv_usa_msg.text =
                        "your tax is ${et_usa_gift_value.text.toString().toDouble() * .03} $"
                    tv_usa_msg.visibility = View.VISIBLE
                }
            } catch (e: Exception) {
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG).show()
            }

        }
    }
}

