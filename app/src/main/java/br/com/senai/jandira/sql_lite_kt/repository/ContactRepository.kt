package br.com.senai.jandira.sql_lite_kt.repository

import android.content.Context
import br.com.senai.jandira.sql_lite_kt.db.ContactDB
import br.com.senai.jandira.sql_lite_kt.models.Contact

class ContactRepository(context: Context) {
    private val db = ContactDB.getDatabase(context).contactDAO()

    fun getAll(): List<Contact> {
        return db.getAll()
    }
    fun getContactById(id: Int): Contact {
        return db.getContactById(id)
    }
    fun save(contact: Contact): Long {
        return db.save(contact)
    }
    fun update(contact: Contact): Int {
        return db.update(contact)
    }
    fun delete(contact: Contact): Int {
        return db.delete(contact)
    }
}