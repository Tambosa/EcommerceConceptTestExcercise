package com.aroman.ecommerceconcepttestexcercise.ui.details.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aroman.domain.model.ColorChoice
import com.aroman.ecommerceconcepttestexcercise.R
import com.aroman.ecommerceconcepttestexcercise.databinding.ItemColorBinding

class ColorChoiceAdapter(private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<ColorChoiceAdapter.ColorChoiceViewHolder>() {
    private var data = listOf<ColorChoice>()
    private var lastCheckedPosition: Int = 0

    fun setData(data: List<ColorChoice>) {
        this.data = data
    }

    fun getData() = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ColorChoiceViewHolder(
        ItemColorBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        onItemClick
    )

    override fun onBindViewHolder(holder: ColorChoiceViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class ColorChoiceViewHolder(
        private val binding: ItemColorBinding,
        private val onItemClick: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(colorChoice: ColorChoice) {
            binding.image.drawable.setTint(Color.parseColor(colorChoice.color))
            if (colorChoice.isChosen) {
                addCheck()
            } else {
                removeCheck()
            }
            binding.image.setOnClickListener {
                data[lastCheckedPosition].isChosen = false
                notifyItemChanged(lastCheckedPosition)
                data[layoutPosition].isChosen = true
                notifyItemChanged(layoutPosition)

                lastCheckedPosition = layoutPosition
                onItemClick(layoutPosition)
            }
        }

        fun addCheck() {
            binding.image.foreground = itemView.context.getDrawable(R.drawable.ic_baseline_check_24)
        }

        fun removeCheck() {
            binding.image.foreground = null
        }
    }
}