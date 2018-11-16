package com.nastia.administrator.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "owl")
data class OwlDb(

    @PrimaryKey
    val id: String,

    val name: String,
    val age: Int,
    val pic: String

)
