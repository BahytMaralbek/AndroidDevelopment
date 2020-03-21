package com.example.lab5;

import android.os.Parcel;
import android.os.Parcelable;

public class Email implements Parcelable {

    private int id;
    private String title;
    private String description;
    private String Info;
    static Email selected;

    public Email(int id , String title , String description , String Info){
        this.id = id;
        this.title = title;
        this.description = description;
        this.Info = Info;
    }

    protected Email(Parcel source){
        id = source.readInt();
        title = source.readString();
        description = source.readString();
        Info = source.readString();
    }

    public static final Creator<Email> CREATOR = new Creator<Email>() {
        @Override
        public Email createFromParcel(Parcel source) {
            return new Email(source);
        }

        @Override
        public Email[] newArray(int size) {
            return new Email[size];
        }
    };



    //    getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(Info);
    }
}
