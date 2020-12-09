package com.example.op.data

import androidx.lifecycle.LiveData

    class KeluargaRepository (private val keluargaDao: KeluargaDao){

        val readAllData: LiveData<List<Keluarga>> = keluargaDao.readAllData()

        suspend fun  addKeluarga (keluarga: Keluarga){
            keluargaDao.addKeluarga(keluarga)
        }
    }