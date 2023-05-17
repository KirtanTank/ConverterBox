package com.androidman.converterbox

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.androidman.converterbox.MainActivity3.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_data.*
import java.util.*


class Data : AppCompatActivity() {
    var imagebutton: ImageView? = null
    private var drawerLayout: DrawerLayout? = null
    var input_number: EditText? = null
    var spinner1: Spinner? = null
    var spinner2: Spinner? = null
    var btn: Button? = null
    var show_result: TextView? = null
    var list2: MutableList<String>? = null
    var list1: MutableList<String>? = null
    var units = arrayOf("bit", "bytes", "Kilobytes", "Megabytes", "Gigabytes", "Terabytes", "Petabytes", "Kibibytes",
        "Mebibytes", "Gibibytes", "Tebibytes", "Pebibytes", "Kbit/s", "Mbit/s", "Gbit/s", "packet", "block")

    var scale = 0
    var bit = 1.0
    var bytes = 0.125
    var kilobytes = 0.000125
    var megabytes = 0.000000125
    var gigabytes = 0.000000000125
    var terabytes = 0.000000000000125
    var petabytes = 0.000000000000000125
    var kibibytes = 0.000122
    var mebibytes = 0.00000011921
    var gibibytes = 0.00000000011642
    var tebibytes = 0.00000000000011369
    var pebibytes = 0.00000000000000011102
    var kbits = 0.001
    var mbits = 0.000001
    var gbits = 0.000000001
    var packet = 0.000977
    var block = 0.000244
    var var1 = 0.0
    var var2 = 0.0
    var output = 0.0
    var no = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val animDrawable = data_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes14.startAnimation(anim)

        val clickbutton: MediaPlayer = MediaPlayer.create(this, R.raw.clickaudio)

        imagebutton = findViewById(R.id.backbutton)

