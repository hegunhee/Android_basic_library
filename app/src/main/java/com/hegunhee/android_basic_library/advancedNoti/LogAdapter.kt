package com.hegunhee.android_basic_library.advancedNoti

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.android_basic_library.advancedNoti.db.LogData
import com.hegunhee.android_basic_library.databinding.LogItemBinding

class LogAdapter(private val list : List<LogData>) : RecyclerView.Adapter<LogAdapter.LogViewHolder>() {

    inner class LogViewHolder(val binding : LogItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(log : LogData){
            with(binding){
                logTextView.text = log.log
                dayTextView.text = log.date
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        return LogViewHolder(LogItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}