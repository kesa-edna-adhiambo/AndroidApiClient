package com.example.postapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postapp.databinding.CommentsListItemBinding

class AdapterComments(var comments: List<Comments>) : RecyclerView.Adapter<CommentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val binding = CommentsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comment = comments[position]
        holder.binding.tvName.text = comment.name
        holder.binding.tvEmail.text = comment.email
        holder.binding.tvBody.text = comment.body
    }

    override fun getItemCount(): Int = comments.size

    // Optional: Method to update the comments list
//    fun updateComments(newComments: List<Comments>) {
//        comments = newComments
////        notifyDataSetChanged() // Notify the adapter to refresh the views
//    }
}

class CommentsViewHolder(val binding: CommentsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
}



//package com.example.postapp
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.postapp.databinding.CommentsListItemBinding
//
//class AdapterComments(var comments: List<Comments>) : RecyclerView.Adapter<CommentsViewHolder>() {
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): CommentsViewHolder {
//        val binding = CommentsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return CommentsViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder:CommentsViewHolder, position: Int) {
//        val comment = comments[position]
//        holder.binding.tvName.text = comment.name
//        holder.binding.tvEmail.text = comment.email
//        holder.binding.tvBody.text = comment.body
//    }
//
//    override fun getItemCount(): Int = comments.size
//
//}
//
//class CommentsViewHolder(val binding: CommentsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
//
//}