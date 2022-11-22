package dsi32.app.crudrecycle

import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.text.ParsePosition

class MyAdapter(private val newList: ArrayList<News>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListner: onItemCickeListner

    interface onItemCickeListner{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListner(listner: onItemCickeListner){
        mListner=listner
    }

    fun deleteItem(i : Int){
        newList.removeAt(i)
        notifyDataSetChanged()
    }

    fun addItem(i : Int,news: News){
        newList.add(i,news)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView,mListner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=newList[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text=currentItem.heading
        holder.btn.setOnClickListener { newList.removeAt(position)
        notifyDataSetChanged()}
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class MyViewHolder (itemView : View,listner: onItemCickeListner) : RecyclerView.ViewHolder(itemView){
        val btn : Button=itemView.findViewById(R.id.button)
        val titleImage : ImageView =itemView.findViewById(R.id.title_image)
        val tvHeading : TextView =itemView.findViewById(R.id.tv_Heading)

        init {
            itemView.setOnClickListener { 
                listner.onItemClick(adapterPosition)
            }

        }

    }


}