package entity

import com.google.gson.annotations.SerializedName

data class OwlRequest (
        @SerializedName("objectId")
        val id:String,

        @SerializedName("name")
        val name:String,

        @SerializedName("age")
        val age:Int) : DataEntity