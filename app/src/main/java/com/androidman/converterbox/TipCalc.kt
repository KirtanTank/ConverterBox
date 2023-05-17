package com.androidman.converterbox

import android.animation.ArgbEvaluator
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.androidman.converterbox.MainActivity2.Companion.redirectActivity
import kotlinx.android.synthetic.main.activity_tip_calc.*

private const val TAG = "TipCalc"
private const val INITIAL_TIP_PERCENT = 15

class TipCalc : AppCompatActivity() {

    var imagebutton: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip_calc)

        val animDrawable = tipcalc_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(10)
        animDrawable.setExitFadeDuration(5000)
        animDrawable.start()

        val anim = AnimationUtils.loadAnimation(this,R.anim.stripe_anim)
        stripes35.startAnimation(anim)


        seekBarTip.progress = INITIAL_TIP_PERCENT
        tvTipPercent.text = "$INITIAL_TIP_PERCENT%"
        updateTipDescription(INITIAL_TIP_PERCENT)
        seekBarTip.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i(TAG, "onProgressChanged $progress")
                tvTipPercent.text = "$progress%"
                computeTipAndTotal()
                updateTipDescription(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        etBase.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG, "afterTextChanged $s")
                computeTipAndTotal()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        imagebutton = findViewById(R.id.backbutton)

        imagebutton!!.setOnClickListener(View.OnClickListener {

            redirectActivity(this, MainActivity2::class.java)
            finish()

        })

    }

    private fun updateTipDescription(tipPercent: Int) {
        val tipDescription : String
        when (tipPercent)  {
            in 0..19 -> tipDescription = "Acceptable"
            in 20..39 -> tipDescription = "Good"
            in 40..59 -> tipDescription = "Better"
            in 60..79 -> tipDescription = "Great"
            else -> tipDescription = "Amazing"
        }
        tvTipDescription.text = tipDescription
        val color = ArgbEvaluator().evaluate(
            tipPercent.toFloat() / seekBarTip.max,
            ContextCompat.getColor(this, R.color.colorBadTip),
            ContextCompat.getColor(this, R.color.colorGoodTip)
        ) as Int
        tvTipDescription.setTextColor(color)

    }

    private fun computeTipAndTotal() {
        if (etBase.text.isEmpty()) {
            tvTipAmount.text = ""
            tvTotalAmount.text = ""
            return
        }
        val baseAmount = etBase.text.toString().toDouble()
        val tipAmount = baseAmount * seekBarTip.progress / 100
        tvTipAmount.text = "%.2f".format(tipAmount)
        tvTotalAmount.text = "%.2f".format(baseAmount + tipAmount)
    }

}
