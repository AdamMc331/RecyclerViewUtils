package com.adammcneilly.recyclerviewutils.sample

import android.os.Parcel
import android.os.Parcelable

/**
 * Represents a bank account.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
data class Account(var name: String? = "", var balance: Double = 0.0) : Parcelable {

    constructor(parcel: Parcel): this(parcel.readString(), parcel.readDouble())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeDouble(balance)
    }

    companion object {
        @JvmField
        var CREATOR: Parcelable.Creator<Account> = object : Parcelable.Creator<Account> {
            override fun createFromParcel(parcel: Parcel): Account {
                return Account(parcel)
            }

            override fun newArray(i: Int): Array<Account?> {
                return arrayOfNulls(i)
            }
        }
    }
}
