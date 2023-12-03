package com.example.basic_menu_contacts_app_clone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.basic_menu_contacts_app_clone.model.Person

class CustomAdapter(context: Context, private val items: List<Person>): ArrayAdapter<Person>(context, R.layout.listitem, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.listitem, parent, false)
        val item = getItem(position)
        val username = itemView.findViewById<TextView>(R.id.username)
        username.text = item?.username ?: ""
        return itemView
    }
}