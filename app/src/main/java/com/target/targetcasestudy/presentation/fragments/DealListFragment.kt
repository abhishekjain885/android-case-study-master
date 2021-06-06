package com.target.targetcasestudy.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.FragmentDealListBinding
import com.target.targetcasestudy.domain.model.ProductsItem
import com.target.targetcasestudy.presentation.adapter.DealItemAdapter
import com.target.targetcasestudy.presentation.interfaces.DealsAdapterListener
import com.target.targetcasestudy.presentation.interfaces.FragmentCallBacks
import com.target.targetcasestudy.presentation.viewmodel.DealsViewModel
import com.target.targetcasestudy.util.showHide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DealListFragment : Fragment(), DealsAdapterListener {

    private val viewModel: DealsViewModel by viewModels()
    private var mAdapter: DealItemAdapter? = null
    private lateinit var binding: FragmentDealListBinding
    private var mCallback: FragmentCallBacks? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentCallBacks) {
            mCallback = context
        } else throw ClassCastException(context.toString() + "must implement DealListFragment!")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_deal_list, container, false)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
        viewModel.getDeals().observe(viewLifecycleOwner) {
            mAdapter?.addData(it.products)
        }
        viewModel.isDataLoading().observe(viewLifecycleOwner) {
            binding.progressBar.showHide(it)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mAdapter = DealItemAdapter(this)
        viewModel.loadDeals()
    }

    override fun displayDeal(deal: ProductsItem?) {
        deal?.let {
            mCallback?.navigateToDisplayDeal(it)
        }
    }
}
