package com.example.menuutamaproject

import android.R.attr.bottom
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.menuutamaproject.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)


        bottomNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.menu_home-> loadFragment(HomeFragment())
                R.id.menu_profil-> loadFragment(ProfileFragment())
                R.id.menu_settings-> loadFragment(SettingFragment())
                R.id.menu_notif-> loadFragment(NotificationFragment())
                R.id.menu_help-> loadFragment(HelpFragment())
            }
            true
        }


        }
    private fun loadFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()

    }
}