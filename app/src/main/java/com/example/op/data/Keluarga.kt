package com.example.op.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "data_keluarga")
data class Keluarga (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val  nama_kepala: String,
    val  alamat_keluarga: String,
    val  no_kk:Int
)
