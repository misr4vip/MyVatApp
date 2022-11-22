package com.example.myvatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_income_tax.*

class IncomeTaxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_income_tax)
        val intent = intent
        val b = intent.extras
        val tax: String? = b?.getString("tax")
        var amount: Double = 0.0
        var vtax: Double = 0.0
        if (tax == "Income Taxes") {
            et_income.hint = "Enter your income in a year"
        }
        if (tax == "Property Taxes") {

            rb_firstElemnet.text = "Yours unit"
            rb_SecondElemnet.text = "Addetional unit"
            et_income.hint = "write the property value "
            rg_1.visibility = View.VISIBLE

        }

        et_income.setOnClickListener {
            tv_msg.text = " "
        }
        btn_Calculate.setOnClickListener {
            if (tax == "Income Taxes") {
                et_income.hint = "Enter your income in a year"

                if (et_income.text.toString().toDouble() > 0) {

                    amount = et_income.text.toString().toDouble()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Sorry You didn't enter any Thing!",
                        Toast.LENGTH_LONG
                    ).show()
                }
                if (amount < 6500.00 || amount == 6500.00) {

                    tv_msg.text =
                        "You are exempt from tax becouse your income ${amount} is < or = 6500"
                } else if (amount > 6500.00 && amount < 30000.00) {
                    vtax = amount * .1

                    tv_msg.text =
                        "Your tax is %10 of your income and this = ${vtax} pound becouse your income is ${amount} is > 6500 and < 30000 "
                } else if (amount > 30000.00 && amount < 45000.00) {
                    vtax = amount * .15

                    tv_msg.text =
                        "Your tax is %15 of your income and this = ${vtax} pound becouse your income is ${amount} is > 30000 and < 45000 "
                } else if (amount > 45000.00 && amount < 200000.00) {
                    vtax = amount * .20

                    tv_msg.text =
                        "Your tax is %20 of your income and this = ${vtax} pound becouse your income is ${amount} is > 45000 and < 200000 "
                } else if (amount > 200000.00) {
                    vtax = amount * .225

                    tv_msg.text =
                        "Your tax is %22.5 of your income and this = ${vtax} pound becouse your income is ${amount} is > 200000 "
                } else {
                    tv_msg.text = "enter valid income"
                }


            }
            if (tax == "Property Taxes") {

                    if (rb_firstElemnet.isChecked)
                    {
                        if (et_income.text.length > 0)
                        {
                            amount = et_income.text.toString().toDouble()
                            if (amount > 2000000.00)
                            {
                                vtax = amount * .001
                                tv_msg.text= "Your tax is %.1 of your property and this = ${vtax} pound becouse your property value is ${amount} is > 2000000 "
                            }else{
                                tv_msg.text= "You are exempt from tax :) "
                            }
                        }else{
                            tv_msg.text = "enter valid value"
                        }
                    }else if (rb_SecondElemnet.isChecked)
                    {

                        amount = et_income.text.toString().toDouble()
                        vtax = amount * .001
                        tv_msg.text= "${vtax} pound"

                    }




            }
        }


    }
}
