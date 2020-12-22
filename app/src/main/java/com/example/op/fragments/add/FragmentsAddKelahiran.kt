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
import com.example.op.data.Kelahiran
import com.example.op.data.KelahiranViewModel
import kotlinx.android.synthetic.main.fragment_add_kelahiran.*
import kotlinx.android.synthetic.main.fragment_add_keluarga.add_alamat
import kotlinx.android.synthetic.main.fragment_add_keluarga.view.*


class FragmentsAddKelahiran : Fragment() {

    private  lateinit var bKelahiranViewModel: KelahiranViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view2 = inflater.inflate(R.layout.fragment_add_kelahiran, container, false)

        bKelahiranViewModel = ViewModelProvider( this).get(KelahiranViewModel::class.java)

        view2.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun  insertDataToDatabase(){
        val namaLahir = add_nama_bayi.text.toString()
        val alamatLahir = add_alamat.text.toString()
        val nikLahir = add_no_nik_lahir.text


        if (inputCheck(namaLahir, alamatLahir, nikLahir)){
            // check user object
            val kelahiran = Kelahiran ( 0, namaLahir, alamatLahir, Integer.parseInt(nikLahir.toString()))
            // add data to Database
            bKelahiranViewModel.addKelahiran(kelahiran)
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()
            //navigate back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)


        }else{
            Toast.makeText(requireContext(),"Please fill out all field.", Toast.LENGTH_LONG).show()
        }

    }

    private  fun  inputCheck(namaLahir: String, alamatLahir: String, nikLahir: Editable): Boolean{
        return !(TextUtils.isEmpty(namaLahir) && TextUtils.isEmpty(alamatLahir) && TextUtils.isEmpty(nikLahir))
    }
}

