package com.murmudevelopers.radioinfo

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Getting View ID
        val mainView = findViewById<LinearLayout>(R.id.mainScreen)

        try{
            val intent = Intent()

            // Android Version is 11 or greater
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){

                val pkg = "com.android.phone"
                val cls = "com.android.phone.settings.RadioInfo"

                /*
                Checking if Activity is Launchable or not
                isActivityLaunchable(context , packageName , className)
                */
                if(isActivityLaunchable(this,pkg ,cls )){

                    // Making  Main.xml Activity Disable
                    mainView.visibility = View.GONE

                    // Starting the Intent
                    intent.component = ComponentName(pkg ,cls )
                    startActivity(intent)

                    // Closing the App
                    finish()
                } else {
                    // Display Activity Main.xml
                    mainView.visibility = View.VISIBLE
                }

            } else {
                // Android Version below 11
                val pkg = "com.android.settings"
                val cls = "com.android.settings.RadioInfo"

                /*
                Checking if Activity is Launchable or not
                isActivityLaunchable(context , packageName , className)
                */
                if(isActivityLaunchable(this,pkg ,cls )){

                    // Making  Main.xml Activity Disable
                    mainView.visibility = View.GONE

                    // Starting the Intent
                    intent.component = ComponentName(pkg ,cls )
                    startActivity(intent)

                    // Closing the App
                    finish()
                } else {
                    // Display Activity Main.xml
                    mainView.visibility = View.VISIBLE
                }
            }
        } catch (e: ActivityNotFoundException){
            Log.e("RadioLauncher", "Failed to launch RadioInfo", e)
            e.printStackTrace()

        } catch (e: SecurityException){
            Log.e("RadioLauncher", "Failed to launch RadioInfo", e)
            e.printStackTrace()
        }



    }

    fun isActivityLaunchable(context: Context , packageName: String , className: String): Boolean {
        val packageManager = context.packageManager

        // 1. Check if the Phone app is actually installed
        val isInstalled = try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            false
        }

        if (!isInstalled) return false


        // 2. Query for the specific activity component
        val intent = intent.apply {
            component = ComponentName(packageName , className)
        }
        val resolveInfo = packageManager.resolveActivity(intent , PackageManager.MATCH_DEFAULT_ONLY) ?: return false
        return resolveInfo.activityInfo.exported
    }


}