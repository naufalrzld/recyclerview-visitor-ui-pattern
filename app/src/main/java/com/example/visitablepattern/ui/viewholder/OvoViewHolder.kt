package com.example.visitablepattern.ui.viewholder

import android.view.View
import androidx.annotation.LayoutRes
import com.example.visitablepattern.R
import com.example.visitablepattern.base.AbstractViewHolder
import com.example.visitablepattern.data.response.Ovo
import com.example.visitablepattern.databinding.ItemOvoBinding
import com.example.visitablepattern.utils.CurrencyUtil

class OvoViewHolder(view: View) : AbstractViewHolder<Ovo>(view) {

    private val binding = ItemOvoBinding.bind(view)

    override fun onBind(data: Ovo) {
        binding.tvAmaount.text = CurrencyUtil.toIDR(data.amount)
        binding.tvPoint.text = CurrencyUtil.toIDR(data.point)
    }

    companion object {
        @LayoutRes
        const val LAYOUT = R.layout.item_ovo
    }
}