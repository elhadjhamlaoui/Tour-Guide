package com.app_republic.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Attraction implements Parcelable {
    private String name;
    private int picture;
    private String description;
    private Location location;

    Attraction(String name, int picture, String description, Location location) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.location = location;
    }

    private Attraction(Parcel in) {
        name = in.readString();
        picture = in.readInt();
        description = in.readString();
    }

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel in) {
            return new Attraction(in);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }

    public Location getLocation() {
        return location;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(picture);
        parcel.writeString(description);
    }

}
