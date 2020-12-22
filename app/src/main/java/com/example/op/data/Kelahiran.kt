package com.example.op.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "data_kelahiran")
data class Kelahiran (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nama: String,
    val alamat: String,
    val nik:Int
)