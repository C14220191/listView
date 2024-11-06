package com.example.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var data = mutableListOf<String>()
        data.addAll(listOf("1", "2", "3", "4", "5"))
        val lvAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
        val _lv1 = findViewById<ListView>(R.id.lv1)

        _lv1.adapter = lvAdapter

        val  _button = findViewById<Button>(R.id.button)
        _button.setOnClickListener {
            var dtAkhir = Integer.parseInt(data.get(data.size-1))+1
            data.add(dtAkhir.toString())
            lvAdapter.notifyDataSetChanged()
        }
        _lv1.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"${data[position]}",Toast.LENGTH_LONG).show()
        }
        val _btn2 = findViewById<Button>(R.id.button2)
        _btn2.setOnClickListener {
            data.removeFirst()
            lvAdapter.notifyDataSetChanged()
        }
    }
}