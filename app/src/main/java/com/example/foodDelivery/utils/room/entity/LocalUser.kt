package com.example.foodDelivery.utils.room.entity

import android.provider.ContactsContract
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocalUser(
    @PrimaryKey var userId: Int = 0,
    @ColumnInfo(name = "name") var name:String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "role") var role:String?
)


