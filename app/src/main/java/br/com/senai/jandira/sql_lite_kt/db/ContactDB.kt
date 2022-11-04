package br.com.senai.jandira.sql_lite_kt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.senai.jandira.sql_lite_kt.daos.ContactDAO
import br.com.senai.jandira.sql_lite_kt.models.Contact


@Database(entities = [Contact::class], version = 1)
abstract class ContactDB: RoomDatabase() {
    abstract fun contactDAO(): ContactDAO

    companion object {
        private lateinit var instance: ContactDB
        fun getDatabase(context: Context): ContactDB {
            if (!::instance.isInitialized) {
               instance = Room.databaseBuilder(context, ContactDB::class.java, "db_agenda").allowMainThreadQueries().build()
            }
            return instance
        }
    }
}