package presentation.screen.owl

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nastia.administrator.presentation.R
import entity.Owl

class OwlAdapter( private var listener: OnItemSelectedListener?) : RecyclerView.Adapter<OwlAdapter.OwlHolder>() {

    private var listItem: MutableList<Owl> = mutableListOf()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewId: Int): OwlHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.owl_item, viewGroup, false)
        return OwlHolder(view)
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: OwlHolder, pos: Int) {
        holder.itemView.setOnClickListener {
            listener?.itemSelected(pos)
        }
        holder.setItem(listItem[pos])
    }

    class OwlHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.owl_image)
        private val textView_name: TextView = itemView.findViewById(R.id.owls_name)
        private val textView_age: TextView = itemView.findViewById(R.id.owls_age)

        fun setItem(owl: Owl) {
            textView_name.text = owl.name
            textView_age.text = owl.age.toString()

            if (!owl.pic.isEmpty()) {
                Glide.with(imageView.context)
                        .load(owl.pic).into(imageView)
            }
//            else {
//                imageView.setImageDrawable(context.resources.getDrawable(R.drawable.sova_anmation_1))
//            }
        }
    }

    fun setElements(list: List<Owl>) {
        listItem.clear()
        listItem.addAll(list)
        notifyDataSetChanged()
    }

    fun filterList(newList: MutableList<Owl>) {
        this.listItem = newList
        notifyDataSetChanged()
    }

    interface OnItemSelectedListener {
        fun itemSelected(position: Int)
    }
}