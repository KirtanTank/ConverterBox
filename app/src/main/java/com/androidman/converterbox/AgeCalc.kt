package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.app.TimePickerDialog as TimePickerDialog
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.androidman.converterbox.MainActivity2.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_age_calc.*
import java.text.SimpleDateFormat
import java.util.*
import android.app.DatePickerDialog as DatePickerDialog


class AgeCalc : AppCompatActivity() {
    var editTextPersonname: EditText? = null
    var button: Button? = null
    var imagebutton: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_calc)


        val animDrawable = agecalc_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes2.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)


        editTextPersonname = findViewById<View>(R.id.editTextTextPersonName) as EditText
        button = findViewById<View>(R.id.findatebutton) as Button

        button!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (editTextPersonname!!.length() == 0) {
                Toast.makeText(this@AgeCalc, "Enter Date and Time!", Toast.LENGTH_SHORT).show()
            } else {

                val today = Date()
                val dobs = editTextTextPersonName.text.toString()
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val dob = sdf.parse(dobs)
                val year = (today.time - dob.time) / 31536000000
                val month = (today.time - dob.time) % 31536000000 / 2628000000
                val days = (today.time - dob.time) % 31536000000 % 2628000000 / 86400000
                val hours = (today.time - dob.time) % 31536000000 % 2628000000 % 86400000 / 3600000
                val minutes = (today.time - dob.time) % 31536000000 % 2628000000 % 86400000 % 3600000 / 60000
                val seconds = (today.time - dob.time) % 31536000000 % 2628000000 % 86400000 % 3600000 % 60000 / 1000
                textview.visibility = View.VISIBLE
                textview.setText("Years = $year\nMonths = $month\nDays = $days\nHours = $hours\nMinutes = $minutes\nSeconds = $seconds")
            }
        })


       imagebutton!!.setOnClickListener(View.OnClickListener {

           redirectActivity(this, MainActivity2::class.java)
           finish()

       })

    }

    fun openDateTimePicker(view: View?) {

        val c = Calendar.getInstance()

        DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->

                    var dt = "$dayOfMonth/${month + 1}/$year"

                    TimePickerDialog(this,
                            TimePickerDialog.OnTimeSetListener { timePicker, hourOfDay, minute ->

                                dt += " $hourOfDay:$minute"

                                editTextTextPersonName.setText(dt)

                            },
                            c.get(Calendar.HOUR),
                            c.get(Calendar.MINUTE),
                            false).show()

                },
                c.get(Calendar.YEAR),
                c.get(Calendar.MONTH),
                c.get(Calendar.DAY_OF_MONTH)).show()
    }
    fun DatePickerDialog(
            ageCalc: AgeCalc,
            onDateSetListener: DatePickerDialog.OnDateSetListener,
            get: Int,
            get1: Int,
    ) {
    }

    fun TimePickerDialog(
            ageCalc: AgeCalc,
            onTimeSetListener: TimePickerDialog.OnTimeSetListener,
            get: Int,
            get1: Int,
    ) {
        TODO("Not yet implemented")
    }

    fun findAge(view: View) {
        val today = Date()
        val dobs = editTextTextPersonName.text.toString()
        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
        val dob = sdf.parse(dobs)

    }

}