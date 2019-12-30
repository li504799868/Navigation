package com.lzp.navigation.fragment

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.*
import com.lzp.navigation.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    private lateinit var navHostController: NavController

    override fun layoutId(): Int = R.layout.fragment_main

    override fun initView(contentView: View) {
        // 每次跳转都会重新实例化MainFragment
        Log.e("lzp","MainFragment init")
        navHostController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
    }

    override fun initData() {
        // 得到NavController对象，控制Fragment的切换
        textView.setOnClickListener {
            //            Toast.makeText(requireContext(), "nav", Toast.LENGTH_SHORT).show()

//            navHostController.navigate(R.id.secondFragment)
            // 直接跳转某个fragment，请注意，这种跳转方式会忽略配置的action
//            navHostController.navigate(R.id.secondFragment)
            // 使用配置的action进行跳转
//            navHostController.navigate(R.id.to_second)
            // 添加Bundle参数
            val bundle = Bundle()
            bundle.putString("from", "MainFragment")
//            navHostController.navigate(R.id.to_second, bundle)
            // 添加切换动画
//            navHostController.navigate(R.id.to_second, bundle, navOptions {
//                anim {
//                    enter = R.anim.enter_anim
//                    exit = R.anim.exit_anim
//                    popEnter = R.anim.pop_enter_anim
//                    popExit = R.anim.pop_exit_anim
//                }
//            })

            // 自定义NavDirections
//            navHostController.navigate(object : NavDirections {
//
//                override fun getArguments(): Bundle = bundle
//
//                override fun getActionId(): Int = R.id.to_second
//
//            })

            navHostController.navigate(Uri.parse("lzp://second/main"))

        }
    }

}