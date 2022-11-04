package br.com.senai.jandira.sql_lite_kt.user

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.com.senai.jandira.sql_lite_kt.databinding.ActivityNewContactBinding
import br.com.senai.jandira.sql_lite_kt.models.Contact
import br.com.senai.jandira.sql_lite_kt.repository.ContactRepository
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class NewContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewContactBinding
    private lateinit var contactRepository: ContactRepository
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()

        contactRepository = ContactRepository(this)

        val btnSave = binding.saveButton

        // Handle
        handleBtnSave(btnSave)
    }

    private fun handleBtnSave(btn: Button) {
        this.id = intent.getIntExtra("id", 0)

        if (this.id > 0) {
            btn.text = "Update"
            binding.deleteButton2.visibility = View.VISIBLE

            val selectedContact = contactRepository.getContactById(this.id)
            val ( nome, email, telefone ) = selectedContact

            binding.editTextName.setText(nome)
            binding.editTextTextEmailAddress.setText(email)
            binding.editTextPhone.setText(telefone)

            // DELETE
            binding.deleteButton2.setOnClickListener {

                val builder = AlertDialog.Builder(this)

                builder.setTitle("Excluir")
                builder.setMessage("Confirma a exclusao da(o) ${selectedContact.nome}?")

                builder.setPositiveButton("Sim") {_,_ ->
                    contactRepository.delete(selectedContact)
                    finish()
                }

                builder.setNegativeButton("Nao") {_,_ ->

                }

                builder.show()
            }
            // UPDATE
            btn.setOnClickListener {
                val newContact = getFormData()

                selectedContact.nome = newContact.nome
                selectedContact.email = newContact.email
                selectedContact.telefone = newContact.telefone
                selectedContact.dataNascent = newContact.dataNascent

                contactRepository.update(selectedContact)

                finish()
            }

        } else {
            // CREATE
            btn.setOnClickListener {
                val contact = getFormData()
                contactRepository.save(contact);
                finish()
            }
        }
    }
    private fun getFormData(): Contact {
        val name = binding.editTextName.text.toString()
        val email = binding.editTextTextEmailAddress.text.toString()
        val phone = binding.editTextPhone.text.toString()
        val date = binding.editTextDate.text.toString()


        return Contact(name, email, phone, null, date)
    }
}
