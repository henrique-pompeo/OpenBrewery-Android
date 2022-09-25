package com.henrique.app.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.henrique.app.R
import com.henrique.app.databinding.ActivityMainBinding
import org.koin.core.context.loadKoinModules
import org.koin.dsl.bind
import org.koin.dsl.module

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(
            module {
                single { getNavController() } bind NavController::class
            }
        )

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController
    }

    private fun getNavController() : NavController {
        return (
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        ).navController
    }
}
