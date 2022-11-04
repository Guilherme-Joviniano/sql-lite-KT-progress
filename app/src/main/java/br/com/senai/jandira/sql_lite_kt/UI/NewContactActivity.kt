package br.com.senai.jandira.sql_lite_kt.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import br.com.senai.jandira.sql_lite_kt.databinding.ActivityNewContactBinding
import br.com.senai.jandira.sql_lite_kt.models.Contact
import br.com.senai.jandira.sql_lite_kt.repository.ContactRepository
import java.lang.Error
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NewContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewContactBinding
    private lateinit var contactRepository: ContactRepository

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
        btn.setOnClickListener {
            val contact = getFormData()
            val id = contactRepository.save(contact);

            Toast.makeText(this, ":$id", Toast.LENGTH_SHORT).show()

            finish()
        }
    }
    private fun getFormData(): Contact {
        val name = binding.editTextName.text.toString()
        val email = binding.editTextTextEmailAddress.text.toString()
        val phone = binding.editTextPhone.text.toString()
        var date = "";

        try {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = LocalDate.parse(binding.editTextDate.text.toString(), formatter).toString();
        } catch (exception: Exception) {
            Toast.makeText(this, "${exception.message}", Toast.LENGTH_SHORT).show()
        }


        return Contact(name, email, phone, null, date)
    }
}