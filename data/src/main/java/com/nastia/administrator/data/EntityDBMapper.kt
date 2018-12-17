package com.nastia.administrator.data

import entity.OwlResponse

fun OwlResponse.transformToDB() : OwlDb {
    return OwlDb(id = id, name = name, age = age, pic = pic)
}