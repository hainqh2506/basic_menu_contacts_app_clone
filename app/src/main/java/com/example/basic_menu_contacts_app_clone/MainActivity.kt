package com.example.basic_menu_contacts_app_clone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.widget.ListView
import com.example.basic_menu_contacts_app_clone.model.Person

class MainActivity : AppCompatActivity() {
    private lateinit var contacts : ArrayList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        val customAdapter = CustomAdapter(this, contacts)
        val listItem = findViewById<ListView>(R.id.listview)
        listItem.adapter = customAdapter
        listItem.setOnItemClickListener { parent, view, position, id ->
            val selectedPerson = contacts[position]
            Log.v("Click", selectedPerson.email)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id",selectedPerson.id.toString())
            intent.putExtra("username",selectedPerson.username)
            intent.putExtra("phone",selectedPerson.phoneNumber)
            intent.putExtra("email",selectedPerson.email)
            startActivity(intent)
        }
        registerForContextMenu(listItem)


    }




    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu, menu)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    private fun initData(){
        contacts = ArrayList<Person>()
        contacts.add( Person(1, "user", "12345678", "user@gmail.com"))
        contacts.add( Person(2, "doraemon", "12345678", "user@gmail.com"))
        contacts.add( Person(3, "shizuka", "12345678", "user@gmail.com"))
        contacts.add( Person(4, "nobita", "12345678", "user@gmail.com"))
        contacts.add( Person(5, "chaien", "12345678", "user@gmail.com"))
        contacts.add( Person(6, "xeko", "12345678", "user@gmail.com"))
    }
}