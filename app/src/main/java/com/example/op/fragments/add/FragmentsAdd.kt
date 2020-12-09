package com.example.op.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.op.R
import com.example.op.data.Keluarga
import com.example.op.data.KeluargaViewModel
import kotlinx.android.synthetic.main.fragment_add_keluarga.*
import kotlinx.android.synthetic.main.fragment_add_keluarga.view.*


class FragmentsAdd : Fragment() {

    private  lateinit var mPedagangViewModel: KeluargaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_keluarga, container, false)

        mPedagangViewModel = ViewModelProvider( this).get(KeluargaViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun  insertDataToDatabase(){
        val keluarga = add_keluarga.text.toString()
        val alamat = add_alamat.text.toString()
        val no_nik = add_no_nik.text

        if (inputCheck(keluarga, alamat, no_nik)){
            // check user object
            val pedagang = Keluarga ( 0, keluarga, alamat, Integer.parseInt(no_nik.toString()))
            // add data to Database
            mPedagangViewModel.addKeluarga(pedagang)
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()
            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)


        }else{
            Toast.makeText(requireContext(),"Please fill out all field.", Toast.LENGTH_LONG).show()
        }

    }

    private  fun  inputCheck(nama: String, alamat: String, no_nik: Editable): Boolean{
        return !(TextUtils.isEmpty(nama) && TextUtils.isEmpty(alamat) && no_nik.isEmpty())
    }
}

