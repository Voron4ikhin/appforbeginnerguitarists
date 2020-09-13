package com.example.appforbeginnerguitarists;

public class ChordItem {
    private String mChordName;
    private int mChordImage;

    public ChordItem(String chordName, int chordImage){
        mChordName = chordName;
        mChordImage = chordImage;
    }

    public String getChordName(){
        return mChordName;
    }

    public int getChordImage(){
        return mChordImage;
    }

}
