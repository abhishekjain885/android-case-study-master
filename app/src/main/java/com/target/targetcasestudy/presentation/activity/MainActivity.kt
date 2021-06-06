package com.target.targetcasestudy.presentation.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.target.targetcasestudy.R
import com.target.targetcasestudy.domain.model.ProductsItem
import com.target.targetcasestudy.presentation.interfaces.FragmentCallBacks
import com.target.targetcasestudy.presentation.fragments.DealItemFragment
import com.target.targetcasestudy.presentation.fragments.DealListFragment
import com.target.targetcasestudy.presentation.fragments.PaymentDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), FragmentCallBacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DealListFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.credit_card -> {
                PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
                true
            }
            else -> false
        }
    }

    override fun navigateToDisplayDeal(productsItem: ProductsItem?) {
        productsItem?.let {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, DealItemFragment.newInstance(it))
                .addToBackStack(DealItemFragment.FRAGMENT_NAME)
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.fragments.size > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
