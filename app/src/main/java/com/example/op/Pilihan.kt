package com.example.op

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Pilihan : AppCompatActivity(), View.OnClickListener {
    private lateinit var btn_kel : Button
    private lateinit var btn_kelalihran : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pilihan)

        btn_kel = findViewById(R.id.btn_kel)
        btn_kel.setOnClickListener(this)

        btn_kelalihran = findViewById(R.id.btn_kelahiran)
        btn_kelalihran.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_kel-> run{
                val intent = Intent( this@Pilihan,MainActivity::class.java)
                startActivity(intent)
            }
        }
        when(v.id){
            R.id.btn_kelahiran-> run{
                val intent = Intent( this@Pilihan,MainActivityKelahiran::class.java)
                startActivity(intent)
            }
        }
    }
}