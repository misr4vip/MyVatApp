package com.example.myvatapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.myvatapp.R
import com.example.myvatapp.models.Taxes
import kotlinx.android.synthetic.main.egypt_tax_row.view.*

class egyptTaxAdapter (context:Context,taxes:ArrayList<Taxes>): ArrayAdapter<Taxes>(context,0,taxes)
{

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        var row = LayoutInflater.from(context).inflate(R.layout.egypt_tax_row,parent,false)
        var tax = getItem(position)
        row.tv_row_egypt.text=tax?.taxName
        return row
    }


}