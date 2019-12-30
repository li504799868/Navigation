package com.lzp.navigation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.get

class MainActivity : AppCompatActivity() {

    private lateinit var navHostController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navHostController.addOnDestinationChangedListener(onDestinationChangedListener)
        handleFillNavGraph()

        val vm = navHostController.getViewModelStoreOwner(R.id.nav_graph).viewModelStore.clear()
    }

    private fun handleFillNavGraph(){
        // 手动设置NavGraph，并添加Bundle参数
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        navController.setGraph(navGraph, Bundle())
    }

    override fun onDestroy() {
        super.onDestroy()
        // 记得移除这个监听
        navHostController.removeOnDestinationChangedListener(onDestinationChangedListener)
    }

    private val onDestinationChangedListener =
        NavController.OnDestinationChangedListener { _, destination, _ -> Log.e("lzp", destination.label.toString()) }
}
