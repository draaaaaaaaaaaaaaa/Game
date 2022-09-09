package com.daffa.news_game.componen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.news_game.databinding.ItemRowNewsBinding
import com.daffa.news_game.network.response.GameResponseItem

class GameAdapter(private val gameList: List<GameResponseItem>) :
    RecyclerView.Adapter<GameAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = gameList[position]
        holder.binding.apply {
            tvCategory.text = data.tag
            tvTitle.text = data.title
            tvDate.text = data.time
            Glide.with(imgNews.context)
                .load(data.thumb)
                .into(imgNews)
        }
    }

    override fun getItemCount(): Int = gameList.size
}