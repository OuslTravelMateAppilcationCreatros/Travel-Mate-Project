package com.example.travelmate;

public class PDataClass {

    private String dataTitle;
    private String dataDesc;
    private String dataLang;
    private String dataImage;
    private String key;

    public PDataClass() {
    }

    public PDataClass(String dataTitle, String dataDesc, String dataLang, String dataImage, String key) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
        this.key = key;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public String getDataLang() {
        return dataLang;
    }

    public void setDataLang(String dataLang) {
        this.dataLang = dataLang;
    }

    public String getDataImage() {
        return dataImage;
    }

    public void setDataImage(String dataImage) {
        this.dataImage = dataImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
