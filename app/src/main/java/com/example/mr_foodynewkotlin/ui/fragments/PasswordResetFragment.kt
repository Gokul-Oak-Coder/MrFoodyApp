package com.example.mr_foodynewkotlin.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.mr_foodynewkotlin.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class PasswordResetFragment : Fragment() {

    lateinit var textInputLayout8: TextInputLayout
    lateinit var phoneNumber: TextInputEditText
    lateinit var sendOTP : AppCompatButton
    lateinit var textView13 : TextView
    lateinit var otp_box1 : EditText
    lateinit var otp_box2: EditText
    lateinit var otp_box3: EditText
    lateinit var otp_box4: EditText
    lateinit var reset_password_layout :TextInputLayout
    lateinit var confirm_resetPassword_layout :TextInputLayout
    lateinit var reset_password_btn:AppCompatButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_password_reset, container, false)

        textInputLayout8 = view.findViewById(R.id.textInputLayout8)
        phoneNumber = view.findViewById(R.id.phoneNumber)
        sendOTP = view.findViewById(R.id.otp_btn)
        textView13= view.findViewById(R.id.textView13)
        otp_box1= view.findViewById(R.id.otp_box1)
        otp_box2= view.findViewById(R.id.otp_box2)
        otp_box3= view.findViewById(R.id.otp_box3)
        otp_box4= view.findViewById(R.id.otp_box4)
        reset_password_layout= view.findViewById(R.id.reset_password_layout)
        confirm_resetPassword_layout= view.findViewById(R.id.confirm_resetPassword_layout)
        reset_password_btn= view.findViewById(R.id.reset_password_btn)

        sendOTP.setOnClickListener {
            if(phoneNumber.text.toString().isEmpty()){
                textInputLayout8.error = "Please enter registered phone number"
            }
           else if (phoneNumber.text.toString().length != 10 ){
               textInputLayout8.error = "Please check your phone number"
           }
           else{
//            context?.let { it1 -> Animatoo.animateSwipeRight(it1) }
                textView13.isVisible = true
                otp_box1.isVisible = true
                otp_box2.isVisible = true
                otp_box3.isVisible = true
                otp_box4.isVisible = true
                reset_password_layout.isVisible = true
                confirm_resetPassword_layout.isVisible = true
                reset_password_btn.isVisible = true
            Toast.makeText(context, "OTP sent to your mobile", Toast.LENGTH_SHORT).show()
        }
        }
        phoneNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textInputLayout8.error = null
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })
        return view
    }


}