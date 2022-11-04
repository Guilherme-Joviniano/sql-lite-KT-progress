package br.com.senai.jandira.sql_lite_kt.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.senai.jandira.sql_lite_kt.R
import br.com.senai.jandira.sql_lite_kt.models.Contact

class ContactAdapter(context: Context) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
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


        fun bind(data: Contact) {
            name.text = data.nome
            email.text = data.email
            phone.text = data.telefone
            dataNasc.text = data.dataNascent

            image.text = data.nome.substring(0,1)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_holder_contact, parent, false)
        return ContactHolder(view)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bind(this.list[position])
    }

    override fun getItemCount(): Int {
        return this.list.size
    }


}