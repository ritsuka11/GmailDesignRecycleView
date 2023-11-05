package com.example.emaildesign

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val items: ArrayList<Model>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mail: TextView = itemView.findViewById(R.id.mail)
        val title: TextView = itemView.findViewById(R.id.title)
        val avatar: TextView = itemView.findViewById(R.id.textView)
        val time: TextView = itemView.findViewById(R.id.time)
        val content: TextView = itemView.findViewById(R.id.content)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(itemView)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.mail.text = item.mail
        holder.title.text = item.title
        holder.avatar.text = item.mail.first().toString().uppercase()
        holder.time.text = item.time
        holder.content.text = item.content
        holder.checkBox.isChecked = item.selected

        holder.title.ellipsize = android.text.TextUtils.TruncateAt.END
        holder.content.ellipsize = android.text.TextUtils.TruncateAt.END

        if (item.selected) {
            holder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
        } else {
            holder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)
        }

        holder.checkBox.setOnClickListener {
            item.selected = !item.selected
            if (item.selected) {
                holder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_on)
            } else {
                holder.checkBox.setButtonDrawable(android.R.drawable.btn_star_big_off)
            }
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
