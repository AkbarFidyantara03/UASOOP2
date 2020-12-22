package com.example.op.data

package com.example.op.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import  androidx.room.RoomDatabase

@Database(entities = [Kelahiran::class], version = 1, exportSchema = false)

abstract  class  KelahiranDatabase: RoomDatabase(){

    abstract  fun kelahiranDao(): KelahiranDao

    companion object{
        @Volatile
        private var  INSTANCE: KelahiranDatabase? = null

        fun getDatabase(context: Context): KelahiranDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    KelahiranDatabase::class.java,
                    "kelahiran_database")

                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}
