package com.alirahimi.androidcourse.feature.post.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alirahimi.androidcourse.databinding.ItemPostBinding
import com.alirahimi.androidcourse.feature.post.domain.data.model.PostResponse

class PostAdapter(
    private val items: List<PostResponse.PostResponseItem>
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]
        holder.bind(data)
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostResponse.PostResponseItem) {
            binding.title.text = item.title
            binding.subTitle.text = item.id.toString()
        }
    }
}