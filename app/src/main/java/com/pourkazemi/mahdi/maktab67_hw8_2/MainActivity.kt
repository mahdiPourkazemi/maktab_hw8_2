package com.pourkazemi.mahdi.maktab67_hw8_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import com.pourkazemi.mahdi.maktab67_hw8_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MyViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.initBoardList(
            listOf(
                binding.btnA1,
                binding.btnA2,
                binding.btnA3,
                binding.btnB1,
                binding.btnB2,
                binding.btnB3,
                binding.btnC1,
                binding.btnC2,
                binding.btnC3
            )
        )
        viewModel.cross.observe(this) {
            it!!.let {
                it.map {

                }
            }
        }
        viewModel.cross.observe(this) {
            it!!.let {
                it.map {

                }
            }
        }
    }
}
