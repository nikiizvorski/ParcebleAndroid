package com.androidchill.niki.parcebleandroid.models;

import android.os.Parcel;
import android.os.Parcelable;


public class UserInfo implements Parcelable {

    //values
    private String name;
    private String surname;
    private int idx;
    private Address address;

    //constructor
    public UserInfo() {}

    // Get and set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(surname);
        dest.writeInt(idx);

        // Add inner class
        dest.writeParcelable(address, flags);
    }


    // Creator
    public static final Parcelable.Creator<UserInfo> CREATOR
            = new Parcelable.Creator<UserInfo>() {
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    // "De-parcel object
    public UserInfo(Parcel in) {
        name = in.readString();
        surname = in.readString();
        idx = in.readInt();

       address = (Address) in.readParcelable(Address.class.getClassLoader());
    }

    @Override
    public String toString() {
        return "Name:" + name + " Surname: " + surname + " IDX: " + idx + " Street: " + address.getCity();
        //return "Name:" + name + " Surname: " + surname + " IDX: " + idx;
    }

    // Inner class
    public static class Address implements Parcelable {
        private String street;
        private String city;
        private int number;

        public Address() {}

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public int getNumber() {
            return number;
        }


        public void setNumber(int number) {
            this.number = number;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(street);
            dest.writeString(city);
            dest.writeInt(number);
        }

        // Creator
        public static final Parcelable.Creator<Address> CREATOR
                = new Parcelable.Creator<Address>() {
            public Address createFromParcel(Parcel in) {
                return new Address(in);
            }

            public Address[] newArray(int size) {
                return new Address[size];
            }
        };

        // "De-parcel object
        private Address(Parcel in) {
            street = in.readString();
            city = in.readString();
            number = in.readInt();
        }
    }
}
