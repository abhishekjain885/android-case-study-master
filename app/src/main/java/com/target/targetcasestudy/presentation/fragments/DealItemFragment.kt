package com.target.targetcasestudy.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.FragmentDealItemBinding
import com.target.targetcasestudy.domain.model.ProductsItem
import com.target.targetcasestudy.util.loadImage
import com.target.targetcasestudy.util.showStrikeThrough


class DealItemFragment : Fragment() {
    private lateinit var fragmentDealItemBinding: FragmentDealItemBinding

    companion object {
        val FRAGMENT_NAME = DealItemFragment::class.java.name
        const val KEY_DEAL = "KEY_DEAL"

        @JvmStatic
        fun newInstance(deal: ProductsItem): DealItemFragment {
            val bundle = Bundle()
            bundle.putParcelable(KEY_DEAL, deal)
            return DealItemFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDealItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_deal_item, container, false)
        return fragmentDealItemBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val deal: ProductsItem? =
            arguments?.getParcelable(KEY_DEAL)
        deal?.let {
            fragmentDealItemBinding.apply {
                imgProductImage.loadImage(it.imageUrl ?: "")
                txtProductDescription.text = it.description
                txtProductTitle.text = it.title
                if (it.salePrice != null) {
                    txtSellingPrice.text = it.salePrice.displayString
                    txtMrpPrice.text = it.regularPrice?.displayString
                    txtMrpPrice.showStrikeThrough()
                } else {
                    txtMrpPrice.visibility = View.GONE
                    txtRegular.visibility = View.GONE
                    txtSellingPrice.text = it.regularPrice?.displayString
                }
            }
        }
    }
}
