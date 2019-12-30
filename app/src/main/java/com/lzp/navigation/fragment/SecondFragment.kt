package com.lzp.navigation.fragment

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.lzp.navigation.R
import kotlinx.android.synthetic.main.fragment_sec.*

class SecondFragment: BaseFragment() {

    override fun layoutId(): Int = R.layout.fragment_sec

    override fun initView(contentView: View) {
        Log.e("lzp","SecondFragment init")
        button.setOnClickListener {
            val navHostController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
            // 返回上一级
            navHostController.navInflater
            navHostController.navigateUp()
        }
    }

    override fun initData() {
        val name = arguments?.getString("from")
        if (name != null){
            Toast.makeText(requireContext(), name, Toast.LENGTH_SHORT).show()
        }
    }

}