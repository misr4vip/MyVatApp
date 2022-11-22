package com.example.myvatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_europe.*
import kotlin.random.Random

class EuropeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_europe)

    }

    var Income: Double = 0.0
    var Wife_Income: Double = 0.0
    var ismarid: Boolean = false
    var haveAcar: Boolean = false
    var iswifework: Boolean = false
    var Children: Int = 0
    var Clinders: Int = 0
    var IncomeTax: Double = 0.0
    var CarTax: Double = 0.0


    override fun onStart() {
        super.onStart()

        rb_not_maried.setOnClickListener {
            if (rb_not_maried.isChecked == true) {
                et_yourWifeIncome.visibility = View.GONE

                IsNotMaried()
            }
        }
        rb_yes_maried.setOnClickListener {
            if (rb_yes_maried.isChecked == true) {
                IsMaried()
            }

        }
        rb_not_Wife_work.setOnClickListener {
            if (rb_not_Wife_work.isChecked) {


                WifeNotwork()
            }
        }
        rb_yes_Wife_Work.setOnClickListener {
            if (rb_yes_Wife_Work.isChecked) {

                Wifework()
            }
        }
        rb_not_HaveAcar.setOnClickListener {
            if (rb_not_HaveAcar.isChecked) {

                doesnotHaveAcar()
            }
        }
        rb_yes_HaveAcar.setOnClickListener {
            if (rb_yes_HaveAcar.isChecked) {

                HaveAcar()
            }
        }




        btn_calc.setOnClickListener {
            if (et_yourIncome.text.length > 0)
            {
                Income = et_yourIncome.text.toString().toDouble()
            }
            if (et_yourWifeIncome.text.length > 0)
            {
                Wife_Income = et_yourWifeIncome.text.toString().toDouble()
            }
            if (et_how_many_childeren.text.length > 0)
            {
                Children = et_how_many_childeren.text.toString().toInt()
            }
            if (et_how_Mutch_cc.text.length > 0)
            {
                Clinders = et_how_Mutch_cc.text.toString().toInt()
            }
            // is not maried
            if (!ismarid) {


                            IncomeTax = Income * .42


            } else {
                if (Children >= 0) {
                    /// wife not work
                    if (!iswifework) {
                        when (Children) {
                            0 ->
                                IncomeTax = Income * .30
                            1 ->
                                IncomeTax = Income * .26
                            2 ->
                                IncomeTax = Income * .22
                            else ->
                                IncomeTax = Income * .18

                        }
                    } else {
                        when (Children) {
                            0 ->
                                IncomeTax = Income * .30 + Wife_Income * .40

                            1 ->
                                IncomeTax = Income * .26 + Wife_Income * .38
                            2 ->
                                IncomeTax = Income * .22 + Wife_Income * .36
                            else ->
                                IncomeTax = Income * .18 + Wife_Income * .32

                        }
                    }

                }
            }
            ///  have acar
            if (haveAcar) {
                when (Clinders) {
                    4 ->

                        CarTax = 37.0
                    6 ->
                        CarTax = 100.0
                    8 ->
                        CarTax = 250.0
                    else ->
                        CarTax = 500.0


                }

            }
            tv_tax_message.text = (IncomeTax + CarTax).toString()
            tv_tax_message.visibility = View.VISIBLE

        }


    }

    fun IsMaried()
    {
        et_how_many_childeren.visibility= View.VISIBLE
        tv_Wife.visibility = View.VISIBLE
        rg_wife.visibility = View.VISIBLE
        ismarid = true

    }
    fun IsNotMaried()
    {
        ismarid =false
        et_how_many_childeren.visibility= View.GONE
        tv_Wife.visibility = View.GONE
        rg_wife.visibility = View.GONE

    }
    fun WifeNotwork()
    {
        Wife_Income = 0.0
        iswifework=false
        if (et_yourWifeIncome.text.length>0)
        {
            et_yourWifeIncome.text.clear()
        }
        et_yourWifeIncome.visibility = View.GONE
    }
    fun Wifework()
    {
        iswifework = true
        et_yourWifeIncome.visibility = View.VISIBLE
    }
    fun HaveAcar()
    {
        haveAcar = true

        et_how_Mutch_cc.visibility = View.VISIBLE
    }
    fun doesnotHaveAcar()
    {
        CarTax = 0.0
        haveAcar = false
        if (et_how_Mutch_cc.text.length>0)
        {
            et_how_Mutch_cc.text.clear()
        }
        et_how_Mutch_cc.visibility = View.GONE
    }
}
