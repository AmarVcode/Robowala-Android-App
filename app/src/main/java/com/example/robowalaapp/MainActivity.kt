package com.example.robowalaapp

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.os.Bundle
import android.view.Menu
import android.view.Surface
import android.widget.VideoView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.robowalaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    fun onSurfaceTextureAvailable(surfaceTexture: SurfaceTexture?, width: Int, height: Int) {
        //  SurfaceTexture is ready for use.
        val surface = Surface(surfaceTexture)
        var mediaPlayer = MediaPlayer()
        //Some code here
        mediaPlayer?.setSurface(surface)

        //some code here
        mediaPlayer?.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(player: MediaPlayer?) {
                player?.start()
            }
        })
    }
    fun onSurfaceTextureUpdated(surfaceTexture: SurfaceTexture?) {
        // Specified SurfaceTexture is updated through
    }
    fun onSurfaceTextureDestroyed(surfaceTexture: SurfaceTexture?): Boolean {
        //  SurfaceTexture is about to be destroyed.
        return false
    }
    fun onSurfaceTextureSizeChanged(surfaceTexture: SurfaceTexture?, p1: Int, p2: Int) {
        //SurfaceTexture's buffers size changed
    }

}