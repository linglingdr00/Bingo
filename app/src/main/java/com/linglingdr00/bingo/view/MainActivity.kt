package com.linglingdr00.bingo.view

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.linglingdr00.bingo.R
import com.linglingdr00.bingo.databinding.ActivityMainBinding
import com.linglingdr00.bingo.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    // MainViewModel
    private val mainViewModel: MainViewModel by viewModels()
    // R.layout.activity_main 的 binding
    lateinit var binding: ActivityMainBinding

    // button flag
    private var button1Flag: Boolean = false
    private var button2Flag: Boolean = false
    private var button3Flag: Boolean = false
    private var button4Flag: Boolean = false
    private var button5Flag: Boolean = false
    private var button6Flag: Boolean = false
    private var button7Flag: Boolean = false
    private var button8Flag: Boolean = false
    private var button9Flag: Boolean = false

    private val nonClickedButtonColor = Color.WHITE
    private val clickedButtonColor = Color.RED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        // 設定 layout 的 view model 為 mainViewModel
        binding.viewModel = mainViewModel

        // 開始遊戲
        mainViewModel.startGame()

        // 觀察是否 bingo
        mainViewModel.bingo.observe(this, Observer { bingo ->
            if (bingo == true) {
                //Toast.makeText(this, "Bingo!", Toast.LENGTH_SHORT).show()
                bingoAnimation()
                // 顯示 restart button
                binding.buttonRestart.visibility = View.VISIBLE
                setButtonDisable()
            }
        })
    }

    // bingo 動畫
    private fun bingoAnimation() {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.startOffset = 20
        animation.repeatMode = Animation.REVERSE
        animation.repeatCount = 2

        // 設定顯示 bingo text
        binding.bingoTextView.visibility = View.VISIBLE
        // 開始動畫
        binding.bingoTextView.startAnimation(animation)
    }

    // 設定 button 狀態 Enable
    private fun setButtonEnable() {
        binding.button1.isEnabled = true
        binding.button2.isEnabled = true
        binding.button3.isEnabled = true
        binding.button4.isEnabled = true
        binding.button5.isEnabled = true
        binding.button6.isEnabled = true
        binding.button7.isEnabled = true
        binding.button8.isEnabled = true
        binding.button9.isEnabled = true
    }

    // 設定 button 狀態 Disable
    private fun setButtonDisable() {
        binding.button1.isEnabled = false
        binding.button2.isEnabled = false
        binding.button3.isEnabled = false
        binding.button4.isEnabled = false
        binding.button5.isEnabled = false
        binding.button6.isEnabled = false
        binding.button7.isEnabled = false
        binding.button8.isEnabled = false
        binding.button9.isEnabled = false
    }

    // 點擊 restart button 時
    fun restartGame(view: View) {
        // 重新開始遊戲
        restartGame()
    }

    private fun restartGame() {
        // 設定 restart button 不可見
        binding.buttonRestart.visibility = View.GONE
        // 設定 bingo text 不可見
        binding.bingoTextView.visibility = View.GONE

        // 設定 button background color 和 flag 為初始值
        binding.button1.setBackgroundColor(nonClickedButtonColor)
        button1Flag = false

        binding.button2.setBackgroundColor(nonClickedButtonColor)
        button2Flag = false

        binding.button3.setBackgroundColor(nonClickedButtonColor)
        button3Flag = false

        binding.button4.setBackgroundColor(nonClickedButtonColor)
        button4Flag = false

        binding.button5.setBackgroundColor(nonClickedButtonColor)
        button5Flag = false

        binding.button6.setBackgroundColor(nonClickedButtonColor)
        button6Flag = false

        binding.button7.setBackgroundColor(nonClickedButtonColor)
        button7Flag = false

        binding.button8.setBackgroundColor(nonClickedButtonColor)
        button8Flag = false

        binding.button9.setBackgroundColor(nonClickedButtonColor)
        button9Flag = false

        // 開始遊戲
        mainViewModel.startGame()
        setButtonEnable()
    }

    // 改變 button 顏色
    fun changeButtonColor(view: View) {
        when (view.id) {
            R.id.button_1 -> {
                if (!button1Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button1Flag = true
                    mainViewModel.addPositionToList(1)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button1Flag = false
                    mainViewModel.removePositionToList(1)
                }
            }
            R.id.button_2 -> {
                if (!button2Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button2Flag = true
                    mainViewModel.addPositionToList(2)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button2Flag = false
                    mainViewModel.removePositionToList(2)
                }
            }
            R.id.button_3 -> {
                if (!button3Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button3Flag = true
                    mainViewModel.addPositionToList(3)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button3Flag = false
                    mainViewModel.removePositionToList(3)
                }
            }
            R.id.button_4 -> {
                if (!button4Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button4Flag = true
                    mainViewModel.addPositionToList(4)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button4Flag = false
                    mainViewModel.removePositionToList(4)
                }
            }
            R.id.button_5 -> {
                if (!button5Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button5Flag = true
                    mainViewModel.addPositionToList(5)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button5Flag = false
                    mainViewModel.removePositionToList(5)
                }
            }
            R.id.button_6 -> {
                if (!button6Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button6Flag = true
                    mainViewModel.addPositionToList(6)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button6Flag = false
                    mainViewModel.removePositionToList(6)
                }
            }
            R.id.button_7 -> {
                if (!button7Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button7Flag = true
                    mainViewModel.addPositionToList(7)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button7Flag = false
                    mainViewModel.removePositionToList(7)
                }
            }
            R.id.button_8 -> {
                if (!button8Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button8Flag = true
                    mainViewModel.addPositionToList(8)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button8Flag = false
                    mainViewModel.removePositionToList(8)
                }
            }
            else -> {
                if (!button9Flag) {
                    view.setBackgroundColor(clickedButtonColor)
                    button9Flag = true
                    mainViewModel.addPositionToList(9)
                } else {
                    view.setBackgroundColor(nonClickedButtonColor)
                    button9Flag = false
                    mainViewModel.removePositionToList(9)
                }
            }
        }
    }
}