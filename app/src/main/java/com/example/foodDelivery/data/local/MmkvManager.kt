package com.example.foodDelivery.data.local

import android.content.Context
import com.tencent.mmkv.MMKV

class MmkvManager(context: Context) {

    private val rootDir: String = MMKV.initialize(context)
    private  val kv = MMKV.defaultMMKV()

    fun saveString(key: String, value:String) {
        kv.encode(key, value)
    }

    fun getString(key:String): String? {
        return kv.decodeString(key)
    }

}