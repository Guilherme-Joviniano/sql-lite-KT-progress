package br.com.senai.jandira.sql_lite_kt.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_contact")
data class Contact(
    var nome: String,
    var email: String,
    var telefone: String,
    var foto: String? = null,
    @ColumnInfo(name = "data_nascent") var dataNascent:String? = null
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0;
}