        drawerLayout = findViewById(R.id.drawer_layout)
        input_number = findViewById<View>(R.id.input) as EditText
        spinner1 = findViewById<View>(R.id.spinner1) as Spinner
        spinner2 = findViewById<View>(R.id.spinner2) as Spinner
        btn = findViewById<View>(R.id.button) as Button
        show_result = findViewById<View>(R.id.show) as TextView
        list1 = ArrayList()
        list2 = ArrayList()
        (list1 as ArrayList<String>).add("Bits")
        (list1 as ArrayList<String>).add("Bytes")
        (list1 as ArrayList<String>).add("Kilobytes")
        (list1 as ArrayList<String>).add("Megabytes")
        (list1 as ArrayList<String>).add("Gigabytes")
        (list1 as ArrayList<String>).add("Terabytes")
        (list1 as ArrayList<String>).add("Petabytes")
        (list1 as ArrayList<String>).add("KibiBytes")
        (list1 as ArrayList<String>).add("MebiBytes")
        (list1 as ArrayList<String>).add("GibiBytes")
        (list1 as ArrayList<String>).add("TebiBytes")
        (list1 as ArrayList<String>).add("PebiBytes")
        (list1 as ArrayList<String>).add("Kbit/s")
        (list1 as ArrayList<String>).add("Mbit/s")
        (list1 as ArrayList<String>).add("Gbit/s")
        (list1 as ArrayList<String>).add("Packet")
        (list1 as ArrayList<String>).add("Block")
        (list2 as ArrayList<String>).add("Bits")
        (list2 as ArrayList<String>).add("Bytes")
        (list2 as ArrayList<String>).add("Kilobytes")
        (list2 as ArrayList<String>).add("Megabytes")
        (list2 as ArrayList<String>).add("Gigabytes")
        (list2 as ArrayList<String>).add("Terabytes")
        (list2 as ArrayList<String>).add("Petabytes")
        (list2 as ArrayList<String>).add("KibiBytes")
        (list2 as ArrayList<String>).add("MebiBytes")
        (list2 as ArrayList<String>).add("GibiBytes")
        (list2 as ArrayList<String>).add("TebiBytes")
        (list2 as ArrayList<String>).add("PebiBytes")
        (list2 as ArrayList<String>).add("Kbit/s")
        (list2 as ArrayList<String>).add("Mbit/s")
        (list2 as ArrayList<String>).add("Gbit/s")
        (list2 as ArrayList<String>).add("Packet")
        (list2 as ArrayList<String>).add("Block")
        val adapter1 = ArrayAdapter(
            this, android.R.layout.simple_dropdown_item_1line,
            list1 as ArrayList<String>
        )
        val adapter2 = ArrayAdapter(
            this, android.R.layout.simple_dropdown_item_1line,
            list2 as ArrayList<String>
        )
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner1!!.adapter = adapter1
        spinner2!!.adapter = adapter2
        spinner1!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                spinner1!!.setSelection(position)
                if (position == 0) {
                    var1 = bit
                }
                if (position == 1) {
                    var1 = bytes
                }
                if (position == 2) {
                    var1 = kilobytes
                }
                if (position == 3) {
                    var1 = megabytes
                }
                if (position == 4) {
                    var1 = gigabytes
                }
                if (position == 5) {
                    var1 = terabytes
                }
                if (position == 6) {
                    var1 = petabytes
                }
                if (position == 7) {
                    var1 = kibibytes
                }
                if (position == 8) {
                    var1 = mebibytes
                }
                if (position == 9) {
                    var1 = gibibytes
                }
                if (position == 10) {
                    var1 = tebibytes
                }
                if (position == 11) {
                    var1 = pebibytes
                }
                if (position == 12) {
                    var1 = kbits
                }
                if (position == 13) {
                    var1 = mbits
                }
                if (position == 14) {
                    var1 = gbits
                }
                if (position == 15) {
                    var1 = packet
                }
                if (position == 16) {
                    var1 = block
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spinner2!!.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                spinner2!!.setSelection(position)
                if (position == 0) {
                    var2 = bit
                }
                if (position == 1) {
                    var2 = bytes
                }
                if (position == 2) {
                    var2 = kilobytes
                }
                if (position == 3) {
                    var2 = megabytes
                }
                if (position == 4) {
                    var2 = gigabytes
                }
                if (position == 5) {
                    var2 = terabytes
                }
                if (position == 6) {
                    var2 = petabytes
                }
                if (position == 7) {
                    var2 = kibibytes
                }
                if (position == 8) {
                    var2 = mebibytes
                }
                if (position == 9) {
                    var2 = gibibytes
                }
                if (position == 10) {
                    var2 = tebibytes
                }
                if (position == 11) {
                    var2 = pebibytes
                }
                if (position == 12) {
                    var2 = kbits
                }
                if (position == 13) {
                    var2 = mbits
                }
                if (position == 14) {
                    var2 = gbits
                }
                if (position == 15) {
                    var2 = packet
                }
                if (position == 16) {
                    var2 = block
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        btn!!.setOnClickListener(View.OnClickListener {
            clickbutton.start()
            if (input_number!!.length() == 0) {
                Toast.makeText(this@Data, "Enter a value!", Toast.LENGTH_SHORT).show()
            } else {
                val value = input_number!!.text.toString()
                val no = value.toDouble()
                output = bit / var1
                output = output * var2
                output = output * no
                if (var2 == bit) {
                    scale = 0
                }
                if (var2 == bytes) {
                    scale = 1
                }
                if (var2 == kilobytes) {
                    scale = 2
                }
                if (var2 == megabytes) {
                    scale = 3
                }
                if (var2 == gigabytes) {
                    scale = 4
                }
                if (var2 == terabytes) {
                    scale = 5
                }
                if (var2 == petabytes) {
                    scale = 6
                }
                if (var2 == kibibytes) {
                    scale = 7
                }
                if (var2 == mebibytes) {
                    scale = 8
                }
                if (var2 == gibibytes) {
                    scale = 9
                }
                if (var2 == tebibytes) {
                    scale = 10
                }
                if (var2 == pebibytes) {
                    scale = 11
                }
                if (var2 == kbits) {
                    scale = 12
                }
                if (var2 == mbits) {
                    scale = 13
                }
                if (var2 == gbits) {
                    scale = 14
                }
                if (var2 == packet) {
                    scale = 15
                }
                if (var2 == block) {
                    scale = 16
                }
                show_result!!.text = output.toString() + " " + units[scale]
            }
        })

        imagebutton!!.setOnClickListener(View.OnClickListener {
            redirectActivity(this, MainActivity4::class.java)
            finish()

        })

    }
}
