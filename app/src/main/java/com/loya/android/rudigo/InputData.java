package com.loya.android.rudigo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by user on 7/23/2017.
 */
public class InputData  implements Parcelable{

    private ArrayList<String> idea = new ArrayList<String>();
    private  ArrayList<String> rationale = new ArrayList<String>();
    private ArrayList<String> effect = new ArrayList<String>();

    //implements the constructor of the Parcelable Interface
    public InputData() {
        super();
    }
    //read: get from the fields
    public InputData(Parcel parcel) {
        this.idea =parcel.readArrayList(null);
        this.rationale =parcel.readArrayList(null);
        this.effect =parcel.readArrayList(null);
    }

    public static final Creator<InputData> CREATOR = new Creator<InputData>() {
        @Override
        public InputData createFromParcel(Parcel in) {
            return new InputData(in);
        }

        @Override
        public InputData[] newArray(int size) {
            return new InputData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //store or write to the fields
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeList(this.idea);
        parcel.writeList(this.rationale);
        parcel.writeList(this.effect);
    }


    public ArrayList<String> getIdea() {
        return idea;
    }

    public void setIdea(ArrayList<String> idea) {
        this.idea = idea;
    }

    public ArrayList<String> getRationale() {
        return rationale;
    }

    public void setRationale(ArrayList<String> rationale) {
        this.rationale = rationale;
    }

    public ArrayList<String> getEffect() {
        return effect;
    }

    public void setEffect(ArrayList<String> effect) {
        this.effect = effect;
    }
}
