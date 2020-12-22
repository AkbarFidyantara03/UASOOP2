package com.example.op.data


import androidx.lifecycle.LiveData
import androidx.room.Dao
import  androidx.room.Insert
import  androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.op.data.Keluarga


@Dao
interface KelahiranDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun  addKelahiran(kelahiran: Kelahiran)

    @Query (value = "SELECT * FROM data_kelahiran ORDER BY id ASC")
    fun readAllData(): LiveData<List<Kelahiran>>
}