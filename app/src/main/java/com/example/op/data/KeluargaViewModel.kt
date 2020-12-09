package com.example.op.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class KeluargaViewModel(aplication: Application): AndroidViewModel(aplication){
    private val readAllData: LiveData<List<Keluarga>>
    private val repository: KeluargaRepository

    init {
        val keluargaDao = KeluargaDatabase.getDatabase(aplication).keluargaDao()
        repository = KeluargaRepository(keluargaDao)
        readAllData =repository.readAllData
    }

    fun addKeluarga(keluarga: Keluarga){
        viewModelScope.launch (Dispatchers.IO){
            repository.addKeluarga(keluarga)
        }
    }

}