package com.example.miwok;

import android.widget.ImageView;

public class Word {

    private String mDefaultTranslation;

    private String mMiwokTranslation;

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    private int mMediaResourceId;


    public Word(String defaultTranslation , String miwokTranslation , int mediaResourceId ){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMediaResourceId = mediaResourceId;
    }

    public Word(String defaultTranslation , String miwokTranslation , int imageResourceId , int mediaResourceId ){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mMediaResourceId = mediaResourceId;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public int getMediaResourceId(){
        return mMediaResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
