package com.henrique.openbreweryandroid.app.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.henrique.openbreweryandroid.R
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //openBreweryList()
    }

    private fun openBreweryList() {
//        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
//        val navController = navHost.navController
//        navController.navigate(R.id.breweryListFragment)
    }
}