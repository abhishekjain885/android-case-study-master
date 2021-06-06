package com.target.targetcasestudy.presentation.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.DialogPaymentBinding
import com.target.targetcasestudy.util.validateCreditCard


/**
 * Dialog that displays a minimal credit card entry form.
 *
 * Your task here is to enable the "submit" button when the credit card number is valid and
 * disable the button when the credit card number is not valid.
 *
 * You do not need to input any of your actual credit card information. See `Validators.kt` for
 * info to help you get fake credit card numbers.
 *
 * You do not need to make any changes to the layout of this screen (though you are welcome to do
 * so if you wish).
 */
class PaymentDialogFragment : DialogFragment() {

    private lateinit var binding: DialogPaymentBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_payment, container, false)

        // TODO enable the submit button based on card number validity using Validators.validateCreditCard()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancel.setOnClickListener { dismiss() }
        binding.submit.setOnClickListener {
            Toast.makeText(context, "submitted", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        binding.submit.isEnabled = false


        binding.cardNumber.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.submit.isEnabled = validateCreditCard(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
    }

}