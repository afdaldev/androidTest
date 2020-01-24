package io.kodingworks.androidtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import io.kodingworks.domain.models.Category
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryAdapter(private val longClickListener: (Category) -> Unit) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    private var categoryList: List<Category> = emptyList()

    fun setCategoryList(categoryList: List<Category>) {
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val list = categoryList[position]
        when (holder) {
            is CategoryViewHolder -> holder.bind(list)
        }
        holder.itemView.setOnLongClickListener {
            longClickListener(list)
            true
        }
    }

    inner class CategoryViewHolder(itemView: View) : BaseViewHolder<Category>(itemView) {

        override fun bind(item: Category) {
            itemView.tvCategory.text = item.name
            Picasso.get().load(item.image).fit().into(itemView.imgCategory)
        }
    }
}