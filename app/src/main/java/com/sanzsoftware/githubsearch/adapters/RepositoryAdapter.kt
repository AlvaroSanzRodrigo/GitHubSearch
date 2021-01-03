package com.sanzsoftware.githubsearch.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanzsoftware.githubsearch.R
import com.sanzsoftware.githubsearch.models.Repository
import kotlinx.android.synthetic.main.list_item.view.*


// Adaptador standar
class CharacterAdapter(var items: ArrayList<Repository>) : RecyclerView.Adapter<CharacterAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    var mCallBack: OnClickedItemListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item, parent, false).apply {
            mCallBack = parent.context as OnClickedItemListener
        } as View

        return MyViewHolder(view)
    }

    interface OnClickedItemListener {
        fun onItemSelected(repository: Repository)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            mCallBack?.onItemSelected(items[position])
        }
        holder.view.user_name_textView.text = items[position].name
        holder.view.repository_name_textView.text = items[position].owner.login
    }

    override fun getItemCount() = items.size
}