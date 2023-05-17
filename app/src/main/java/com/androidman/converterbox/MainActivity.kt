package com.androidman.converterbox

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_length.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    ///Initialize variable
    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val animDrawable = drawer_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()


        ///Assign variable
        drawerLayout = findViewById(R.id.drawer_layout)
    }

    fun ClickMenu(view: View?) {
        ///Open Drawer
        openDrawer(drawerLayout)
    }

    fun ClickBack(view: View?){
        closeDrawer(drawerLayout)
        // val clickmenu2: MediaPlayer = MediaPlayer.create(this,R.raw.closedrawersound)
        //clickmenu2.start()
    }

    fun ClickLogo(view: View?) {
        closeDrawer(drawerLayout)
        // val clickmenu2: MediaPlayer = MediaPlayer.create(this,R.raw.closedrawersound)
        //clickmenu2.start()
    }

    fun ClickBasic(view: View?){
        redirectActivity(this, MainActivity::class.java)
        //val clickactivity: MediaPlayer = MediaPlayer.create(this,R.raw.selectcategory)
        //clickactivity.start()
        finish()
    }
    fun ClickLiving(view: View?){
        redirectActivity(this, MainActivity2::class.java)
        //val clickactivity: MediaPlayer = MediaPlayer.create(this,R.raw.selectcategory)
        //clickactivity.start()
        finish()
    }
    fun ClickScience(view: View?){
        redirectActivity(this, MainActivity3::class.java)
        //  val clickactivity: MediaPlayer = MediaPlayer.create(this,R.raw.selectcategory)
        // clickactivity.start()
        finish()
    }

    fun ClickOther(view: View?){
        redirectActivity(this, MainActivity4::class.java)
        // val clickactivity: MediaPlayer = MediaPlayer.create(this,R.raw.selectcategory)
        // clickactivity.start()
        finish()
    }

    fun sharelink(view: View?){
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Share MeetUP")
            val shareMessage =
                ("Hey!! I am using this application, its great. You should give it a try." + "                                                                            " +
                        "https://play.google.com/store/apps/details?id="+BuildConfig.APPLICATION_ID)


                    .trimIndent()
            intent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(intent, "Share via"))
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, "Error occured", Toast.LENGTH_SHORT).show()
        }
    }

    fun ClickLength(view: View?) {
        ///Recreate activity
        redirectActivity(this, Length::class.java)

    }

    fun ClickArea(view: View?) {
        ///Redirect activity to TipCalc
        redirectActivity(this, Area::class.java)

    }

    fun ClickWeight(view: View?) {
        ///Redirect activity to AgeCalc
        redirectActivity(this, Weight::class.java)
    }

    fun ClickVolume(view: View?) {
        ///Redirect activity to UnitCalc
        redirectActivity(this, Volume::class.java)
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
