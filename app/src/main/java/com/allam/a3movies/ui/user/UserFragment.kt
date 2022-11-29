package com.allam.a3movies.ui.user

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.allam.a3movies.R
import com.allam.a3movies.databinding.FragmentHomeBinding
import com.allam.a3movies.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    lateinit var binding: FragmentUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserBinding.inflate(inflater,container,false)
        return binding.root






    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       /* val edit_text = view.findViewById<EditText>(R.id.edit_user)
        val edit_pass = view.findViewById<EditText>(R.id.edit_pass)
        val btn_submit = view.findViewById<EditText>(R.id.btn_submit)


        btn_submit.setOnClickListener {
            val user_name = edit_text.text
            val pass = edit_pass.text
            fun Context.toast()
            = Toast.makeText(this,user_name,Toast.LENGTH_LONG).show()

        }*/




    }
}