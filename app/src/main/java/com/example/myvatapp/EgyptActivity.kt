package com.example.myvatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.myvatapp.Adapters.egyptTaxAdapter
import com.example.myvatapp.models.Taxes
import kotlinx.android.synthetic.main.activity_egypt.*
import java.lang.Exception

class EgyptActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_egypt)
        var taxArray = arrayListOf<String>("Income Taxes","Property Taxes","Khawaga1020")

        try {

            //   Context   ,   resource   , list

            var taxAdapter=ArrayAdapter(this , android.R.layout.simple_selectable_list_item,taxArray)
              lv_egypt_tax.adapter = taxAdapter


            lv_egypt_tax.onItemClickListener=AdapterView.OnItemClickListener  { parent, view, position, id ->

                var taxName = view as TextView
                var b = Bundle()
                b.putString("tax",taxName.text.toString())
                val intent = Intent(applicationContext,IncomeTaxActivity::class.java)
                intent.putExtras(b)
                startActivity(intent)
            }
        }catch (e:Exception){
            Log.d("error ocured",e.message!!)
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }


    }
}
