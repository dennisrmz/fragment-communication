package com.example.recyclerviewtofragment.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewtofragment.Interface.ClickListener
import com.example.recyclerviewtofragment.R
import com.example.recyclerviewtofragment.DataClass.StudentDataClass

class DataAdapter(private val data: ArrayList<StudentDataClass>, private val clickListener: ClickListener) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_data, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text = data[position].date
        holder.name.text = data[position].name
    }

    inner class ViewHolder(view: View, var listener: ClickListener) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val cell = view
        var name: TextView = view.findViewById(R.id.textView_name)
        var date: TextView = view.findViewById(R.id.textView_date)

        init {
            this.cell.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            this.listener.dataPosition(adapterPosition)
        }
    }
}