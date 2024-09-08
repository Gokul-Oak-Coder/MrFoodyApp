package com.example.mr_foodynewkotlin.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.mr_foodynewkotlin.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
//import kotlinx.android.synthetic.main.activity_login.*


class SignupTabFragment : Fragment() {

    lateinit var signupBtn : AppCompatButton
    lateinit var textInputLayout3 : TextInputLayout
    lateinit var textInputLayout4 : TextInputLayout
    lateinit var textInputLayout5 : TextInputLayout
    lateinit var textInputLayout6 : TextInputLayout
    lateinit var textInputLayout7 : TextInputLayout
    lateinit var username : TextInputEditText
    lateinit var emailId : TextInputEditText
    lateinit var password : TextInputEditText
    lateinit var confirmPass : TextInputEditText
    lateinit var phoneNo : TextInputEditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View =  inflater.inflate(R.layout.fragment_signup_tab, container, false)

        signupBtn = view.findViewById(R.id.signupBtn)
        textInputLayout3 = view.findViewById(R.id.textInputLayout3)
        textInputLayout4 = view.findViewById(R.id.textInputLayout4)
        textInputLayout5 = view.findViewById(R.id.textInputLayout5)
        textInputLayout6 = view.findViewById(R.id.textInputLayout6)
        textInputLayout7 = view.findViewById(R.id.textInputLayout7)
        username = view.findViewById(R.id.textInputEditText3)
        emailId = view.findViewById(R.id.textInputEditText4)
        password = view.findViewById(R.id.textInputEditText5)
        confirmPass = view.findViewById(R.id.textInputEditText6)
        phoneNo = view.findViewById(R.id.textInputEditText7)


        signupBtn.setOnClickListener {

            if(username.text.toString() != " " && emailId.text.toString() != " " && password .text.toString() == " " && confirmPass .text.toString() != " " && phoneNo.text.toString() != " "){
                Toast.makeText(context, "Please fill all the required field", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(context, "Data saved Successfully", Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }


}