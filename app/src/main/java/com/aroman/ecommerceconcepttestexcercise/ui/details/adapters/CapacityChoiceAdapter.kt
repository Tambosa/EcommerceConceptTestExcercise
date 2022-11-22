package com.aroman.ecommerceconcepttestexcercise.ui.details.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.domain.model.CapacityChoice
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemCapacityBinding

class CapacityChoiceAdapter(private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<CapacityChoiceAdapter.CapacityChoiceViewHolder>() {
    private var data = listOf<CapacityChoice>()
    private var lastCheckedPosition: Int = 0

    fun setData(data: List<CapacityChoice>) {
        this.data = data
    }

    fun getData() = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CapacityChoiceViewHolder(
        ItemCapacityBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClick
    )

    override fun onBindViewHolder(
        holder: CapacityChoiceViewHolder,
        position: Int
    ) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class CapacityChoiceViewHolder(
        private val binding: ItemCapacityBinding,
        private val onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(capacityChoice: CapacityChoice) {
            binding.buttonCapacity.text = "${capacityChoice.capacity} GB"
            if (capacityChoice.isChosen) {
                changeColor()
            } else {
                resetColor()
            }
            binding.buttonCapacity.setOnClickListener {
                data[lastCheckedPosition].isChosen = false
                notifyItemChanged(lastCheckedPosition)
                data[layoutPosition].isChosen = true
                notifyItemChanged(layoutPosition)

                lastCheckedPosition = layoutPosition
                onItemClick(layoutPosition)
            }
        }

        private fun changeColor() {
            binding.buttonCapacity.setTextColor(itemView.context.getColor(R.color.white))
            binding.buttonCapacity.backgroundTintList =
                itemView.context.resources.getColorStateList(R.color.ecommerce_orange, null)
        }

        private fun resetColor() {
            binding.buttonCapacity.setTextColor(itemView.context.getColor(R.color.ecommerce_grey_dark))
            binding.buttonCapacity.backgroundTintList =
                itemView.context.resources.getColorStateList(R.color.white, null)
        }
    }
}
