package com.example.shivamvk.miwok;

public class word {

    private static final int noImageProvided = -1;

    private String mDeafultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = noImageProvided;
    private int mAudioResourceId;

    public word(String deafaultTranslation, String miwokTranslation, int audioResourceId){
        mDeafultTranslation = deafaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    public word(String deafaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId){
        mDeafultTranslation = deafaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    public String getDeafultTranslation(){
        return mDeafultTranslation;
    }

    public String getMiwokTranslation(){
        return  mMiwokTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public int getAudioResourceId(){
        return mAudioResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != noImageProvided;
    }

}
