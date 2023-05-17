package com.androidman.converterbox

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity4 : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val animDrawable = drawer_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        drawerLayout = findViewById(R.id.drawer_layout)
    }

    fun ClickMenu(view: View?) {
        ///Open Drawer
        openDrawer(drawerLayout)
    }

    fun ClickBack(view: View?){
        closeDrawer(drawerLayout)
    }

    fun ClickLogo(view: View?) {
        closeDrawer(drawerLayout)
    }

    fun ClickBasic(view: View?){
        redirectActivity(this, MainActivity::class.java)
        finish()
    }

    fun ClickLiving(view: View?){
        redirectActivity(this, MainActivity2::class.java)
        finish()
    }

    fun ClickScience(view: View?){
        redirectActivity(this, MainActivity3::class.java)
        finish()
    }

    fun ClickOther(view: View?){
        redirectActivity(this, MainActivity4::class.java)
        finish()
    }


    fun sharelink(view: View?){
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Share Unit Converter")
            val shareMessage =
                ("Hey!! I am using this application, its great. You should give it a try." + "                                                                            " +
                        "https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID)
                
                
                .trimIndent()
            intent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(intent, "Share via"))
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity4, "Error occured", Toast.LENGTH_SHORT).show()
        }
    }

    fun ClickAngle(view: View?){
        redirectActivity(this,Angle::class.java)
    }

    fun ClickData(view: View?){
        redirectActivity(this,Data::class.java)
    }

    fun ClickFuel(view: View?){
        redirectActivity(this,Fuel::class.java)
    }

    fun ClickCooking(view: View?){
        redirectActivity(this,Cooking::class.java)
    }

    fun ClickIlluminance(view: View?){
        redirectActivity(this,Illuminance::class.java)
    }

    fun ClickRadiation(view: View?){
        redirectActivity(this,Radiation::class.java)
    }

    fun ClickPrefix(view: View?){
        redirectActivity(this,Prefix::class.java)
    }

    fun ClickBinary(view: View?){
        redirectActivity(this,Binary::class.java)
    }

    fun ClickBloodSugar(view: View?){
        redirectActivity(this,BloodSugar::class.java)
    }

    fun ClickAWG(view: View?){
        redirectActivity(this,AWG::class.java)
    }

    fun ClickHardness(view: View?){
        redirectActivity(this,Hardness::class.java)
    }

    fun ClickNumber(view: View?){
        redirectActivity(this,Number::class.java)
    }

    override fun onPause() {
        super.onPause()
        ///Close drawer
        closeDrawer(drawerLayout)
    }
    companion object {
        @JvmStatic
        fun openDrawer(drawerLayout: DrawerLayout?) {

            ///open drawer Layout
            drawerLayout!!.openDrawer(GravityCompat.START)
        }

        @JvmStatic
        fun closeDrawer(drawerLayout: DrawerLayout?) {
            ///close drawer Layout
            ///Check Condition
            if (drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
                ///When drawer is Open
                ///Close drawer
                drawerLayout.closeDrawer(GravityCompat.START)
            }
        }

        @JvmStatic
        fun redirectActivity(activity: Activity, aClass: Class<*>?) {
            ///Initialize Intent
            val intent = Intent(activity, aClass)
            ///set flag
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            ///start Activity
            activity.startActivity(intent)
        }
    }
}