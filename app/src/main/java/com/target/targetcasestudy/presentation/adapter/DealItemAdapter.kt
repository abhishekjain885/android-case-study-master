package com.target.targetcasestudy.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.DealListItemBinding
import com.target.targetcasestudy.domain.model.ProductsItem
import com.target.targetcasestudy.presentation.interfaces.DealsAdapterListener
import com.target.targetcasestudy.util.loadImage
import java.util.*

class DealItemAdapter(private val listener: DealsAdapterListener) :
    RecyclerView.Adapter<DealItemViewHolder>() {

    private val deals: MutableList<ProductsItem?> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealItemViewHolder {
        val dealListItemBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            R.layout.deal_list_item,
            parent,
            false
        )
        return DealItemViewHolder(dealListItemBinding)
    }

    override fun getItemCount(): Int {
        return deals.size
    }

    override fun onBindViewHolder(viewHolder: DealItemViewHolder, position: Int) {
        val item = deals[position]
        val binding = viewHolder.dataBinding as DealListItemBinding
        binding.dealListItemTitle.text = item?.title
        binding.dealListItemPrice.text = item?.regularPrice?.displayString
        binding.dealListItemImageView.loadImage(item?.imageUrl ?: "")
        binding.root.setOnClickListener {
            listener.displayDeal(item)
        }
    }

    fun addData(list: List<ProductsItem?>?) {
        if (list != null && list.isNotEmpty()) {
            this.deals.clear()
            this.deals.addAll(list)
            notifyDataSetChanged()
        }

    }

}

class DealItemViewHolder(val dataBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(dataBinding.root)