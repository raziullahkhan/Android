package com.example.android.miwok;

public class Word {
    private String defaultMiwokTranslation;
    private String miwokTranslation;
    private int imageResource;
    private int audioResource;

    public Word(String defaultMiwokTranslation, String miwokTranslation,int audioResource) {
        this.defaultMiwokTranslation = defaultMiwokTranslation;
        this.miwokTranslation = miwokTranslation;
        this.audioResource=audioResource;
    }

    public Word(String defaultMiwokTranslation, String miwokTranslation, int imageResource,int audioResource) {
        this.defaultMiwokTranslation = defaultMiwokTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResource = imageResource;
        this.audioResource=audioResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getDefaultMiwokTranslation() {
        return defaultMiwokTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getAudioResource() {
        return audioResource;
    }
}
