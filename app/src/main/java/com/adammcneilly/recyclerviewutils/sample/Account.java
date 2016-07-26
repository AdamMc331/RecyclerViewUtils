package com.adammcneilly.recyclerviewutils.sample;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents a bank account.
 *
 * Created by adam.mcneilly on 7/26/16.
 */
public class Account implements Parcelable{
    private String name;
    private double balance;

    public static Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel parcel) {
            return new Account(parcel);
        }

        @Override
        public Account[] newArray(int i) {
            return new Account[i];
        }
    };

    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public Account(Parcel parcel) {
        this.name = parcel.readString();
        this.balance = parcel.readDouble();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(balance);
    }
}
