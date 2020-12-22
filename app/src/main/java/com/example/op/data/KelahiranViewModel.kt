package com.example.op.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class KelahiranViewModel(aplication: Application): AndroidViewModel(aplication){
    private val readAllData: LiveData<List<Kelahiran>>
    private val repository: KelahiranRepository

    init {
        val kelahiranDao = KelahiranDatabase.getDatabase(aplication).kelahiranDao()
        repository = KelahiranRepository(kelahiranDao)
        readAllData =repository.readAllData
    }

    fun addKelahiran(kelahiran: Kelahiran){
        viewModelScope.launch (Dispatchers.IO){
            repository.addKelahiran(kelahiran)
        }
    }

}