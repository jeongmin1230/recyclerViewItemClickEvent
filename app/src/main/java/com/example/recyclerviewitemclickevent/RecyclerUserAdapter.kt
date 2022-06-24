package com.example.recyclerviewitemclickevent

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerUserAdapter(private val items: ArrayList<UserData>) : RecyclerView.Adapter<RecyclerUserAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerUserAdapter.ViewHolder, position: Int) {

        val item = items[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicked -> ID : ${item.id}, Name : ${item.name}, img : ${item.img}", Toast.LENGTH_SHORT).show()
            Log.i("jeongmin", "선택 이미지 : ${item.img}")

            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("id", item.id) // id 전달
            intent.putExtra("name", item.name) // name 전달
            intent.putExtra("img", item.img) // data class 에서 img 를 int 로 지정해놓고, int 를 다음 인텐트로 넘겨준다!
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }
        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return RecyclerUserAdapter.ViewHolder(inflatedView)
    }

    // 각 항목에 필요한 기능을 구현
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v
        fun bind(listener: View.OnClickListener, item: UserData) {
            view.imgUser_icon.setImageResource(item.img) // 추가함
            view.txtUser_id.text = item.id
            view.txtUser_name.text = item.name
            view.setOnClickListener(listener)
        }
    }

}