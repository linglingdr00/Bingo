package com.linglingdr00.bingo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val TAG = "MainViewModel"

    // 隨機數字的 list
    private val _numberList = MutableLiveData<List<String>>(listOf())
    val numberList: LiveData<List<String>> = _numberList

    // 確認是否 bingo
    private val _bingo = MutableLiveData<Boolean>(false)
    val bingo: LiveData<Boolean> = _bingo

    // 儲存 button 位置和狀態(是否已被點擊)
    private var numberMap: MutableMap<Int,Boolean> = mutableMapOf()

    // 初始化設定
    fun startGame() {
        for (num in 1..9) {
            numberMap[num] = false
        }
        Log.d(TAG, "numMap: $numberMap")
        // 產生隨機數字
        generateRandomNum()
    }

    // 產生隨機數字
    private fun generateRandomNum() {
        val numberRange = 0..25
        // 將 0..25 儲存在 list 中
        val tempNumberList = numberRange.toList()
        // 把 list 中的數字打亂
        val newNumberList = tempNumberList.shuffled()
        Log.d(TAG, "newNumberList: ${newNumberList}")
        //Log.d(TAG, "0: ${newNumList[0]}")

        // 把 int 轉成 string
        val tempNumberStringList = arrayListOf<String>()
        for (number in newNumberList) {
            tempNumberStringList.add(number.toString())
        }
        Log.d(TAG, "tempNumberStringList: $tempNumberStringList")

        // 將 livedata _numberList 的 value 設為 tempNumberStringList
        _numberList.value = tempNumberStringList
        Log.d(TAG, "_numberList: ${_numberList.value}")
    }

    // 處理被點擊的 button
    fun addPositionToList(position: Int) {
        // 將點擊的 button 的位置設為 true
        numberMap[position] = true
        Log.d(TAG, "numberMap: $numberMap")
        checkBingo()
    }

    // 處理被取消點擊的 button
    fun removePositionToList(position: Int) {
        // 將取消點擊的 button 的位置設為 false
        numberMap[position] = false
        Log.d(TAG, "numberMap: $numberMap")
    }

    // 確認是否 bingo
    private fun checkBingo() {
        // 計算 bingo 連線
        var bingoLine = 0

        if (numberMap[1]==true && numberMap[2]==true && numberMap[3]==true) {
            bingoLine += 1
        }
        if (numberMap[4]==true && numberMap[5]==true && numberMap[6]==true) {
            bingoLine += 1
        }
        if (numberMap[7]==true && numberMap[8]==true && numberMap[9]==true) {
            bingoLine += 1
        }
        if (numberMap[1]==true && numberMap[4]==true && numberMap[7]==true) {
            bingoLine += 1
        }
        if (numberMap[2]==true && numberMap[5]==true && numberMap[8]==true) {
            bingoLine += 1
        }
        if (numberMap[3]==true && numberMap[6]==true && numberMap[9]==true) {
            bingoLine += 1
        }
        if (numberMap[1]==true && numberMap[5]==true && numberMap[9]==true) {
            bingoLine += 1
        }
        if (numberMap[3]==true && numberMap[5]==true && numberMap[7]==true) {
            bingoLine += 1
        }

        // 達成兩條線，bingo
        if (bingoLine >= 2) {
            _bingo.value = true
        }
    }
}