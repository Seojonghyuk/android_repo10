package com.example.intentsevensolutionpro

import android.os.Parcel
import android.os.Parcelable

data class LoginDataParcel(val id:String?, val pwd:String?) : Parcelable{
    //소포열기
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )
    //소포담기
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(pwd)
    }
    //파일descriptor이면 , 그이외것은 0
    override fun describeContents(): Int {
        return 0
    }

    //소포만들기
    companion object CREATOR : Parcelable.Creator<LoginDataParcel> {
        //객체용소포만들기
        override fun createFromParcel(parcel: Parcel): LoginDataParcel {
            return LoginDataParcel(parcel)
        }
        //배열용소포만들기
        override fun newArray(size: Int): Array<LoginDataParcel?> {
            return arrayOfNulls(size)
        }
    }

}
