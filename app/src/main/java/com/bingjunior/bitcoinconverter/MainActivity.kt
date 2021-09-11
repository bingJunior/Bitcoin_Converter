package com.bingjunior.bitcoinconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bingjunior.bitcoinconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.covertButton.setOnClickListener { convertToBitcoin() }
    }

    private fun convertToBitcoin() {
        val nairaAmount = binding.nairaEditText.text.toString()
        val naira = nairaAmount.toDoubleOrNull()
        if (naira == null) {
            binding.bitcoinTextView.text = ""
            return
        }

        val bitcoin = 0.000000049
        var result = (naira * bitcoin)

        // round-up switch
        if (binding.roundUpSwitch.isChecked) {
            result = kotlin.math.ceil(result)
        }

        // rounds to 2 decimal places
        val formattedResult = "%.2f".format(result).toDouble()
        binding.bitcoinTextView.text = formattedResult.toString()
    }
}

