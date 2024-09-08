package com.example.mr_foodynewkotlin.ui.fragments

import android.content.Intent
import android.graphics.Color.WHITE
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.mr_foodynewkotlin.ui.NavigationPage
import com.example.mr_foodynewkotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginTabFragment : Fragment() {

    private lateinit var textInputLayout : TextInputLayout
    private lateinit var textInputLayout2: TextInputLayout
    private lateinit var email_id: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var loginBtn : AppCompatButton
    private lateinit var forgetPassword : LinearLayout
    private lateinit var resetPassword : TextView
    private lateinit var goog_btn : FloatingActionButton
    private lateinit var faceboo_btn : FloatingActionButton
    private lateinit var or :TextView
    private lateinit var lLayoutSignup : LinearLayout
    private lateinit var signUp : TextView


    private var v :Float = 0F
    private var email:String = "gokul@gmail.com"
    private var pass:String = "1234"




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login_tab, container, false)


        // Initializing the Id's of widgets
        textInputLayout = view.findViewById(R.id.textInputLayout)
        textInputLayout2 = view.findViewById(R.id.textInputLayout2)
        email_id = view.findViewById(R.id.textInputEditText)
        password = view.findViewById(R.id.textInputEditText2)
        loginBtn = view.findViewById(R.id.loginBtn)
        forgetPassword = view.findViewById(R.id.forgetPassword)
        resetPassword = view.findViewById(R.id.resetPassword)
//        goog_btn = view.findViewById(R.id.google_btn)
//        faceboo_btn = view.findViewById(R.id.facebook_btn)
        or = view.findViewById(R.id.or)
        lLayoutSignup = view.findViewById(R.id.lLayoutSignup)
        signUp = view.findViewById(R.id.signUp)


        // Below function to call the Animation
        anim()


        validation(email, pass)


            resetPassword.setOnClickListener {

                val resetFragment = PasswordResetFragment()
                val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.linearLayout, resetFragment)
                fragmentTransaction.addToBackStack("ok")
                fragmentTransaction.commit()
                //context?.let { it1 -> Animatoo.animateSlideLeft(it1) }
            }

       signUp.setOnClickListener {

            val resetFragment = SignupTabFragment()
            val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.linearLayout, resetFragment)
            fragmentTransaction.addToBackStack("ok")
            fragmentTransaction.commit()
            //context?.let { it1 -> Animatoo.animateSlideLeft(it1) }
        }



      email_id.addTextChangedListener(object : TextWatcher{
          override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
          }
          override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                      textInputLayout.error = null
          }
          override fun afterTextChanged(p0: Editable?) {

          }
      })

        password.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textInputLayout2.error = null
            }
            override fun afterTextChanged(p0: Editable?) {

            }
        })



            return view
        }

    private fun validation(email: String, pass: String) {


     // Default Log In Credentials



        loginBtn.setOnClickListener {

            val builder = context?.let { AlertDialog.Builder(it) }
            val dialogView = layoutInflater.inflate(R.layout.progress_bar_style, null)
            val message = dialogView.findViewById<TextView>(R.id.progressMessage)
            message.text = "Logging In..."
            message.setTextColor(WHITE)
            builder?.setView(dialogView)
            builder?.setCancelable(false)
            val dialog = builder?.create()!!
            dialog.show()

            if (email.equals(email_id.text.toString()) && pass.equals(password.text.toString())) {

                Handler(Looper.myLooper()!!).postDelayed({dialog.dismiss()
                    val intent = Intent(context, NavigationPage::class.java)
                    startActivity(intent)
                    activity?.finish()
//                    context?.let { it1 -> Animatoo.animateSlideLeft(it1) }
                }, 1000)

            } else if (email.equals(email_id.text.toString()) && !pass.equals(password.text.toString())) {

                Handler(Looper.getMainLooper()).postDelayed({dialog.dismiss()
                        textInputLayout2.error = "Please enter valid Password"
                        textInputLayout.error = ""


                }, 1000)

            } else if (!email.equals(email_id.text.toString()) && pass.equals(password.text.toString())) {

                Handler(Looper.getMainLooper()).postDelayed({dialog.dismiss()
                        textInputLayout.error = "Please enter valid Email Id"
                        textInputLayout2.error = ""

                }, 1000)

            } else {

                Handler(Looper.myLooper()!!).postDelayed({dialog.dismiss()
                    if(email_id.text.toString().isEmpty() && password.text.toString().isEmpty()){
                        textInputLayout2.error = "Field could not be empty"
                        textInputLayout.error = "Field could not be empty"
                    }else {
                        textInputLayout2.error = "Please enter valid Password"
                        textInputLayout.error = "Please enter valid Email Id"
                    }

                }, 1000)

            }
        }
    }
    fun anim() {
            textInputLayout.translationX = 300F
            textInputLayout2.translationX = 300F
            loginBtn.translationX = 300F
            forgetPassword.translationX = 300F
//            goog_btn.translationY = 300F
//            faceboo_btn.translationY = 300F
            or.translationY = 300F
        lLayoutSignup.translationY = 300F


            textInputLayout.alpha = v
            textInputLayout2.alpha = v
            loginBtn.alpha = v
            forgetPassword.alpha = v
//            goog_btn.alpha = v
//            faceboo_btn.alpha = v
           or.alpha = v
        lLayoutSignup.alpha = v


            textInputLayout.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()
            textInputLayout2.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()
            loginBtn.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()
            forgetPassword.animate().translationX(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()
//            goog_btn.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(400).start()
//            faceboo_btn.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(600).start()
            or.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()
            lLayoutSignup.animate().translationY(0F).alpha(1F).setDuration(1000).setStartDelay(700).start()
        }

    }