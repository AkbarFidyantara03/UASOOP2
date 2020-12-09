package com.example.op.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import  androidx.room.RoomDatabase

@Database(entities = [Keluarga::class], version = 1, exportSchema = false)

abstract  class  KeluargaDatabase: RoomDatabase(){

    abstract  fun keluargaDao(): KeluargaDao

    companion object{
        @Volatile
        private var  INSTANCE: KeluargaDatabase? = null

        fun getDatabase(context: Context): KeluargaDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KeluargaDatabase::class.java,
                    "keluarga_database")

                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
