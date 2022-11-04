package br.com.senai.jandira.sql_lite_kt.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.senai.jandira.sql_lite_kt.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Views
        val rvContacts = binding.rvContacts
        val btnAddContact = binding.fbNewContact

        // handles
        handleFloatBtn(btnAddContact)
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
}

