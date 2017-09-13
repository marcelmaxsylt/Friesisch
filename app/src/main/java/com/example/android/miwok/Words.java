package com.example.android.miwok;

/**
 * Created by Marcel Laptop on 11.09.2017.
 */

public class Words {

    //the english defaultWord
    private String defaultWord;

    // the translated words, frisian
    private String translatedWord;

    // Drawable Resource ID // set this to the static value, so we know when theres no image (if theres an image it gets updated automatically
    private int imageRessourceID = NO_IMAGE_PROVIDED;

    //set this to -1 so its out of range of all the possible valid ids
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mediaResourceID;

    ////////////////////////////////////////////////////
    /*
    * Create a new Words object.
    *
    * @param defaultWord is the default Word (e.g. English German,...)
    * @param translatedWord is the translated Word  (e.g. Frisian)
    * */
    public Words(String defaultWord, String translatedWord) {
        this.defaultWord = defaultWord;
        this.translatedWord = translatedWord;

    }

    /*
       * Create a new Words object.
       *
       * @param defaultWord is the default Word (e.g. English German,...)
       * @param translatedWord is the translated Word  (e.g. Frisian)
       * @param image is drawable reference ID
       * */
    public Words(String defaultWord, String translatedWord, int mediaResourceID) {
        this.defaultWord = defaultWord;
        this.translatedWord = translatedWord;
        this.imageRessourceID = mediaResourceID;
    }

    /*
      * Create a new Words object.
      *
      * @param defaultWord is the default Word (e.g. English German,...)
      * @param translatedWord is the translated Word  (e.g. Frisian)
      * @param image is drawable reference ID
      * */
    public Words(String defaultWord, String translatedWord, int imageRessourceID, int mediaResourceID) {
        this.defaultWord = defaultWord;
        this.translatedWord = translatedWord;
        this.imageRessourceID = imageRessourceID;
        this.mediaResourceID = mediaResourceID;
    }



    //////////////////////////////////////////

    public String getDefaultWord() {
        return defaultWord.toString();
    }

    public String getTranslatedWord() {
        return translatedWord;
    }

    public int getImageRessourceID() {
        return imageRessourceID;
    }

    public int getMediaResourceID() {
        return mediaResourceID;
    }

    /*
        Returns wheter or not there is an image or not
         */
    public boolean hasImage(){
        if (imageRessourceID != NO_IMAGE_PROVIDED){
            return true;
        }else{
            return false;
        }

    }

}
