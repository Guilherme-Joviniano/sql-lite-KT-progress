package br.com.senai.jandira.sql_lite_kt.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.senai.jandira.sql_lite_kt.adapter.ContactAdapter
import br.com.senai.jandira.sql_lite_kt.databinding.ActivityMainBinding
import br.com.senai.jandira.sql_lite_kt.models.Contact
import br.com.senai.jandira.sql_lite_kt.repository.ContactRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterContact: ContactAdapter
    private lateinit var contactRepository: ContactRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        contactRepository = ContactRepository(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Views
        val btnAddContact = binding.fbNewContact

        // Handlers
        handleFloatBtn(btnAddContact)
    }

    private fun onRunRvContact() {
        // rvContact
        binding.rvContacts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        this.adapterContact = ContactAdapter(this)

        bindRvContact(contactRepository.getAll())

        binding.rvContacts.adapter = this.adapterContact
    }

    // Bind's
    private fun bindRvContact(data: List<Contact>) {
        this.adapterContact.updateList(data)
    }

    // Intent's
    private fun openNewContactRegister(): Intent {
        return Intent(this, NewContactActivity::class.java)
    }

    // Handle's
    private fun handleFloatBtn(btn: FloatingActionButton) {
        btn.setOnClickListener {
            startActivity(openNewContactRegister());
        }
    }

    override fun onResume() {
        super.onResume()
        onRunRvContact()
    }
}

