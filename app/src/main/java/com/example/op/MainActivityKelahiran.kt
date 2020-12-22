package com.example.op


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.op.fragments.list.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivityKelahiran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kelahiran)

        setupActionBarWithNavController(findNavController(R.id.fragmentKelahiran))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentKelahiran)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}