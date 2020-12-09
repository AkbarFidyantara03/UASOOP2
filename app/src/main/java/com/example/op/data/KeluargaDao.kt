package com.example.op.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import  androidx.room.Insert
import  androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.op.data.Keluarga


@Dao
interface KeluargaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addKeluarga(keluarga: Keluarga)

    @Query (value = "SELECT * FROM data_keluarga ORDER BY id ASC")
    fun readAllData(): LiveData<List<Keluarga>>
}