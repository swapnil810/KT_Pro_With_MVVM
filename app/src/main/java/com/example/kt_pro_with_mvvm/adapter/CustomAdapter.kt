package com.example.kt_pro_with_mvvm.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kt_pro_with_mvvm.R
import com.example.kt_pro_with_mvvm.activity.LogInActivity
import com.example.kt_pro_with_mvvm.activity.SeekBarActivity
import com.example.kt_pro_with_mvvm.models.ItemsViewModel

class CustomAdapter(private val mList: List<ItemsViewModel>, val context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]
        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.textView.text = ItemsViewModel.text

        holder.llayout.setOnClickListener(View.OnClickListener {

            Toast.makeText(context, "item_count: $position", Toast.LENGTH_SHORT).show()

            if (position == 2) {
                val intent = Intent(context, SeekBarActivity::class.java)
                context.startActivity(intent)
            }

        })

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val llayout: LinearLayout = itemView.findViewById(R.id.linnearWay)

    }
}