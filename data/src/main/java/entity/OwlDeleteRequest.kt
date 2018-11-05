package entity

import com.google.gson.annotations.SerializedName

class OwlDeleteRequest (
        @SerializedName("objectId")
        val id:String) : DataEntity