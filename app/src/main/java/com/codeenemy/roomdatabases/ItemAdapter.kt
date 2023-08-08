package com.codeenemy.roomdatabases

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.codeenemy.roomdatabases.databinding.ItemRecordsBinding

class ItemAdapter(private val items: ArrayList<EmployeeEntity>,
                   private val updateListener:(id:Int)->Unit,
                   private val deleteListener:(id:Int)->Unit
): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    class ViewHolder(binding: ItemRecordsBinding) : RecyclerView.ViewHolder(binding.root) {
        val llMain = binding.llMain
        val tvName = binding.tvItemName
        val tvEmail = binding.tvItemEmail
        val ibEdit = binding.ibEdit
        val ibDelete = binding.ibDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRecordsBinding.inflate(LayoutInflater.from(parent.context), parent,
            false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvEmail.text = item.email

        if (position%2==0){
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R
                .color.colorLightGrey))
        } else {
            holder.llMain.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R
                .color.white))
        }
        holder.ibEdit.setOnClickListener {
             updateListener.invoke(item.id)
        }
        holder.ibDelete.setOnClickListener{
             deleteListener.invoke(item.id)
        }

    }
}