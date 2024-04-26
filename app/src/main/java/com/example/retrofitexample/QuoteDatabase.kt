package com.example.retrofitexample

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Result::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun quoteDao():QuoteDao

    companion object{
        @Volatile
        var INSTANCE : QuoteDatabase? = null

        fun getDatabaseInstance(context:Context):QuoteDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuoteDatabase::class.java, "QuoteDB"
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }

}