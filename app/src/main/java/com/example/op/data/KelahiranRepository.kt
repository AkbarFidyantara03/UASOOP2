package com.example.op.data

package com.example.op.data

import androidx.lifecycle.LiveData

class KelahiranRepository (private val kelahiranDao: KelahiranDao){

    val readAllData: LiveData<List<Kelahiran>> = kelahiranDao.readAllData()

    suspend fun  addKelahiran (kelahiran: Kelahiran){
        kelahiranDao.addKelahiran(kelahiran)
    }
}