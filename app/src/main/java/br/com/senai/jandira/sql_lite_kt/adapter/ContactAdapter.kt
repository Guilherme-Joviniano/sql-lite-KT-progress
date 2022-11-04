package br.com.senai.jandira.sql_lite_kt.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.senai.jandira.sql_lite_kt.R
import br.com.senai.jandira.sql_lite_kt.models.Contact
import br.com.senai.jandira.sql_lite_kt.repository.ContactRepository
import br.com.senai.jandira.sql_lite_kt.user.NewContactActivity

class ContactAdapter(val context: Context) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    private var list = listOf<Contact>(); // list of characters

    fun updateList(list: List<Contact>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ContactHolder(view: View): RecyclerView.ViewHolder(view) {

        private val image = view.findViewById<TextView>(R.id.image)
        private val email = view.findViewById<TextView>(R.id.textViewEmail)
        private val name = view.findViewById<TextView>(R.id.textViewNome)
        private val phone = view.findViewById<TextView>(R.id.textViewTelefone)
        private val dataNasc = view.findViewById<TextView>(R.id.textViewDataNasc)

        private val cardContact = view.findViewById<CardView>(R.id.cardViewContact)

        fun bind(data: Contact, context: Context) {

            val openRegisterActivity = Intent(context, NewContactActivity::class.java)

            name.text = data.nome
            email.text = data.email
            phone.text = data.telefone
            dataNasc.text = data.dataNascent

            image.text = data.nome.substring(0,1)

            cardContact.setOnClickListener {
                openRegisterActivity.putExtra("id", data.id);
                context.startActivity(openRegisterActivity)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_holder_contact, parent, false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(this.list[position], context)
    }

    override fun getItemCount(): Int {
        return this.list.size
    }


}