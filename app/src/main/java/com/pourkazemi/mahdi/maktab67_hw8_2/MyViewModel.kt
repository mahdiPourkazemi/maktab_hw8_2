package com.pourkazemi.mahdi.maktab67_hw8_2

import android.util.Log
import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    private val _noughts = MutableLiveData<MutableSet<Button>>()
    val noughts: LiveData<MutableSet<Button>> get() =  _noughts
    private val _cross = MutableLiveData<MutableList<Button>>()
    val cross: LiveData<MutableList<Button>> get() = _cross
    private val boardList = mutableListOf<Button>()
    fun initBoardList(mList:List<Button>){
        _cross.value!!.addAll(mList)
        _noughts.value?.addAll(mList)
    }
    fun addNoughts(btn:Button){
       _noughts.value?.add(btn)
    }
    fun addCross(btn:Button){
        //_cross.value?.add(btn)
        Log.d("button", _cross.value?.get(0).toString())
    }
    fun checkIsNotHere(btn:Button):Boolean{
        /*if (noughts.value?.isNotEmpty() == true ||
            cross.value?.isNotEmpty() == true){
            return (!noughts.value?.contains(btn)!! && !cross.value?.contains(btn)!!)
        }else return true*/
        return true
    }
}