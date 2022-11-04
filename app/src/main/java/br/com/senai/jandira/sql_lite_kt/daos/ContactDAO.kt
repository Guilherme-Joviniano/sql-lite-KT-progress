package br.com.senai.jandira.sql_lite_kt.daos

import androidx.room.*
import br.com.senai.jandira.sql_lite_kt.models.Contact

// Interface --> Contract with a Class

@Dao
interface ContactDAO {
    @Query("SELECT * FROM tbl_contact ORDER BY nome ASC")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM tbl_contact WHERE id = :id")
    fun getContactById(id: Int): Contact

    @Update
    fun update(contact: Contact): Int

    @Delete
    fun delete(contact: Contact): Int

    @Insert
    fun save(contact: Contact): Long
}
